package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class RestorePasswordTest extends BaseTest{

    @Test(description = "Проверка загрузки страницы Восстановление пароля")
    @Issue("Test-117")
    @Link("Test-227")
    @TmsLink("Moysklad")
    @Description("Проверка загрузки страницы восстановления пароля")
    @Severity(SeverityLevel.NORMAL)
    void clickForgotPasswordButton(){
        log.info("Переход на страницу восстановления пароля");

        loginPage.open();
        loginPage.isPageOpened();
        restorePasswordPage.clickForgotPasswordButton();

        step("Ожидаемый результат: страница восстановления пароля пользователя открыта", () ->
        assertTrue(restorePasswordPage.isPageOpened(),"Веб-страница не отвечает"));
    }
}
