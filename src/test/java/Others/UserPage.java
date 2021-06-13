package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserPage {

    WebDriver driver;

    static final String USER_PHOTO_LOCATOR = ".//div[contains(@class,'ugrid_cnt')]/li[contains(@class,'ugrid_i')]//a[contains(@class,'photo-card_cnt')]";



    static final String GO_TO_GIFTS = "//a[contains(@class, 'mctc_navMenuDDLIL') and contains(text(),'Подарки')]";
    private String DELETE = "//*[contains(text(), 'Удалить из друзей')]";
    private String GO_TO_MY = "//div[@id='topPanelLeftCorner']";


    private String TRID = "//span[contains(@class,'u-menu_a toggle-dropdown')]/*[contains(@class,'svg-ic svg-ico_more_16')]";

    static final String ESE = "//span[@id='mctc_navMenuDropdownSec_otherSections']/span";




    private String SGIFT = "//*[@class=\"gift-card __s __stub\"]";


    private int start = -1;
    private int end = -1;


    private String name = "Vitaly Timakov";

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }


    public void sendGift() throws InterruptedException {


        goToGiftList();


        GiftPage gp = new GiftPage(driver);
        gp.confirmGift();


    }

    public void goToGiftList() {
        driver.findElement(By.xpath(ESE)).click();
        driver.findElement(By.xpath(GO_TO_GIFTS)).click();

    }




    public void deleteFromFriend() {


        WebElement triT = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TRID)));


        triT.click();


        WebElement del = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DELETE)));
        del.click();


        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
        ConfirmPage cf = new ConfirmPage(driver);
        cf.confirm();


    }


    public void goToMain() {
        WebElement triT = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GO_TO_MY)));

        triT.click();

    }


    private boolean hasXpath(String xPath) {

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        return element.isDisplayed();
    }

    public List<WrapperHelper> getElements() {
        List<WrapperHelper> list = new ArrayList<WrapperHelper>();
        if (hasXpath(USER_PHOTO_LOCATOR)) {
            for (WebElement elem : driver.findElements(By.xpath(USER_PHOTO_LOCATOR))) {
                list.add(new WrapperHelper(elem, driver));

            }
            return list;
        }
        return Collections.emptyList();
    }

}
