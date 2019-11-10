package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
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

public class DriverSessionProvider {

  protected static final org.apache.log4j.Logger logger = LogManager.getLogger(BaseTest.class.getName());
  protected WebDriver driver;
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

  public DriverSessionProvider() {
    setUpSession();
  }

  private static URL getGridURL() throws MalformedURLException {
    String gridUrl = System.getProperty("gridURL");
    if (gridUrl == null) {
      return new URL(ConfigFeeder.INSTANCE.config.getString("maven.grid.url"));
    }
    return new URL(gridUrl);
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  private void setupProfile() throws InstantiationException, IllegalAccessException, MalformedURLException {
    String profile = System.getProperty("driver", "chrome");
    switch (profile) {
      case "remote":
        ChromeOptions capabilities = new ChromeOptions();
        driver = new RemoteWebDriver(getGridURL(), capabilities);
        break;
      case "chrome":
        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        break;
      case "firefox":
        driverClass = FirefoxDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        break;
      default:
        driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        break;
    }
    setupTimeouts();
  }

  private void setupTimeouts() {
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
  }

  private void setUpSession() {
    logger.info("setUpSession");
    try {
      setupProfile();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

}
