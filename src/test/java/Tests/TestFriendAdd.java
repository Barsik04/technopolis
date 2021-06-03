package Tests;

//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто

import Others.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class TestFriendAdd extends BaseTest {





    public String name = "Vitaly Timakov";



    @Test
    public void testUntitledTestCase() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        MyPage myPage = loginPage.doLogin();
        //myPage.checkDeleteFriend();

    }




}
