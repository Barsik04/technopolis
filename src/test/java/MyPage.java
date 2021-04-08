import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPage {
    WebDriver driver;
    String FRIENDS_LOCATOR=".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";

    MyPage(WebDriver driver){
        this.driver = driver;

    }
    public FriendsPage goToSearchFriends() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

    return new FriendsPage(driver);

    }
}
