package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private static final By LOGIN_ENTRY = By.id("lable-login");
    private static final By PASSWORD_ENTRY = By.id("lable-password");
    private static final By PRIMARY_BUTTON = By.id("submitButton");
    private static final By ERROR_MESSAGE = By.cssSelector(".error-msg");
    private static final By REGISTRATION_BUTTON = By.id("reglink");
    private static final By FORGOT_PASSWORD_BUTTON = By.id("restlink");
    private static final By ONE_C_BUTTON = By.className("b-button-login-via");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(PRIMARY_BUTTON);
    }

    @Override
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Ввести '{login}' в поле Login")
    public void loginEntry(String login){
        driver.findElement(LOGIN_ENTRY).sendKeys(login);
    }

    @Step("Ввести '{password}' в поле Password")
    public void passwordEntry(String password) {
        driver.findElement(PASSWORD_ENTRY).sendKeys(password);
    }

    @Step("Нажать на кнопку Войти")
    public void clickPrimaryButton(){
        driver.findElement(PRIMARY_BUTTON).click();
    }

    @Step("Нажать на кнопку Регистрация")
    public void clickRegistrationButton(){
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Нажать на кнопку Забыли пароль")
    public void clickForgotPasswordButton(){
        driver.findElement(FORGOT_PASSWORD_BUTTON).click();
    }

    @Step("Нажать на кнопку Войти через 1С")
    public void clickOneCButton(){
        driver.findElement(ONE_C_BUTTON).click();
    }

    @Step("Получить сообщение об ошибке")
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
