package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends PageObject {

  @FindBy(css = "h1")
  private WebElement header;

  @FindBy(xpath = "//li[@class='step_done step_done_last four']")
  private WebElement fourStep;

  @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
  private WebElement fifthStep;

  @FindBy(xpath = "//*[@class='cheque-indent']/strong")
  private WebElement summaryTitle;

  public OrderConfirmationPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public String getHeadingText() {
    return header.getText();
  }

  public boolean isFourStepCompleted() {
    return fourStep.isDisplayed();
  }

  public boolean isTheCurrentStepTheLast() {
    return fifthStep.isDisplayed();
  }

  public String getSummaryTitle() {
    return summaryTitle.getText();
  }

}
