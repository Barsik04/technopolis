
import org.junit.*;

public class UntitledTestCase extends BaseTest {

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username = "";
    String password = "";


    @Test
    public void testUntitledTestCase() throws Exception {
        LoginPage loginPage = new LoginPage(driver);//заход на главную страницу
        MyPage myPage = loginPage.doLogin(username, password);//Работа с главной страницей и логин

        FriendsPage fp = myPage.goToSearchFriends();//Переход на страницу поиска друзей
        UserPage up = fp.selectFriend(1, "Патриарх Кирилл");//Получение страницы, с номером относительно верхнего


        //up.setLike() тебе надо написать

        System.in.read();


    }


}
