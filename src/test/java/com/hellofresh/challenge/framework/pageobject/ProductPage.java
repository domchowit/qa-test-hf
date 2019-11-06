package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends PageObject{

  @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
  private WebElement shortSleeveTShirts;

  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickShortSleeveTShirts(){
    shortSleeveTShirts.click();
  }

}
