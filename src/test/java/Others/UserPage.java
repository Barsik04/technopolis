package Others;

import Tests.SendGiftTest;
import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserPage {
    WebDriver driver;
    //    локатор раздела фото на странице польователя
    static final String PHOTO_NAV = ".//a[contains(@class,'mctc_navMenuSec ') and contains(@href,'/photos')] ";
    //    локатор лайка
    static final String LIKE = ".//ul[contains(@data-l,'t,actions')]//div//span[contains(@data-like-icon,'like')]";
    //    локатор активного лайка
    static final String LIKE_IS_ACTIVE = ".//ul[contains(@data-l,'t,actions')]//div/div/span[contains(@data-l,'t,unlike')]";
    //    локатор фото
    static final String USER_PHOTO_LOCATOR = ".//div[contains(@class,'ugrid_cnt')]/li[contains(@class,'ugrid_i')]//a[contains(@class,'photo-card_cnt')]";
    //
    static final String SEND_GIFT = "(//a[contains(text(),'Сделать подарок')])[1]";
    static final String CHOOSE_GIFT = "(.//a[@class='gift_a'])[1]";
    static final String CHECK_PRIVATE = "//label[contains(@class,'checkbox') and contains(@for,'private')]";
    static final String SEND = "//button[contains(@class,'send')]";
    static final String GIFTS_COUNTER = "//a[@class='gift_a']";
    static final String GO_TO_GIFTS = "//a[contains(@class, 'mctc_navMenuDDLIL') and contains(text(),'Подарки')]";
    private String DELETE = "//*[contains(text(), 'Удалить из друзей')]";
    private String GO_TO_MY = "//div[@id='topPanelLeftCorner']";
    private String CHOOSE_FRIEND = "(.//a[@class='user-grid-card_img'])[1]";

    private String MAIN = "//div[@id='topPanelLeftCorner']";
    private String TRID = "//span[contains(@class,'u-menu_a toggle-dropdown')]/*[contains(@class,'svg-ic svg-ico_more_16')]";
    private String FRIEND = "//a[@data-l = 't,userFriend']";
    private String FRIEND_LIST = "//div[@class='user-grid-card']";
    static final String ESE = "//span[@id='mctc_navMenuDropdownSec_otherSections']/span";
    private String CONFIRM = "//input[contains(@data-l, 'confirm')]";




    private int start = -1;
    private int end = -1;


    private String name;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLike(int n) throws InterruptedException {
        List<WrapperHelper> pw = new WrapperHelper(this.driver, USER_PHOTO_LOCATOR).getElements();
        pw.get(0).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //если лайка нет, то кликаем по нему
        if (!driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed() && driver.findElement(By.xpath(LIKE)).isDisplayed()) {
            driver.findElement(By.xpath(LIKE)).click();
        }
        //проверяем нажатость класса
        assert (driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed());

    }

    public void goToFriendPhoto() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(PHOTO_NAV)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void sendGift(String name) {
        driver.switchTo().defaultContent();
        this.name = name;
        start = checkGifts();
        System.out.println("было " + start);

        WebElement send = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEND_GIFT)));

        send.click();

        WebElement selectGifr = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHOOSE_GIFT)));

        selectGifr.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modal-new_payment-frame']")));

        System.out.println("переключились на другой фрейм");

        driver.findElement(By.xpath(SEND)).click();


        driver.switchTo().defaultContent();


        end = checkGifts();
        System.out.println("стало " + end);
        Assert.assertTrue("Подарок не пришел!", isChange());

    }

    public boolean isChange() {

        return start < end;
    }

    public int checkGifts() {
        driver.findElement(By.xpath(ESE)).click();
        driver.findElement(By.xpath(GO_TO_GIFTS)).click();
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
        int n = driver.findElements(By.xpath(GIFTS_COUNTER)).size();
        driver.findElement(By.xpath("//*[text()='" + this.name + "']")).click();

        return n;
    }

    public void deleteFromFriend() {


        //WebElement chooseFriend = (new WebDriverWait(driver, 10))
        //       .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHOOSE_FRIEND)));

        //chooseFriend.click();

        WebElement triT = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TRID)));


        triT.click();


        WebElement del = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE)));
        del.click();
        //System.out.println("кардочек ");

        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
        ConfirmPage cf = new ConfirmPage(driver);
        cf.confirm();



    }

    public void res() {
        Assert.assertTrue("Все прошло успешно", end < start);
    }


    public void goToMain() {
        WebElement triT = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GO_TO_MY)));

        triT.click();

    }


    public ConfirmPage conf() {

        driver.findElement(By.xpath(DELETE)).click();
        return new ConfirmPage(driver);
    }


}
