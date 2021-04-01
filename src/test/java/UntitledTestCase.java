
import org.junit.*;

public class UntitledTestCase extends BaseTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="Test";
    String passswrd ="Test";



    @Test
    public void testUntitledTestCase() throws Exception {
        UserPage userpage = new LoginPage(driver).doLogin(username, passswrd);



    }



}
