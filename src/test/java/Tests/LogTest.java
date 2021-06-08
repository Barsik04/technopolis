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


        LoginPage loginPage = new LoginPage(driver);//заход на страницу логина
        loginPage.testLogin("451", "", false);//логин/проль/bool выражение сигнализирующее о том должны ли мы пройти "дальше"
        loginPage.testLogin("", "451", false);
        loginPage.testLogin("89270054472", "4815162342Nikita", true);

    }


}
