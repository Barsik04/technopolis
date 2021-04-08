import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPage {
    WebDriver driver;
    String FRIENDS_LOCATOR=".//*[contains(@class, 'navigation')]/div/a/div[contains(., 'Друзья')]";

    MyPage(WebDriver driver){
        this.driver = driver;

    }
    public FriendsPage goToSearchFriends(){

        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

    return new FriendsPage(driver);

    }
}
