package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Log4j2
@Owner("masha")
public class AccountTest extends BaseTest{

    @Test(description = "Проверка верификации сохранения персональных данных")
    @Issue("Test-115")
    @Link("Test-225")
    @TmsLink("Moysklad")
    @Description("Проверка статуса сохранения")
    @Severity(SeverityLevel.NORMAL)
    void validPersonalDataShouldBeSavedSuccessfully(){
        loginPage.open();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();
        accountPage.open();

        Account account = AccountFactory.get();
        log.info("Создаем и заполняем настройки аккаунта");
        accountPage.createSettings(account);

        log.info("Проверка, что настройки успешно сохранены");
        assertTrue(accountPage.isSettingsSaved());
    }
}
