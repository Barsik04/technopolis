//
//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто
import org.junit.*;
import org.openqa.selenium.By;

public class UntitledTestCase extends BaseTest {

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    String username = "";
    String password = "";


    @Test
    public void testUntitledTestCase() throws Exception {
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);//заход на главную страницу
        MyPage myPage = loginPage.doLogin(username, password);//Работа с главной страницей и логин

        FriendsPage fp = myPage.goToSearchFriends();//Переход на страницу поиска друзей
        UserPage up = fp.selectFriend(0, "Патриарх Кирилл");//Получение страницы, с номером относительно верхнего
        up.goToFriendPhoto();
        up.setLike(1);


        //up.setLike() тебе надо написать

//        System.in.read();


    }


}
