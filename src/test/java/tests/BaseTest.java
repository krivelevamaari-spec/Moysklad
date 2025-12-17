package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    RestorePasswordPage restorePasswordPage;
    LoginService loginService;
    AccountPage accountPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Step("Настройка драйвера(браузер = '{browser}')")
    public void setting(@Optional("chrome") String browser, ITestContext testContext){

        if (browser.equals("chrome")) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--lang=ru");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        } else {
            driver = new SafariDriver();
        }

        testContext.setAttribute("driver", driver);


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        loginService = new LoginService(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Закрыть браузер")
    public void completion(){
        driver.quit();
    }
}
