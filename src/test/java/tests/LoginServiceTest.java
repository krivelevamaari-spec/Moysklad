package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class LoginServiceTest extends BaseTest{

    @Test(description = "Проверка загрузки страницы Логин сервиса")
    @Issue("Test-114")
    @Link("Test-224")
    @TmsLink("Moysklad")
    @Description("Проверка загрузки страницы логин сервиса")
    @Severity(SeverityLevel.NORMAL)
    void clickOneCButton(){
        log.info("Переход на логин сервис");

        loginPage.open();
        loginPage.isPageOpened();
        loginService.clickOneCButton();

        step("Ожидаемый результат: страница логин сервиса открыта", () ->
        assertTrue(loginService.isPageOpened(),"Веб-страница не отвечает"));
    }
}

