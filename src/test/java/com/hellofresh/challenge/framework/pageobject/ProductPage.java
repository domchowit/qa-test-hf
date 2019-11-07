package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends PageObject {

  @FindBy(name = "Submit")
  private WebElement addToCardButton;
  @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
  private WebElement firstProceed;
  @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
  private WebElement secproceed;

  @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
  private WebElement thproceed;
  @FindBy(name = "processCarrier")
  private WebElement fourProceed;
  @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
  private WebElement shortSleeveTShirts;

  @FindBy(name = "cgv")
  private WebElement agreementCheckBox;

  @FindBy(className = "bankwire")
  private WebElement payBankWireButton;

  @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
  private WebElement confirmOrderButton;


  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickShortSleeveTShirts() {
    shortSleeveTShirts.click();
  }

  public void clickAddToCardButton() {
    addToCardButton.click();
  }

  public void proceed() {
    firstProceed.click();
  }

  public void secproceed() {
    secproceed.click();
  }

  public void clickthproceed() {
    thproceed.click();
  }

  public void selectAgreementCheckBox() {
    agreementCheckBox.click();
  }

  public void clickFourProceed() {
    fourProceed.click();
  }

  public void clickPayByBankWireMethod() {
    payBankWireButton.click();
  }

  public void clickConfirmationButton() {
    confirmOrderButton.click();

  }


}
