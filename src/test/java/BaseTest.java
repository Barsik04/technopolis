import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
     WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C://chormeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://ok.ru");


    }


    @After
    public void strop(){
        driver.quit();
    }
}
