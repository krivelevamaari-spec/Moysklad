package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationPage extends BasePage{

    private static final By INPUT_REGISTRATION = By.id("email");
    private static final By REGISTRATION_BUTTON = By.id("reglink");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(INPUT_REGISTRATION);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "/registration");
    }

    @Step("Нажать на кнопку Регистрация")
    public void clickRegistrationButton(){
        driver.findElement(REGISTRATION_BUTTON).click();
        log.info("Клик по кнопке Регистрация");
    }
}
