package com.hellofresh.challenge.framework.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

  protected WebDriver driver;


  public PageObject(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitUntilElementIsClickableAndClick(WebElement webElement){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
  }

  @Step
  public String getUrl() {
    return this.driver.getCurrentUrl();
  }
}
