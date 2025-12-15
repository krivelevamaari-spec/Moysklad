package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest{

    @Test
    void validPersonalDataShouldBeSavedSuccessfully() throws InterruptedException {
        loginPage.open();
        loginPage.loginEntry("admin@esfmf");
        loginPage.passwordEntry("2009198916");
        loginPage.clickPrimaryButton();
        accountPage.open();

        Account account = AccountFactory.get();
        accountPage.createSettings(account);

        assertTrue(accountPage.isSettingsSaved());
    }
}

