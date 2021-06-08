package Others;

import org.openqa.selenium.WebDriver;

public class GiftPage {
    WebDriver driver;

    GiftPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserPage checkFriendCount(){
        return new  UserPage(driver);
    }
}
