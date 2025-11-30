package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage extends BasePage{

    private static final By TITLE_RESTORE_PASSWORD = By.xpath("//h1[text()='Восстановление пароля']");

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE_RESTORE_PASSWORD);
    }
}
