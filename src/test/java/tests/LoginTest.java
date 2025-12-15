package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    public void errorMessages(String email, String password, String errorMessage) {
        loginPage.open();
        loginPage.loginEntry(email);
        loginPage.passwordEntry(password);
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                errorMessage, "Неверное сообщение об ошибке");
    }


    @Test(description = "Проверка загрузки страницы авторизации")
    void loginPageShouldOpen(){
        loginPage.open();

        assertTrue(loginPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка правильной авторизации с валидным логином и паролем " +
            "с последующим переходом на главную страницу")
    void userMustEnterValidLoginAndPassword(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertTrue(homePage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка отображения ошибки при вводе цифр в поле логина")
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
    void clickRegistrationButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickRegistrationButton();

        assertTrue(registrationPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка загрузки страницы Восстановление пароля")
    void clickForgotPasswordButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickForgotPasswordButton();

        assertTrue(restorePasswordPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test(description = "Проверка загрузки страницы Логин сервиса")
    void clickOneCButton(){
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.clickOneCButton();

        assertTrue(loginService.isPageOpened(),"Веб-страница не отвечает");
    }
    }




