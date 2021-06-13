package Tests;



import Others.*;
import org.junit.Assert;
import org.junit.Test;



public class TestFriendDelete extends BaseTest {


    public String name = "Vitaly Timakov";


    @Test
    public void testUntitledTestCase() throws Exception {

        int start = -1;
        int end = -1;


        LoginPage loginPage = new LoginPage(driver);//Инициализация стартовой страницы
        MyPage myPage = loginPage.doLogin();

        myPage.goToFriendList();//переход на страницу с друзьями и их подсчет
        FriendListPage friendList = new FriendListPage(driver);
        start = friendList.friendCount();
        System.out.println("Имеем друзей " + start);

        friendList.goToMyPage();//Возврат к главной странице

        UserPage up = myPage.goToSearchFriends(0, name);//Поиск друга и переход на его страницу

        up.deleteFromFriend(); //Удаление друга

        up.goToMain();//Возврат на главную страницу

        myPage.goToFriendList();//Подсчет друзей после действия
        end = friendList.friendCount();
        System.out.println("На выходе" + end);

        Assert.assertTrue("Количество друзей не изменилось!", start == (end + 1));//Вывод ошибки при неизменном количестве друзей

    }


}
