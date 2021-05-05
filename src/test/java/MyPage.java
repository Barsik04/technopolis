import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MyPage {
    WebDriver driver;
    static final String FRIENDS_LOCATOR=".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";

    MyPage(WebDriver driver){
        this.driver = driver;

    }
    public FriendsPage goToSearchFriends() throws InterruptedException{
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

    return new FriendsPage(driver);

    }
}
