package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FriendListPage {

    WebDriver driver;
    private String FRIEND = "//a[@data-l = 't,userFriend']";
    private String FRIEND_LIST = "//div[@class='user-grid-card']";
    private String GO_TO_MY = "//div[@id='topPanelLeftCorner']";


    public FriendListPage(WebDriver driver) {
        this.driver = driver;
    }


    public int friendCount() {


        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        return driver.findElements(By.xpath(FRIEND_LIST)).size();

    }

    public MyPage goToMyPage() {
        WebElement triT = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GO_TO_MY)));

        triT.click();
        return new MyPage(driver);
    }

}
