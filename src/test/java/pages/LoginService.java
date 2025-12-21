package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginService extends BasePage{

    private static final By INPUT_LOGIN_SERVICE = By.id("username");
    private static final By ONE_C_BUTTON = By.className("b-button-login-via");

    public LoginService(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(INPUT_LOGIN_SERVICE);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "/login?service");
    }

    @Step("Нажать на кнопку Войти через 1С")
    public void clickOneCButton(){
        driver.findElement(ONE_C_BUTTON).click();
        log.info("Клик по кнопке Войти через 1С");
    }
}
