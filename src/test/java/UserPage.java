import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserPage {
    WebDriver driver;
//    локатор раздела фото на странице польователя
    static final String PHOTO_NAV=".//a[contains(@class,'mctc_navMenuSec ') and contains(@href,'/photos')] ";
//    локатор лайка
    static final String LIKE=".//ul[contains(@data-l,'t,actions')]//div//span[contains(@data-like-icon,'like')]";
//    локатор активного лайка
    static final String LIKE_IS_ACTIVE=".//ul[contains(@data-l,'t,actions')]//div/div/span[contains(@data-l,'t,unlike')]";
//    локатор фото
    static final String USER_PHOTO_LOCATOR = ".//div[contains(@class,'ugrid_cnt')]/li[contains(@class,'ugrid_i')]//a[contains(@class,'photo-card_cnt')]";

    UserPage(WebDriver driver){
        this.driver = driver;
    }

    public void setLike(int n) throws InterruptedException{
        List<WrapperHelper> pw=new WrapperHelper(this.driver,USER_PHOTO_LOCATOR).getElements();
        pw.get(0).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //если лайка нет, то кликаем по нему
        if(!driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed()&&driver.findElement(By.xpath(LIKE)).isDisplayed()) {
            driver.findElement(By.xpath(LIKE)).click();
        }
        //проверяем нажатость класса
        assert(driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed());

    }

    public void goToFriendPhoto() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(PHOTO_NAV)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

}
