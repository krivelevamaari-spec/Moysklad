package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    void userMustEnterValidLoginAndPassword(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertTrue(appPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void entryNumbersInLoginField(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryNumber();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginNotDogSymbol(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryNotDogSymbol();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithDollarSymbol(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryDollarSymbol();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessage(),
                "Неверный формат имени пользователя. Укажите свою учетную запись, например admin@romashka.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithInvalidDomain(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryInvalidDomain();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessageLoginInvalidDomain(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryLoginWithSpace(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryWithSpace();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessageLoginWithSpace(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryPasswordInvalid(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry();
        loginPage.passwordEntryInvalid();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessagePasswordInvalid(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void entryPasswordWithSpace(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntry();
        loginPage.passwordEntryWithSpace();
        loginPage.clickPrimaryButton();
        appPage.isPageOpened();

        assertEquals(loginPage.getErrorMessagePasswordInvalid(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст не совпадает");
    }

    @Test
    void clickRegistrationModalButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.clickRegistrationModalButton();
        registrationModalPage.isPageOpened();

        assertTrue(registrationModalPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void clickRegistrationButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryWithSpace();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        loginPage.clickRegistrationButton();
        registrationPage.isPageOpened();

        assertTrue(registrationPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void clickForgotPasswordButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryWithSpace();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        loginPage.clickForgotPasswordButton();
        restorePasswordPage.isPageOpened();

        assertTrue(restorePasswordPage.isPageOpened(),"Веб-страница не отвечает");
    }

    @Test
    void clickOneCButton(){
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.loginEntryWithSpace();
        loginPage.passwordEntry();
        loginPage.clickPrimaryButton();
        loginPage.clickOneCButton();
        loginService.isPageOpened();

        assertTrue(loginService.isPageOpened(),"Веб-страница не отвечает");
    }
    }




