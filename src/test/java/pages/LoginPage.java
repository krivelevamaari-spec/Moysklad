package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private static final By LOGIN_ENTRY = By.xpath("//input[@name='j_username']");
    private static final By PASSWORD_ENTRY = By.xpath("//input[@name='j_password']");
    private static final By PRIMARY_BUTTON = By.xpath("//button[text()='Войти']");
    private static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'error-msg') " +
            "and contains(text(), 'Неверный формат имени пользователя')]");
    private static final By ERROR_MESSAGE_LOGIN_INVALID_DOMAIN_SPACE_INVALID_PASSWORD
            = By.xpath("//div[contains(@class, 'error-msg') " +
            "and contains(text(), 'Неправильный пароль')]");
    private static final By REGISTRATION_MODAL_BUTTON = By.xpath("//a[text()='Регистрация']");
    private static final By REGISTRATION_BUTTON = By.id("reglink");
    private static final By FORGOT_PASSWORD_BUTTON = By.id("restlink");
    private static final By ONE_C_BUTTON = By.xpath("//button[@title='Войти через 1С']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(PRIMARY_BUTTON);
    }

    public void openPage(){
        driver.get(BASE_URL);
    }

    public void loginEntry(){
        driver.findElement(LOGIN_ENTRY).sendKeys("admin@esfmf");
    }

    public void loginEntryNumber(){
        driver.findElement(LOGIN_ENTRY).sendKeys("2589631");
    }

    public void loginEntryNotDogSymbol(){
        driver.findElement(LOGIN_ENTRY).sendKeys("adminesfmf");
    }

    public void loginEntryDollarSymbol(){
        driver.findElement(LOGIN_ENTRY).sendKeys("admin$esfmf");
    }

    public void loginEntryInvalidDomain(){
        driver.findElement(LOGIN_ENTRY).sendKeys("admin@netdomena24.com");
    }

    public void loginEntryWithSpace(){
        driver.findElement(LOGIN_ENTRY).sendKeys("admin @esfmf");
    }

    public void passwordEntry() {
        driver.findElement(PASSWORD_ENTRY).sendKeys("2009198916");
    }

    public void clickPrimaryButton(){
        driver.findElement(PRIMARY_BUTTON).click();
    }

    public void passwordEntryInvalid() {
        driver.findElement(PASSWORD_ENTRY).sendKeys("2009198916qwe");
    }

    public void passwordEntryWithSpace() {
        driver.findElement(PASSWORD_ENTRY).sendKeys("20091989 16");
    }

    public void clickRegistrationModalButton(){
        driver.findElement(REGISTRATION_MODAL_BUTTON).click();
    }

    public void clickRegistrationButton(){
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    public void clickForgotPasswordButton(){
        driver.findElement(FORGOT_PASSWORD_BUTTON).click();
    }

    public void clickOneCButton(){
        driver.findElement(ONE_C_BUTTON).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getErrorMessageLoginInvalidDomain(){
        return driver.findElement(ERROR_MESSAGE_LOGIN_INVALID_DOMAIN_SPACE_INVALID_PASSWORD).getText();
    }

    public String getErrorMessageLoginWithSpace(){
        return driver.findElement(ERROR_MESSAGE_LOGIN_INVALID_DOMAIN_SPACE_INVALID_PASSWORD).getText();
    }

    public String getErrorMessagePasswordInvalid(){
        return driver.findElement(ERROR_MESSAGE_LOGIN_INVALID_DOMAIN_SPACE_INVALID_PASSWORD).getText();
    }

}
