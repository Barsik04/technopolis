import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    WebDriver driver;
    String FRIENDS_LOCATOR=".//*[contains(@class, 'navigation')]/div/a/div[contains(., 'Друзья')]";

    UserPage(WebDriver driver){
        this.driver = driver;

    }
    public FriendsPage doSearch(){

        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

    return new FriendsPage(driver);

    }
}
