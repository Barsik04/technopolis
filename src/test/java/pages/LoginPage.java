package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    static final String LOGIN_LOCATOR = ".//*[contains(@class, 'form')]/div/input[@type='text']";
    static final String PASSWORD_LOCATOR = ".//*[contains(@class, 'form')]/div/input[@type='password']";
    static final String SUBMIT_LOCATOR = ".//*[contains(@class, 'form')]/div/input[contains(@value, 'Войти') or contains(@value, 'войти')]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    public void check() {

    }

    public MyPage doLogin(String username, String password) {

        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(username);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
        driver.findElement(By.xpath(SUBMIT_LOCATOR)).click();
        return new MyPage(driver);

    }

}
