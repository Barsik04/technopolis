import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class UserPage {
    WebDriver driver;
    String FRIENDS_LOCATOR=".//*[contains(@class, 'navigation')]/div/a/div[contains(., 'Друзья')]";
//    локатор раздела фото на странице польователя
    String PHOTO_NAV=".//a[contains(@class,'mctc_navMenuSec ') and contains(@href,'/photos')] ";
    String PHOTOS=".//div[contains(@class,'ugrid_cnt')]/li[contains(@class,'ugrid_i')]";
    String LIKE=".//ul[contains(@data-l,'t,actions')]//div//span[contains(@data-like-icon,'like')]";
    String LIKE_IS_ACTIVE=".//ul[contains(@data-l,'t,actions')]//div/div[contains(@class,'active')]";
    UserPage(WebDriver driver){
        this.driver = driver;

    }
    public void setLike(int n) throws InterruptedException{
        Actions action=new Actions(driver);
        List<PhotosWrapper> pw=new PhotosWrapper(this.driver).getPhotos();
        pw.get(0).click();
        Thread.sleep(3000);
        //если лайка нет, то кликаем по нему
        if(!driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed()) {
            driver.findElement(By.xpath(LIKE)).click();
        }
        //проверяем нажатость класса
        assert(driver.findElement(By.xpath(LIKE_IS_ACTIVE)).isDisplayed());

    }

    public void goToFriendPhoto() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath(PHOTO_NAV)).click();
        Thread.sleep(3000);
    }

}
