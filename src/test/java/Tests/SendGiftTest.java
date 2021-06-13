package Tests;


import Others.*;
import org.junit.Assert;
import org.junit.Test;


public class SendGiftTest extends BaseTest {


    @Test
    public void testUntitledTestCase() throws Exception {

        int start = -1;
        int end = -1;


        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();

        myPage.goToFriendList();
        FriendListPage friendList = new FriendListPage(driver);


        UserPage up = myPage.goToSearchFriends(0, "Vitaly Timakov");
        GiftPage gp = new GiftPage(driver);
        start = gp.checkGifts();
        System.out.println("Имеем подарков " + start);


        up.sendGift();


        end = gp.checkGifts();


        System.out.println("На выходе подарков " + end);

        Assert.assertTrue("Количество друзей не изменилось!", start == (end + 1));

    }


}
