
import org.junit.*;

public class UntitledTestCase extends BaseTest {

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username = "";
    String password = "";


    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin(username, password);

        FriendsPage fp = myPage.goToSearchFriends();
        fp.searchName("Патриарх Кирилл");


        System.in.read();


    }


}
