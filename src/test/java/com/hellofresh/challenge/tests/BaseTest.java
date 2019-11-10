package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.User;
import com.hellofresh.challenge.framework.pageobject.*;
import com.hellofresh.challenge.framework.util.TestHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.mikael.urlbuilder.UrlBuilder;
import io.qameta.allure.Attachment;
import java.sql.Driver;
import org.apache.log4j.LogManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static String baseUrl = ConfigFeeder.INSTANCE.config.getString("maven.srv.url");
//    protected static WebDriver driver;
    protected static User randomUser;
    protected static User existingUser;
    protected static final org.apache.log4j.Logger logger = LogManager.getLogger(BaseTest.class.getName());


//    protected HeaderPage headerPage ;
//    protected AuthenticationPage authenticationPage ;
//    protected AccountCreationPage accountCreationPage ;
//    protected MyAccountPage myAccountPage;
//    protected ProductPage productPage ;
//    protected OrderConfirmationPage orderConfirmationPage ;


    @BeforeClass
    public static void setupProject() throws IllegalAccessException, MalformedURLException, InstantiationException {
        setupUsers();
    }

//    private void setupProfile() throws InstantiationException, IllegalAccessException, MalformedURLException {
//        String profile = System.getProperty("driver", "chrome");
//        switch (profile) {
//            case "remote":
//                ChromeOptions capabilities = new ChromeOptions();
//                driver = new RemoteWebDriver(getGridURL(), capabilities);
//                break;
//            case "chrome":
//                Class<? extends WebDriver> driverClass = ChromeDriver.class;
//                WebDriverManager.getInstance(driverClass).setup();
//                setWebDriver(driverClass.newInstance());
//                break;
//            case "firefox":
//                driverClass = FirefoxDriver.class;
//                WebDriverManager.getInstance(driverClass).setup();
//                setWebDriver(driverClass.newInstance());
//                break;
//            default:
//                driverClass = ChromeDriver.class;
//                WebDriverManager.getInstance(driverClass).setup();
//                setWebDriver(driverClass.newInstance());
//                break;
//        }
//        setupTimeouts();
//    }

//    private void setUpPages() {
//        logger.info("setUpPages");
//        headerPage = new HeaderPage(driver);
//        authenticationPage = new AuthenticationPage(driver);
//        accountCreationPage = new AccountCreationPage(driver);
//        myAccountPage = new MyAccountPage(driver);
//        productPage = new ProductPage(driver);
//        orderConfirmationPage = new OrderConfirmationPage(driver);
//    }

//    private static void setupTimeouts() {
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
//    }

    private static void setupUsers(){
        randomUser = TestHelper.generateRandomUser();
        existingUser = TestHelper.generateExistingUser();
    }

//    private static void setWebDriver(WebDriver driver) {
//        BaseTest.driver = driver;
//    }

//    private void setUpSession(){
//        logger.info("setUpSession");
//        try {
//            setupProfile();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        setUpPages();
//    }


//    private static URL getGridURL() throws MalformedURLException {
//        String gridUrl = System.getProperty("gridURL");
//        if (gridUrl == null) {
//            return new URL(ConfigFeeder.INSTANCE.config.getString("maven.grid.url"));
//        }
//        return new URL(gridUrl);
//    }

//    @AfterClass
//    public static void closeBrowsers() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

//    @After
//    public void after(){
//        driver.manage().deleteAllCookies();
//    }

    protected void navigateToBaseUrl() {
        logger.info("navigateToBaseUrl");
//        setUpSession();
        DriverSessionProvider driverSessionProvider = new DriverSessionProvider();
        WebDriver driver = driverSessionProvider.getDriver();
        String url = UrlBuilder.fromString(baseUrl)
                .toString();
        driver.get(url);
    }

//    @Rule
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description) {
//            makeScreenshotOnFailure();
//        }
//
//        @Attachment("Screenshot on failure")
//        public byte[] makeScreenshotOnFailure() {
//            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        }
//    };

}

