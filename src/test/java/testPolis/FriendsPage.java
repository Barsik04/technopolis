package testPolis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FriendsPage {
    WebDriver driver;
    //    String NAMES_SEARCH_LOCATOR1=".//input[contains(@type, 'text')  and contains(@placeholder, 'Поиск')]";
    String NAMES_SEARCH_LOCATOR = ".//input[contains(@type,'text') and contains(@placeholder,'Введите имя или название') ]";
    String USER_NAME_LOCATOR = ".//a[contains(@href,'/profile/' )]/div[contains(@class,'sm_')]";
    String SEARCH_FRIEND_BUTTON = ".//button/span[contains(.,'Найти')]";

    FriendsPage(WebDriver driver) {
        this.driver = driver;

    }


    public void searchName(String name) throws InterruptedException {
        Thread.sleep(3000);
//        driver.wait(3000);
        WebElement element = driver.findElement(By.xpath(NAMES_SEARCH_LOCATOR));

        element.click();
        element.sendKeys(name);
        driver.findElement(By.xpath(SEARCH_FRIEND_BUTTON)).click();
        //element.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        List<UsersWrapper> friendsList = new UsersWrapper(this.driver).getUsers();


        selectFriend(4, friendsList);

    }


    public UserPage selectFriend(int n, List<UsersWrapper> list) {
        list.get(n).click();
        return new UserPage(driver);
    }
}
