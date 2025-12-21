package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage{

    private static final By LOGIN_ENTRY = By.id("lable-login");
    private static final By PASSWORD_ENTRY = By.id("lable-password");
    private static final By PRIMARY_BUTTON = By.id("submitButton");
    private static final By ERROR_MESSAGE = By.cssSelector(".error-msg");


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
    public LoginPage loginEntry(String login){
        log.info("В поле login ввели " + login);
        driver.findElement(LOGIN_ENTRY).sendKeys(login);
        return this;
    }

    @Step("Ввести '{password}' в поле Password")
    public LoginPage passwordEntry(String password) {
        log.info("В поле password ввели " + password);
        driver.findElement(PASSWORD_ENTRY).sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public LoginPage clickPrimaryButton(){
        log.info("Клик по кнопке Войти");
        driver.findElement(PRIMARY_BUTTON).click();
        return this;
    }

    @Step("Получить сообщение об ошибке")
    public String getErrorMessage(){
        String errorMessage = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Получено сообщение об ошибке: {}", errorMessage);
        return errorMessage;
    }
}
