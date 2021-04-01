
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class UntitledTestCase extends BaseTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="Test";
    String pswrd="Test";



    @Test
    public void testUntitledTestCase() throws Exception {
        UserPage userpage = new LoginPage(driver).doLogin(username,pswrd);



    }



}
