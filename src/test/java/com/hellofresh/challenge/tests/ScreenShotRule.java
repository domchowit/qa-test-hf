package com.hellofresh.challenge.tests;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotRule extends TestWatcher {

  private final Logger logger = LogManager.getLogger(ScreenShotRule.class);
  private WebDriver driver;

  public void setDriver(WebDriver driver){
    this.driver = driver;
  }

  @Override
  protected void failed(Throwable e, Description description) {
    logger.info("Make screen shot in {}()",description.getMethodName());
    makeScreenshotOnFailure();
  }

  @Attachment("Screenshot on failure")
  public byte[] makeScreenshotOnFailure() {
    return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
  }
}
