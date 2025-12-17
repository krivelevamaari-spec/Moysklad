package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Owner("masha")
public class LoginTest extends BaseTest{

    @DataProvider(name = "Negative data")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "2009198916", "Чтобы войти, укажите имя пользователя"},
                {"admin@esfmf", "", "Чтобы войти, укажите пароль"},
                {"", "", "Чтобы войти, укажите имя пользователя"},
                {"adminesfmf", "2009198916", "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka."},
        };
    }

    @Test(dataProvider = "Negative data")
    @Description("Проверка отображения ошибки при вводе некорректных данных")
    @Severity(SeverityLevel.NORMAL)

    public void errorMessages(String email, String password, String errorMessage) {
        loginPage.open();
        loginPage.loginEntry(email);
        loginPage.passwordEntry(password);
        loginPage.clickPrimaryButton();

        step("Ожидаемый результат: Чтобы войти, укажите данные", () ->
                assertEquals(loginPage.getErrorMessage(),
                        errorMessage, "Неверное сообщение об ошибке"));

    }


    @Test(description = "Проверка загрузки страницы авторизации")
    @Description("Проверка загрузки страницы авторизации")
    @Severity(SeverityLevel.CRITICAL)
    void loginPageShouldOpen(){
        loginPage.open();

        step("Ожидаемый результат: страница авторизации пользователя открыта", () ->
        assertTrue(loginPage.isPageOpened(),"Веб-страница не отвечает"));
    }

    @Test(description = "Проверка правильной авторизации с валидным логином и паролем " +
            "с последующим переходом на главную страницу")
    @Description("Проверка правильной авторизации с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    void userMustEnterValidLoginAndPassword(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertTrue(homePage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка отображения ошибки при вводе цифр в поле логина")
    @Description("Проверка отображения ошибки при вводе цифр в поле логина")
    @Severity(SeverityLevel.NORMAL)
    void entryNumbersInLoginField(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("25619854");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе логина без символа @")
    @Description("Проверка отображения ошибки при вводе неккоректного логина")
    @Severity(SeverityLevel.NORMAL)
    void entryLoginNotDogSymbol(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("adminesfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе логина со специальным символом")
    @Description("Проверка отображения ошибки при вводе неккоректного логина")
    @Severity(SeverityLevel.NORMAL)
    void entryLoginWithDollarSymbol(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin$esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе логина с несуществующим доменом")
    @Description("Проверка отображения ошибки при вводе неккоректного логина")
    @Severity(SeverityLevel.NORMAL)
    void entryLoginWithInvalidDomain(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@netTakogoDoMena56.com");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе логина с пробелом")
    @Description("Проверка отображения ошибки при вводе неккоректного логина")
    @Severity(SeverityLevel.NORMAL)
    void entryLoginWithSpace(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin @esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе пароля с использованием букв")
    @Description("Проверка отображения ошибки при вводе неккоректного пароля")
    @Severity(SeverityLevel.NORMAL)
    void entryPasswordWithLetters(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("huhuhaha");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка отображения ошибки при вводе пароля с пробелом")
    @Description("Проверка отображения ошибки при вводе неккоректного пароля")
    @Severity(SeverityLevel.NORMAL)
    void entryPasswordWithSpace(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("200919 8916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test(description = "Проверка загрузки страницы Регистрация")
    @Description("Проверка загрузки страницы регистрации")
    @Severity(SeverityLevel.NORMAL)
    void clickRegistrationButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickRegistrationButton();

        assertTrue(registrationPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка загрузки страницы Восстановление пароля")
    @Description("Проверка загрузки страницы восстановления пароля")
    @Severity(SeverityLevel.NORMAL)
    void clickForgotPasswordButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickForgotPasswordButton();

        assertTrue(restorePasswordPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка загрузки страницы Логин сервиса")
    @Description("Проверка загрузки страницы логин сервиса")
    @Severity(SeverityLevel.NORMAL)
    void clickOneCButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickOneCButton();

        assertTrue(loginService.isPageOpened(),"Веб-страница не отвечает");
    }
    }




