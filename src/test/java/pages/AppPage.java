package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppPage extends BasePage{

    private static final By TITLE = (By.xpath("//h1[contains(text(), 'Первые шаги в МоемСкладе')]"));

    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(TITLE);
    }
}
