
import org.junit.*;

public class UntitledTestCase extends BaseTest{
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="79991095900";
    String password ="Region56";



    @Test
    public void testUntitledTestCase() throws Exception {
        UserPage userpage = new LoginPage(driver).doLogin(username, password);



    }



}
