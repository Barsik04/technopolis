package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    public static ChromeDriver driver;

    private String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C://chormeDriver/chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://ok.ru");


    }


}
