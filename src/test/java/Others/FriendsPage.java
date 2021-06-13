package Others;


import org.openqa.selenium.WebDriver;




public class FriendsPage {
    WebDriver driver;
    static final String NAMES_SEARCH_LOCATOR = ".//input[contains(@type,'text') and contains(@placeholder,'Введите имя или название') ]";

    static final String SEARCH_FRIEND_BUTTON = ".//button/span[contains(.,'Найти')]";
    static final String USER_NAME_LOCATOR = ".//a[contains(@href,'' )]/div[contains(@class,'sm_')]";

    FriendsPage(WebDriver driver) {
        this.driver = driver;
    }






}
