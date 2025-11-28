package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePage {

    WebDriver driver;
    public final String BASE_URL = "https://www.moysklad.ru/login/";
    WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
