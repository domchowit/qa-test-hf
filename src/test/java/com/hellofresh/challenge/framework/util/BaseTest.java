package com.hellofresh.challenge.framework.util;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.Order;
import com.hellofresh.challenge.framework.model.User;
import com.hellofresh.challenge.framework.pageobject.HeaderPage;
import io.mikael.urlbuilder.UrlBuilder;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

public class BaseTest {

  protected static User randomUser;
  protected static User existingUser;
  protected static Order randomOrder;
  private static String baseUrl = ConfigFeeder.INSTANCE.config.getString("maven.srv.url");
  private static ArrayList<WebDriver> activeSessions = new ArrayList();
  protected final Logger logger = LogManager.getLogger(BaseTest.class);
  @Rule
  public ScreenShotRule screenShotRule = new ScreenShotRule();
  protected FileDataFeeder<Order> fileDataFeeder = new FileDataFeeder<>();

  @BeforeClass
  public static void setupProject() {
    setupUsers();
    setUpOrders();
  }

  @AfterClass
  public static void closeBrowsers() {
    activeSessions.stream().forEach(session -> {
      if (session != null) {
        session.quit();
      }
    });
  }

  private static void setupUsers() {
    randomUser = TestHelper.generateRandomUser();
    existingUser = TestHelper.generateExistingUser();
  }

  private static void setUpOrders() {
    randomOrder = TestHelper.generateRandomOrder();
  }

  protected HeaderPage navigateToBaseUrl() {
    DriverSessionProvider session = new DriverSessionProvider();
    WebDriver driver = session.getDriver();
    activeSessions.add(driver);
    screenShotRule.setDriver(driver);
    String url = UrlBuilder.fromString(baseUrl)
        .toString();
    driver.get(url);
    return new HeaderPage(driver);
  }

}

