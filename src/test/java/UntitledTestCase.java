
import org.junit.*;

public class UntitledTestCase extends BaseTest{

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username="";
    String password ="";



    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        MyPage userPage = loginPage.doLogin(username, password);

        FriendsPage fp = userPage.goToSearchFriends();
       fp.searchName("Патриарх Кирилл");
       UserPage up = fp.selectFriend(4);
       //up do smng;
       System.in.read();



    }



}
