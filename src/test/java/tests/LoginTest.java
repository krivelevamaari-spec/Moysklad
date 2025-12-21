package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class LoginTest extends BaseTest {

    @DataProvider(name = "Negative data")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "2009198916", "Чтобы войти, укажите имя пользователя"},
                {"admin@esfmf", "", "Чтобы войти, укажите пароль"},
                {"", "", "Чтобы войти, укажите имя пользователя"},
                {"adminesfmf", "2009198916", "Неверный формат имени пользователя. " +
                        "Укажите свою учетную запись, например admin@romashka."},
                {"1111111", "2009198916", "Неверный формат имени пользователя. " +
                        "Укажите свою учетную запись, например admin@romashka."},
                {"admin$esfmf", "2009198916", "Неверный формат имени пользователя. " +
                        "Укажите свою учетную запись, например admin@romashka."},
                {"admin@netTakogoDoMena56.com", "2009198916", "Неправильный пароль или имя пользователя. " +
                        "Посмотрите, что можно сделать."},
                {" admin@esfmf", "2009198916", "Неправильный пароль или имя пользователя. " +
                        "Посмотрите, что можно сделать."}
        };
    }

    @Test(dataProvider = "Negative data", description = "Проверка отображения ошибки при вводе некорректных данных")
    @Issue("Test-110")
    @Link("Test-220")
    @TmsLink("Moysklad")
    @Description("Проверка отображения ошибки при вводе некорректных данных")
    @Severity(SeverityLevel.NORMAL)
    public void errorMessages(String email, String password, String errorMessage) {
        loginPage.open();
        loginPage.loginEntry(email);
        loginPage.passwordEntry(password);
        loginPage.clickPrimaryButton();

        log.info("Получено сообщение об ошибке:" + loginPage.getErrorMessage());

        step("Ожидаемый результат: Неверный формат имени пользователя. " +
                "Укажите свою учетную запись, например admin@romashka.", () ->
                assertEquals(loginPage.getErrorMessage(),
                        errorMessage, "Неверное сообщение об ошибке"));
    }

    @Test(description = "Проверка загрузки страницы авторизации")
    @Issue("Test-111")
    @Link("Test-221")
    @TmsLink("Moysklad")
    @Description("Проверка загрузки страницы авторизации")
    @Severity(SeverityLevel.CRITICAL)
    void loginPageShouldOpen() {
        log.info("Открытие страницы авторизации");
        loginPage.open();

        step("Ожидаемый результат: страница авторизации пользователя открыта", () ->
                assertTrue(loginPage.isPageOpened(), "Веб-страница не отвечает"));
    }

    @Test(description = "Проверка успешной авторизации с валидным логином и паролем " +
            "с последующим переходом на главную страницу")
    @Issue("Test-112")
    @Link("Test-222")
    @TmsLink("Moysklad")
    @Description("Проверка успешной авторизации с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    void userMustEnterValidLoginAndPassword() {
        log.info("Открытие страницы авторизации");
        loginPage.open();
        loginPage.isPageOpened();

        log.info("Ввод валидных учетных данных: логин='admin@esfmf', пароль='2009198916'");
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        step("Ожидаемый результат: авторизация прошла успешно, пользователь перенаправлен на главную страницу",
                () ->
                        assertTrue(homePage.isPageOpened(), "Веб-страница не отвечает"));
    }

    @Test(description = "Проверка отображения ошибки при вводе пароля с использованием букв")
    @Issue("Test-113")
    @Link("Test-223")
    @TmsLink("Moysklad")
    @Description("Проверка отображения ошибки при вводе неккоректного пароля")
    @Severity(SeverityLevel.NORMAL)
    void entryPasswordWithLetters() {
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf")
                  .passwordEntry("huhu2009")
                  .clickPrimaryButton();

        log.info("Получено сообщение об ошибке:" + loginPage.getErrorMessage());

        step("Ожидаемый результат: неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                () ->
                        assertEquals(loginPage.getErrorMessage(),
                                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                                "Текст не совпадает"));
    }
}
