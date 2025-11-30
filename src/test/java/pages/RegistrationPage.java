package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

    private static final By TITLE_REGISTRATION = (By.xpath("//h1[text()='Регистрация']"));

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE_REGISTRATION);
    }
}
