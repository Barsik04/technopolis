
import org.junit.*;

public class UntitledTestCase extends BaseTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="79991095900";
    String password ="region56";



    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = loginPage.doLogin(username, password);
        driver.wait(10000);
        FriendsPage fp = userPage.doSearch();
       fp.searchName("ASD");
       System.in.read();



    }



}
