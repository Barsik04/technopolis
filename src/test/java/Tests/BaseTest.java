package Tests;


import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    public static ChromeDriver driver;

    private String baseUrl="https://ok.ru";

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C://chormeDriver/chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://ok.ru");


    }


}
