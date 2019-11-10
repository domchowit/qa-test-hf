package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.pageobject.AccountCreationPage;
import com.hellofresh.challenge.framework.pageobject.AuthenticationPage;
import com.hellofresh.challenge.framework.pageobject.HeaderPage;
import com.hellofresh.challenge.framework.pageobject.MyAccountPage;
import com.hellofresh.challenge.framework.pageobject.OrderConfirmationPage;
import com.hellofresh.challenge.framework.pageobject.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSessionProvider {

  protected  WebDriver driver;

  protected static final org.apache.log4j.Logger logger = LogManager.getLogger(BaseTest.class.getName());


  protected HeaderPage headerPage ;
  protected AuthenticationPage authenticationPage ;
  protected AccountCreationPage accountCreationPage ;
  protected MyAccountPage myAccountPage;
  protected ProductPage productPage ;
  protected OrderConfirmationPage orderConfirmationPage ;

  public WebDriver getDriver(){
    return this.driver;
  }

  public DriverSessionProvider(){
    setUpSession();
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
    setupTimeouts();
  }

  private void setUpPages() {
    logger.info("setUpPages");
    headerPage = new HeaderPage(driver);
    authenticationPage = new AuthenticationPage(driver);
    accountCreationPage = new AccountCreationPage(driver);
    myAccountPage = new MyAccountPage(driver);
    productPage = new ProductPage(driver);
    orderConfirmationPage = new OrderConfirmationPage(driver);
  }

  private void setupTimeouts() {
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
  }

  private void setWebDriver(WebDriver driver) {
    driver = driver;
  }

  private void setUpSession(){
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
    setUpPages();
  }

  private static URL getGridURL() throws MalformedURLException {
    String gridUrl = System.getProperty("gridURL");
    if (gridUrl == null) {
      return new URL(ConfigFeeder.INSTANCE.config.getString("maven.grid.url"));
    }
    return new URL(gridUrl);
  }

}
