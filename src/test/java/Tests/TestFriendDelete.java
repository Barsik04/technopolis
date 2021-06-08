package Tests;

//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто

import Others.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class TestFriendDelete extends BaseTest {


    public String name = "Vitaly Timakov";


    @Test
    public void testUntitledTestCase() throws Exception {

        int start = -1;
        int end = -1;


        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();

        myPage.goToFriendList();
        FriendListPage friendList = new FriendListPage(driver);
        start = friendList.friendCount();
        System.out.println("Имеем друзей " + start);

        friendList.goToMyPage();

        UserPage up = myPage.goToSearchFriends(0, "Vitaly Timakov");

        up.deleteFromFriend();

        up.goToMain();

        myPage.goToFriendList();
        end = friendList.friendCount();
        System.out.println("На выходе" + end);

        Assert.assertTrue("Количество друзей не изменилось!", start==(end+1));

    }


}
