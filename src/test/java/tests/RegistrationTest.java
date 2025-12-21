package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class RegistrationTest extends BaseTest{

    @Test(description = "Проверка загрузки страницы Регистрация")
    @Issue("Test-116")
    @Link("Test-226")
    @TmsLink("Moysklad")
    @Description("Проверка загрузки страницы регистрации")
    @Severity(SeverityLevel.NORMAL)
    void clickRegistrationButton(){
        log.info("Переход на страницу регистрации");

        loginPage.open();
        loginPage.isPageOpened();
        registrationPage.clickRegistrationButton();

        step("Ожидаемый результат: страница регистрации пользователя открыта", () ->
        assertTrue(registrationPage.isPageOpened(),"Веб-страница не отвечает"));
    }
}
