package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class AccountTest extends BaseTest{

    @Test(description = "Проверка загрузки страницы настройки аккаунта")
    @Issue("Test-118")
    @Link("Test-228")
    @TmsLink("Moysklad")
    @Description("Проверка загрузки страницы настройки аккаунта ")
    @Severity(SeverityLevel.NORMAL)
    void accountPageIsOpen(){
        log.info("Открытие страницы настройки аккаунта");
        loginPage.open();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();
        accountPage.open();
        log.info("Страница настройки аккаунта открыта");

        step("Ожидаемый результат: страница настройки аккаунта пользователя открыта", () ->
                assertTrue(accountPage.isPageOpened(), "Веб-страница не отвечает"));
    }

    @Test(description = "Проверка верификации сохранения персональных данных")
    @Issue("Test-115")
    @Link("Test-225")
    @TmsLink("Moysklad")
    @Description("Проверка статуса сохранения")
    @Severity(SeverityLevel.NORMAL)
    void validPersonalDataShouldBeSavedSuccessfully(){
        log.info("Открытие страницы настройки аккаунта");
        loginPage.open();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();
        accountPage.open();
        log.info("Страница настройки аккаунта открыта");

        Account account = AccountFactory.get();
        log.info("Создаем и заполняем настройки аккаунта");
        accountPage.createSettings(account);

        log.info("Проверка, что настройки успешно сохранены");
        step("Ожидаемый результат: настройки успешно сохранены", () ->
                assertTrue(accountPage.isSettingsSaved()));
    }
}
