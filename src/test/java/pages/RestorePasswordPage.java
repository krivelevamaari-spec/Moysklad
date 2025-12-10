package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage extends BasePage{

    private static final By INPUT_LOGIN = By.id("lable-login");

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(INPUT_LOGIN);
    }
}
