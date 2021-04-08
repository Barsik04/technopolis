import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FriendsPage {
    WebDriver driver;
    String NAMES_SEARCH_LOCATOR1=".//input[contains(@type, 'text')  and contains(@placeholder, 'Поиск')]";
    String NAMES_SEARCH_LOCATOR=".//div[contains(@class,'friend')]//input";
    FriendsPage(WebDriver driver){
        this.driver = driver;

    }


    public void searchName(String name) throws InterruptedException {
        Thread.sleep(3000);
//        driver.wait(3000);
        WebElement element = driver.findElement(By.xpath(NAMES_SEARCH_LOCATOR));
        System.out.println("ITS OK");
        element.click();
        element.sendKeys(name);
        element.sendKeys(Keys.ENTER);

        System.out.println("x2");



    }


    public UserPage selectFriend(int n) {
        //Выбрать i-го человечка


return new UserPage(driver);
    }
}
