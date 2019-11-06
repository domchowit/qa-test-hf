package com.hellofresh.challenge.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.hellofresh.challenge.framework.util.ExpectedResultGenerator;
import com.hellofresh.challenge.framework.util.ExpectedTranslations;
import org.junit.Test;

public class WebTest extends BaseTest {

  @Test
  public void signInTest() {
    //given
    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(randomUser);
    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();

    //when
    navigateToBaseUrl();
    headerPage.goToAuthenticationPage();
    authenticationPage.fillEmailToCreateAnAccount(randomUser.getEmail());
    authenticationPage.clickCreateAnAccount();
    accountCreationPage.fillUserData(randomUser);
    accountCreationPage.clickSubmitButton();
    String headerText = myAccountPage.getHeaderText();
    String myAccountHeader = headerPage.getAccountText();
    String infoAccountText = myAccountPage.getInfoAccountText();

    //then
    assertThat(headerText).isEqualTo(expectedMyAccountHeader);
    assertThat(myAccountHeader).isEqualTo(expectedUserHeader);
    assertThat(infoAccountText).contains(expectedInfoAccount);
    assertThat(myAccountPage.isLoguoutDisplayed()).isTrue();
    assertThat(myAccountPage.getUrl()).contains(expectedPartOfUrl);
  }

  @Test
  public void logInTest() {
    //given
    String email = existingUser.getEmail();
    String password = existingUser.getPassword();
    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(existingUser);
    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();

    //when
    navigateToBaseUrl();
    headerPage.goToAuthenticationPage();
    authenticationPage.fillCredentialsToLogin(email, password);
    authenticationPage.clickLoginButton();
    String headerText = myAccountPage.getHeaderText();
    String infoAccountText = myAccountPage.getInfoAccountText();
    String myAccountHeader = headerPage.getAccountText();

    //then
    assertThat(headerText).isEqualTo(expectedMyAccountHeader);
    assertThat(myAccountHeader).isEqualTo(expectedUserHeader);
    assertThat(infoAccountText).contains(expectedInfoAccount);
    assertThat(myAccountPage.isLoguoutDisplayed()).isTrue();
    assertThat(myAccountPage.getUrl()).contains(expectedPartOfUrl);
  }

  @Test
  public void checkoutTest(){
    String email = existingUser.getEmail();
    String password = existingUser.getPassword();
    navigateToBaseUrl();
    headerPage.goToAuthenticationPage();
    authenticationPage.fillCredentialsToLogin(email, password);
    authenticationPage.clickLoginButton();
    headerPage.clickWomanButton();
    tabPage.clickShortSleeveTShirts();
    System.out.println();


//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
//    driver.findElement(By.id("email")).sendKeys(existingUserEmail);
//    driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
//    driver.findElement(By.id("SubmitLogin")).click();

//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();

//    driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
//    driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
//    driver.findElement(By.name("processCarrier")).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
//    WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
//
//    assertEquals("ORDER CONFIRMATION", heading.getText());
//    assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
//    assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
//    assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
//    assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));

  }

}
