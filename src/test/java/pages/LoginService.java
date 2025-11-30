package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginService extends BasePage{

    private static final By TITLE_LOGIN_SERVICE = By.id("serviceTitle");

    public LoginService(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE_LOGIN_SERVICE);
    }
}
