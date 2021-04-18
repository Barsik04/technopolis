package testPolis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    WebDriver driver;
    String FRIENDS_LOCATOR=".//*[contains(@class, 'navigation')]/div/a/div[contains(., 'Друзья')]";

    UserPage(WebDriver driver){
        this.driver = driver;

    }

}
