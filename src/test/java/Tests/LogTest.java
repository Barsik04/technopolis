package Tests;//
//Главный класс.
//Кейс состоит в том, чтобы найти конкретного польователя, зайти на его страницу,
// найти конкретное по номеру фото и лайкнуть его, если оно не лайкнуто
import Others.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class LogTest extends BaseTest {




    @Test
    public void testUntitledTestCase() throws Exception {


        LoginPage loginPage = new LoginPage(driver);//заход на главную страницу
        MyPage myPage = loginPage.testLogin();//Работа с главной страницей и логин


    }


}
