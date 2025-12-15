package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginService extends BasePage{

    private static final By INPUT_LOGIN_SERVICE = By.id("username");

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
}
