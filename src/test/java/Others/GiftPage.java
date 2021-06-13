package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GiftPage {
    WebDriver driver;
    private String SGIFT = "//*[@class=\"gift-card __s __stub\"]";
    String SG = "(//*[@class=\"gift_a\"])[3]";
    String GTV = "//div/a[@class=\"o\"]";
    String SEND = "//button[contains(@class, \"send\")]";
    String NEW_FRAME = "//iframe[contains(@class,\"modal\")]";


    GiftPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserPage checkFriendCount() {
        return new UserPage(driver);
    }

    public void confirmGift() {


        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
        WebElement send = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(SGIFT)));
        if (send.isEnabled()) {
            send.click();
        } else {
            driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
            send.click();
        }


        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);


        WebElement sg = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SG)));
        sg.click();




        driver.switchTo().frame(driver.findElement(By.xpath(NEW_FRAME)));

        WebElement conf = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEND)));
        conf.click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
        WebElement toBack = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GTV)));
        toBack.click();
    }
}
