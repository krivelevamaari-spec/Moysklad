package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public final String BASE_URL = "https://www.moysklad.ru/login/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public abstract boolean isPageOpened();

    protected boolean isExist(By locator){
        try {
            return driver.findElement(locator).isDisplayed();

        }catch (NoSuchElementException e){
            return false;
        }
    }
}
