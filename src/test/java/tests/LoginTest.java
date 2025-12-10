package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{


    @Test
    void loginPageShouldOpen(){
        loginPage.openPage();

        assertTrue(loginPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void userMustEnterValidLoginAndPassword(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertTrue(homePage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void entryNumbersInLoginField(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("25619854");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginNotDogSymbol(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("adminesfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithDollarSymbol(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin$esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithInvalidDomain(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@netTakogoDoMena56.com");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithSpace(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin @esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryPasswordWithLetters(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("huhuhaha");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryPasswordWithSpace(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("200919 8916");
        loginPage.clickPrimaryButton();

        assertEquals(loginPage.getErrorMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void clickRegistrationButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.clickRegistrationButton();

        assertTrue(registrationPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void clickForgotPasswordButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.clickForgotPasswordButton();

        assertTrue(restorePasswordPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void clickOneCButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.clickOneCButton();

        assertTrue(loginService.isPageOpened(),"Веб-страница не отвечает");
    }
    }




