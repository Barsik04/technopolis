package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyPage {
    WebDriver driver;
    static final String FRIENDS_LOCATOR = ".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";
    static final String MESSAGES = ".//*[@data-l='t,messages']";
    static final String ADD_PHOTO = ".//div[@title='Добавить фото']";
    static final String NAMES_SEARCH_LOCATOR = ".//input[contains(@type,'text') and contains(@placeholder,'Введите имя или название') ]";
    static final String SEARCH_FRIEND_BUTTON = ".//button/span[contains(.,'Найти')]";
    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'' )]/div[contains(@class,'sm_')]";

    String FRIEND_LIST_PAGE = "//*[contains(@class,\"tico null\") and contains(text(), \"Друзья\")]";


    static final String FRIEND_LIST = "//*[contains(text(),\"Друзья\") and contains(@class,\"tico\") ]";

    MyPage(WebDriver driver) {
        this.driver = driver;

    }

    public UserPage goToSearchFriends(int n, String name) {
//        Thread.sleep(3000);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

        WebElement element = driver.findElement(By.xpath(NAMES_SEARCH_LOCATOR));//Поиск строки ввода


        element.sendKeys(name);
        driver.findElement(By.xpath(SEARCH_FRIEND_BUTTON)).click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WrapperHelper> friendsList = getElements();//Поиск и оборачивание всех элементов для дальнейшей работы с ними


        friendsList.get(n).click();

        return new UserPage(driver);

    }


    public void goToFriendList() {
        WebElement btn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIEND_LIST_PAGE)));

        btn.click();
    }


    private boolean hasXpath(String xPath) {

        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        return element.isDisplayed();
    }

    public List<WrapperHelper> getElements() {
        List<WrapperHelper> list = new ArrayList<WrapperHelper>();
        if (hasXpath(USER_NAME_LOCATOR)) {
            for (WebElement elem : driver.findElements(By.xpath(USER_NAME_LOCATOR))) {
                list.add(new WrapperHelper(elem, driver));

            }
            return list;
        }
        return Collections.emptyList();
    }
}
