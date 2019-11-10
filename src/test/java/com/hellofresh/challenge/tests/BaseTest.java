package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.framework.configuration.ConfigFeeder;
import com.hellofresh.challenge.framework.model.User;
import com.hellofresh.challenge.framework.pageobject.HeaderPage;
import com.hellofresh.challenge.framework.util.TestHelper;
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
  private static String baseUrl = ConfigFeeder.INSTANCE.config.getString("maven.srv.url");
  private static ArrayList<WebDriver> activeSessions = new ArrayList();
  protected final Logger logger = LogManager.getLogger(BaseTest.class);

  @Rule
  public ScreenShotRule screenShotRule = new ScreenShotRule();

  @BeforeClass
  public static void setupProject() {
    setupUsers();
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

