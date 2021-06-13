package Tests;

import Others.*;
import org.junit.Test;


public class LogTest extends BaseTest {


    @Test
    public void testUntitledTestCase() throws Exception {


        LoginPage loginPage = new LoginPage(driver);//заход на страницу логина
        loginPage.loginTest("451", "", false);//логин/проль/bool выражение сигнализирующее о том должны ли мы пройти "дальше"
        loginPage.loginTest("", "451", false);
        loginPage.loginTest("89270054472", "4815162342Nikita", true);

    }


}
