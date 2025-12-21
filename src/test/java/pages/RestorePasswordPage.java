package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RestorePasswordPage extends BasePage{

    private static final By INPUT_LOGIN = By.id("lable-login");
    private static final By FORGOT_PASSWORD_BUTTON = By.id("restlink");

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(INPUT_LOGIN);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "/restorePassword");
    }

    @Step("Нажать на кнопку Забыли пароль")
    public void clickForgotPasswordButton(){
        driver.findElement(FORGOT_PASSWORD_BUTTON).click();
        log.info("Клик по кнопке Забыли пароль");
    }
}
