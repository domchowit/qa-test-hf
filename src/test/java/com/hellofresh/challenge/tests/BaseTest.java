package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.User;
import com.hellofresh.challenge.framework.pageobject.AccountCreationPage;
import com.hellofresh.challenge.framework.pageobject.AuthenticationPage;
import com.hellofresh.challenge.framework.pageobject.HeaderPage;
import com.hellofresh.challenge.framework.pageobject.MyAccountPage;
import com.hellofresh.challenge.framework.pageobject.TabPage;
import com.hellofresh.challenge.framework.util.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.mikael.urlbuilder.UrlBuilder;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static String baseUrl = ConfigFeeder.INSTANCE.config.getString("maven.srv.url");
    protected static WebDriver driver;
    protected static User randomUser;
    protected static User existingUser;

    protected HeaderPage headerPage = new HeaderPage(driver);
    protected AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    protected AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
    protected MyAccountPage myAccountPage = new MyAccountPage(driver);
    protected TabPage tabPage = new TabPage(driver);

    @BeforeClass
    public static void setupProject() throws IllegalAccessException, MalformedURLException, InstantiationException {
        setupProfile();
        setupTimeouts();
        setupUsers();
    }

    private static void setupProfile() throws InstantiationException, IllegalAccessException, MalformedURLException {
        String profile = System.getProperty("driver", "chrome");
        switch (profile) {
            case "remote":
                ChromeOptions capabilities = new ChromeOptions();
                driver = new RemoteWebDriver(getGridURL(), capabilities);
                break;
            case "chrome":
                Class<? extends WebDriver> driverClass = ChromeDriver.class;
                WebDriverManager.getInstance(driverClass).setup();
                setWebDriver(driverClass.newInstance());
                break;
            case "firefox":
                driverClass = FirefoxDriver.class;
                WebDriverManager.getInstance(driverClass).setup();
                setWebDriver(driverClass.newInstance());
                break;
            default:
                driverClass = ChromeDriver.class;
                WebDriverManager.getInstance(driverClass).setup();
                setWebDriver(driverClass.newInstance());
                break;
        }
    }

    private static void setupTimeouts() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    private static void setupUsers(){
        randomUser = TestHelper.generateRandomUser();
        existingUser = TestHelper.generateExistingUser();
    }

    private static void setWebDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }


    private static URL getGridURL() throws MalformedURLException {
        String gridUrl = System.getProperty("gridURL");
        if (gridUrl == null) {
            return new URL(ConfigFeeder.INSTANCE.config.getString("maven.grid.url"));
        }
        return new URL(gridUrl);
    }

    @AfterClass
    public static void closeBrowsers() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void after(){
        driver.manage().deleteAllCookies();
    }

    protected void navigateToBaseUrl() {
        String url = UrlBuilder.fromString(baseUrl)
                .toString();
        driver.get(url);
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

}

