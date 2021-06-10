package Others;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    WebDriver driver;
    static private final String username = "";
    static private final String password = "";

    static final String LOGIN_LOCATOR = ".//*[contains(@class, 'form')]/div/input[@type='text']";
    static final String PASSWORD_LOCATOR = ".//*[contains(@class, 'form')]/div/input[@type='password']";
    static final String SUBMIT_LOCATOR = ".//*[contains(@class, 'form')]/div/input[contains(@value, 'Войти') or contains(@value, 'войти')]";
    static final String ERROR = ".//*[@class='input-e login_error']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected void check() {

    }

    public void testLogin(String log, String pass, Boolean cond) {

        driver.findElement(By.xpath(LOGIN_LOCATOR)).clear();
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).clear();

        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(log);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(pass);
        driver.findElement(By.xpath(SUBMIT_LOCATOR)).click();

        Assert.assertFalse("Не выведена ошибка о пустом поле", existsElement(ERROR) && cond);



    }

    public MyPage doLogin() {

        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(username);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
        driver.findElement(By.xpath(SUBMIT_LOCATOR)).click();
        return new MyPage(driver);

    }

    private boolean existsElement(String id) {
        try {
            driver.findElement(By.xpath(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
