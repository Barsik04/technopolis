package testPolis;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class UntitledTestCase extends BaseTest {
    WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username = "79991095900";
    String password = "Region56";


    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin(username, password);

        FriendsPage fp = myPage.goToSearchFriends();
        fp.searchName("Патриарх Кирилл");
        UsersWrapper user=new UsersWrapper(driver);
        ArrayList<UsersWrapper> usersCards=getUsers();

        System.in.read();


    }


}
