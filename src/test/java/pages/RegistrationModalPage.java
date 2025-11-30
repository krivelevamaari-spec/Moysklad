package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationModalPage extends BasePage{

    private static final By TITLE_MODAL_REGISTRATION = (By.xpath("//div[@class='ms-modal-title' " +
            "and text()='Регистрация']"));

    public RegistrationModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE_MODAL_REGISTRATION);
    }
}
