import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FriendsPage {
    WebDriver driver;
    String NAMES_LOCATOR=".//input[contains(@type, 'text')  and contains(@placeholder, 'Поиск')]";


    FriendsPage(WebDriver driver){
        this.driver = driver;

    }


    public void searchName(String name){
        WebElement element = driver.findElement(By.xpath(NAMES_LOCATOR));
        element.click();
        element.sendKeys("ASd");


    }
}
