package com.hellofresh.challenge.framework.pageobject;

import com.hellofresh.challenge.framework.model.enums.Color;
import com.hellofresh.challenge.framework.model.enums.Size;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

  @FindBy(id = "group_1")
  private WebElement sizeDropDown;

  @FindAll({
      @FindBy(id = "color_13"),
      @FindBy(id = "color_14")
  })
  private List<WebElement> colors;


  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Step
  public ProductPage clickShortSleeveTShirts() {
    shortSleeveTShirts.click();
    return this;
  }

  @Step
  public ProductPage clickAddToCardButton() {
    addToCardButton.click();
    return this;
  }

  @Step
  public ProductPage proceedToCheckout() {
    firstProceed.click();
    return this;
  }

  @Step
  public ProductPage summaryProceed() {
    secproceed.click();
    return this;
  }

  @Step
  public ProductPage addressProceed() {
    thproceed.click();
    return this;
  }

  @Step
  public ProductPage selectAgreementCheckBox() {
    agreementCheckBox.click();
    return this;
  }

  @Step
  public ProductPage shippingProceed() {
    fourProceed.click();
    return this;
  }

  @Step
  public ProductPage clickPayByBankWireMethod() {
    payBankWireButton.click();
    return this;
  }

  @Step
  public OrderConfirmationPage clickConfirmationButton() {
    confirmOrderButton.click();
    return new OrderConfirmationPage(driver);
  }

  @Step
  public ProductPage selectSize(Size size) {
    Select select = new Select(sizeDropDown);
    select.selectByVisibleText(size.size());
    return this;
  }

  @Step
  public ProductPage selectColor(Color color) {
    WebElement selection = colors.stream().filter(c->c.getAttribute("name").equals(color.color())).findFirst().get();
    selection.click();
    return this;
  }

}
