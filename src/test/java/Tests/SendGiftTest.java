package Tests;//
//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто

import Others.*;
import org.junit.Assert;
import org.junit.Test;


public class SendGiftTest extends BaseTest {

    static final String username = "";
    static final String password = "";
    public String name = "Vitaly Timakov";

    @Test
    public void testUntitledTestCase() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();

        FriendsPage fp = myPage.goToSearchFriends();//Переход на страницу поиска друзей
        UserPage up = fp.selectFriend(0,name);//Получение страницы, с номером относительно верхнего
        up.sendGift(name);


    }




}
