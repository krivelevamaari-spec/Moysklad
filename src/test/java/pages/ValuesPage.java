package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
@Log4j2

public class ValuesPage extends BasePage{

    private static final By SETTINGS_MENU = By.xpath("//div[@class='group-label' " +
            "and text()='Настройки']");
    private static final By INPUT_ORGANIZATION = By.xpath("//span[@class='b-validation-label' " +
            "and text()='Организация']/ancestor::tr[1]//input[@class='text-box']");

    public ValuesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(SETTINGS_MENU);
    }

    @Override
    public void open() {
        driver.get(BASE_URL + "app/#account");
    }

    public void fillInValues(){
        WebElement input = driver.findElement(INPUT_ORGANIZATION);
        input.click();
        input.clear();
    }

    public void closeModalWindow(){
        driver.findElement(By.cssSelector("button.close-icon-dark")).click();
        log.info("Закрыто модальное окно");
    }
}
