package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MyPage {
    WebDriver driver;
    static final String FRIENDS_LOCATOR=".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";
    static final String MESSAGES = ".//*[@data-l='t,messages']";
    static final String ADD_PHOTO=".//div[@title='Добавить фото']";
    MyPage(WebDriver driver){
        this.driver = driver;

    }
    public FriendsPage goToSearchFriends() throws InterruptedException{
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

    return new FriendsPage(driver);

    }

    public void goToMessage(){

        driver.findElement(By.xpath(MESSAGES)).click();

    }

    public void uploadImage(){

        WebElement UploadImg = driver.findElement(By.xpath(ADD_PHOTO));
        UploadImg.click();
        UploadImg.sendKeys("C:\\test1.png");


    }
}
