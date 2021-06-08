package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyPage {
    WebDriver driver;
    static final String FRIENDS_LOCATOR=".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";
    static final String MESSAGES = ".//*[@data-l='t,messages']";
    static final String ADD_PHOTO=".//div[@title='Добавить фото']";
    static final String NAMES_SEARCH_LOCATOR = ".//input[contains(@type,'text') and contains(@placeholder,'Введите имя или название') ]";
    static final String SEARCH_FRIEND_BUTTON = ".//button/span[contains(.,'Найти')]";
    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'' )]/div[contains(@class,'sm_')]";
    String NAME = "(//div[contains(@class, 'card')]/a/div)[1]";
    String GO_TO_LIST =".//div[contains(@class, 'portlet')]//div[text()= 'Найти друзей']";
    String FRIEND_LIST_PAGE = "//*[contains(@class,\"tico null\") and contains(text(), \"Друзья\")]";


    static final String FRIEND_LIST = "//*[contains(text(),\"Друзья\") and contains(@class,\"tico\") ]";
    MyPage(WebDriver driver){
        this.driver = driver;

    }
    public UserPage goToSearchFriends(int n, String name) throws InterruptedException{
//        Thread.sleep(3000);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(FRIENDS_LOCATOR)).click();

        WebElement element = driver.findElement(By.xpath(NAMES_SEARCH_LOCATOR));//Поиск строки ввода

        //element.click();//клик и ввод туда фамилии и иммени
        element.sendKeys(name);
        driver.findElement(By.xpath(SEARCH_FRIEND_BUTTON)).click();
        //element.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WrapperHelper> friendsList = new WrapperHelper(this.driver,USER_NAME_LOCATOR).getElements();//Поиск и оборачивание всех элементов для дальнейшей работы с ними


       // driver.findElement(By.xpath(NAME)).click();

        friendsList.get(n).click();

    return new UserPage(driver);

    }

    public void goToMessage(){

        driver.findElement(By.xpath(MESSAGES)).click();

    }


    public void goToFriendList(){
        WebElement btn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FRIEND_LIST_PAGE)));

        btn.click();
    }



    public void uploadImage(){

        WebElement UploadImg = driver.findElement(By.xpath(ADD_PHOTO));
        UploadImg.click();
        UploadImg.sendKeys("C:\\test1.png");


    }
}
