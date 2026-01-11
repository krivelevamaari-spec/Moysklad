package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.TestListener;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Owner("masha")
@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    RestorePasswordPage restorePasswordPage;
    LoginService loginService;
    AccountPage accountPage;
    ValuesPage valuesPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Step("Настройка драйвера(браузер = '{browser}')")
    public void setting(@Optional("chrome") String browser, ITestContext testContext) {

        if (browser.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--lang=ru");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        } else {
            driver = new EdgeDriver();
        }

        testContext.setAttribute("driver", driver);


        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        loginService = new LoginService(driver);
        accountPage = new AccountPage(driver);
        valuesPage = new ValuesPage(driver);

        log.info("Настройка драйвера завершена");
    }

    @AfterMethod(alwaysRun = true)
    @Step("Закрыть браузер")
    public void completion() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Браузер закрыт");
    }
}