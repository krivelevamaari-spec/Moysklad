package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationModalPage registrationModalPage;
    RegistrationPage registrationPage;
    RestorePasswordPage restorePasswordPage;
    LoginService loginService;

    @BeforeMethod
    public void setting(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--lang=ru");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationModalPage = new RegistrationModalPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        loginService = new LoginService(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void completion(){
        driver.quit();
    }
}
