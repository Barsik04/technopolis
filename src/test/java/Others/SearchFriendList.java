package Others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchFriendList {
WebDriver driver;
    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'' )]/div[contains(@class,'sm_')]";


    public SearchFriendList(WebDriver driver) {
        this.driver = driver;
    }


    public UserPage goToFriend (int n){

        List<WrapperHelper> friendsList = new WrapperHelper(this.driver,USER_NAME_LOCATOR).getElements();//Поиск и оборачивание всех элементов для дальнейшей работы с ними


        friendsList.get(n).click();
        return new UserPage(driver);


    }



}
