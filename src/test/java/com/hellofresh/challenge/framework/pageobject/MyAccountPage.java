package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends PageObject{

  @FindBy(css = "h1")
  private WebElement heading;
  @FindBy(className = "info-account")
  private WebElement infoAccount;
  @FindBy(className = "logout")
  private WebElement logout;

  public MyAccountPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public String getHeaderText(){
    return heading.getText();
  }

  public String getInfoAccountText(){
    return infoAccount.getText();
  }

  public boolean isLoguoutDisplayed(){
    return logout.isDisplayed();
  }
}
