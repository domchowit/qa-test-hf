package com.hellofresh.challenge.framework.util;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSessionProvider {

  private static final Logger logger = LogManager.getLogger(DriverSessionProvider.class);
  WebDriver driver;

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
    Boolean remote = Boolean.parseBoolean(System.getProperty("remote", "false"));
    if(remote){
      switch (profile) {
        case "chrome":
          ChromeOptions chromeOptions = new ChromeOptions();
          driver = new RemoteWebDriver(getGridURL(), chromeOptions);
          break;
        case "firefox":
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          driver = new RemoteWebDriver(getGridURL(), firefoxOptions);
          break;
      }
    }
    else{
      switch (profile) {
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
    }
    setupTimeouts();
  }

  private void setupTimeouts() {
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
  }

  private void setUpSession() {
    try {
      setupProfile();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    logger.info("Executing test with {}", driver.getClass().getName());
  }

}
