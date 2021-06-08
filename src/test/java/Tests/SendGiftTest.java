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

        int start = -1;
        int end = -1;


        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();

        myPage.goToFriendList();
        FriendListPage friendList = new FriendListPage(driver);


        UserPage up = myPage.goToSearchFriends(0, "Vitaly Timakov");
        start = up.checkGifts();
        System.out.println("Имеем подарков " + start);


        up.sendGift();


        end = up.checkGifts();


        System.out.println("На выходе подарков " + end);

        Assert.assertTrue("Количество друзей не изменилось!", start == (end + 1));

    }


}
