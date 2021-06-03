package Tests;//
//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто

import Others.*;
import org.junit.Assert;
import org.junit.Test;


public class SendGiftTest extends BaseTest {

    static final String username = "89270054472";
    static final String password = "4815162342Nikita";
    public String name = "Vitaly Timakov";

    @Test
    public void testUntitledTestCase() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();

        FriendsPage fp = myPage.goToSearchFriends();//Переход на страницу поиска друзей
        UserPage up = fp.selectFriend(0,name);//Получение страницы, с номером относительно верхнего
        up.sendGift(name);
        //Assert.assertTrue("Подарок не пришел",up.isChange());

        // up.goToFriendPhoto();
        //up.setLike(1);

    }




}
