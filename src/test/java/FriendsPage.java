import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FriendsPage {
    WebDriver driver;
    String NAMES_LOCATOR=".//input[contains(@type, 'text')  and contains(@placeholder, 'Поиск')]";


    FriendsPage(WebDriver driver){
        this.driver = driver;

    }


    public void searchName(String name){
        driver.findElement(By.xpath(NAMES_LOCATOR)).click().sendKeys("ASD");


    }
}
