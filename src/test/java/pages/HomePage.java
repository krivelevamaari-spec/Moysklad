package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final By TITLE = (By.xpath("//h2[contains(@class, 'css-10_0_0--vzqnO')]"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE);
    }
}
