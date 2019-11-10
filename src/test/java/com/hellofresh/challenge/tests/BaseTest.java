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
    protected static User randomUser;
    protected static User existingUser;
    @BeforeClass
    public static void setupProject() throws IllegalAccessException, MalformedURLException, InstantiationException {
        setupUsers();
    }

    private static void setupUsers(){
        randomUser = TestHelper.generateRandomUser();
        existingUser = TestHelper.generateExistingUser();
    }

    protected HeaderPage navigateToBaseUrl() {
        DriverSessionProvider session = new DriverSessionProvider();
        WebDriver driver = session.getDriver();
        String url = UrlBuilder.fromString(baseUrl)
                .toString();
        driver.get(url);
        return new HeaderPage(driver);
    }

}

