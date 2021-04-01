
import org.junit.*;

public class UntitledTestCase extends BaseTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="89270054472";
    String password ="4815162342Nikita";



    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.doLogin(username, password);
        userPage.doSearch();
        FriendsPage fp = userPage.doSearch();
        fp.searchName("Патриарх Кирилл");

System.in.read();

    }



}
