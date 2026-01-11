package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
@Log4j2

public class ValuesTest extends BaseTest{

    @Test
    void zapolnit (){
        log.info("Открытие страницы авторизации");
        loginPage.open();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();
        log.info("Переход на страницу настройки аккаунта");
        valuesPage.open();
        valuesPage.closeModalWindow();
        valuesPage.fillInValues();
     }
}
