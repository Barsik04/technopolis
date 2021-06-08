package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FriendsPage {
    WebDriver driver;
    static final String NAMES_SEARCH_LOCATOR = ".//input[contains(@type,'text') and contains(@placeholder,'Введите имя или название') ]";
//    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'/profile/' )]/div[contains(@class,'sm_')]";
    static final String SEARCH_FRIEND_BUTTON = ".//button/span[contains(.,'Найти')]";
    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'' )]/div[contains(@class,'sm_')]";

    FriendsPage(WebDriver driver) {
        this.driver = driver;
    }





    public UserPage selectFriend(int n,String name) throws InterruptedException {
        Thread.sleep(3000);//ожидание прогрузки
//        driver.wait(3000);
        WebElement element = driver.findElement(By.xpath(NAMES_SEARCH_LOCATOR));//Поиск строки ввода

        //element.click();//клик и ввод туда фамилии и иммени
        element.sendKeys(name);
        driver.findElement(By.xpath(SEARCH_FRIEND_BUTTON)).click();
        //element.sendKeys(Keys.ENTER);

        Thread.sleep(3000);//Ожидание прогрузки
        List<WrapperHelper> friendsList = new WrapperHelper(this.driver,USER_NAME_LOCATOR).getElements();//Поиск и оборачивание всех элементов для дальнейшей работы с ними




        friendsList.get(n).click();
        return new UserPage(driver);
    }
}
