package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends PageObject{

  @FindBy(name = "Submit")
  private WebElement addToCardButton;
  @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
  private WebElement firstProceed;
  @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
  private WebElement secproceed;

  @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
  private WebElement thproceed;
  @FindBy(name = "//*[@id=\"form\"]/p/button/span")
  private WebElement fourProceed;

  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickAddToCardButton(){
    addToCardButton.click();
  }

  public void proceed(){
    firstProceed.click();
  }

  public void secproceed(){
    secproceed.click();
  }

  public void clickthproceed(){
    thproceed.click();
  }

  public void clickFourProceed(){
    fourProceed.click();
  }

  //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
//    driver.findElement(By.name("processCarrier")).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();


}
