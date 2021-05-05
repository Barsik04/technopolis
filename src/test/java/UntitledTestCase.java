//
//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто
import org.junit.Test;

public class UntitledTestCase extends BaseTest {

    static final String username = "";
    static final String password = "";


    @Test
    public void testUntitledTestCase() throws Exception {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);//заход на главную страницу
        MyPage myPage = loginPage.doLogin(username, password);//Работа с главной страницей и логин

        FriendsPage fp = myPage.goToSearchFriends();//Переход на страницу поиска друзей
        UserPage up = fp.selectFriend(0, "Патриарх Кирилл");//Получение страницы, с номером относительно верхнего
        up.goToFriendPhoto();
        up.setLike(1);

    }


}
