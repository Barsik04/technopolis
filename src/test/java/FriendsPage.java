import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FriendsPage {
    WebDriver driver;
//    String NAMES_LOCATOR=".//input[contains(@type, 'text') and contains(@placeholder, 'Поиск')]";
    String NAMES_LOCATOR=".//span[contains(@class,'left-icon__t53m6 left-icon__9mvah')]";


    FriendsPage(WebDriver driver){
        this.driver = driver;

    }


    public void searchName(String name) throws InterruptedException{
        WebElement element = driver.findElement(By.xpath(NAMES_LOCATOR));
        System.out.println("ITS OK");
//        driver.wait(10000);
        element.click();
        System.out.println("x2");
        element.sendKeys(name);


    }
}
