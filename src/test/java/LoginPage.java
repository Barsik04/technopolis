import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
     WebDriver driver;
    String LOGIN_LOCATOR=".//*[contains(@class, 'form')]/div/input[@type='text']";
    String PASSWORD_LOCATOR=".//*[contains(@class, 'form')]/div/input[@type='password']";
    String SUBMIT_LOCATOR=".//*[contains(@class, 'form')]/div/input[contains(@value, 'Войти') or contains(@value, 'войти')]";




    LoginPage(WebDriver driver){
        this.driver = driver;
        check();
    }

protected void check(){

}

public UserPage doLogin(String username, String password) {

    driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(username);
    driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
    driver.findElement(By.xpath(SUBMIT_LOCATOR)).click();





    return new UserPage(driver);

}


}
