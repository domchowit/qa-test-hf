package com.hellofresh.challenge.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.hellofresh.challenge.framework.util.ExpectedResultGenerator;
import com.hellofresh.challenge.framework.util.ExpectedTranslations;
import java.time.LocalDateTime;
import java.util.Timer;
import org.apache.log4j.LogManager;
import org.junit.Test;

public class WebTest extends BaseTest {

//  @Test
//  public void signInTest() {
//    //given
//    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(randomUser);
//    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
//    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
//    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();
//
//    //when
//    navigateToBaseUrl();
//    headerPage.goToAuthenticationPage();
//    authenticationPage.fillEmailToCreateAnAccount(randomUser.getEmail());
//    authenticationPage.clickCreateAnAccount();
//    accountCreationPage.fillUserData(randomUser);
//    accountCreationPage.clickSubmitButton();
//    String headerText = myAccountPage.getHeaderText();
//    String myAccountHeader = headerPage.getAccountText();
//    String infoAccountText = myAccountPage.getInfoAccountText();
//
//    //then
//    assertThat(headerText).isEqualTo(expectedMyAccountHeader);
//    assertThat(myAccountHeader).isEqualTo(expectedUserHeader);
//    assertThat(infoAccountText).contains(expectedInfoAccount);
//    assertThat(myAccountPage.isLoguoutDisplayed()).isTrue();
//    assertThat(myAccountPage.getUrl()).contains(expectedPartOfUrl);
//  }
//
//  @Test
//  public void logInTest() {
//    //given
//    String email = existingUser.getEmail();
//    String password = existingUser.getPassword();
//    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
//    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(existingUser);
//    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
//    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();
//
//    //when
//    navigateToBaseUrl();
//    headerPage.goToAuthenticationPage();
//    authenticationPage.fillCredentialsToLogin(email, password);
//    authenticationPage.clickLoginButton();
//    String headerText = myAccountPage.getHeaderText();
//    String infoAccountText = myAccountPage.getInfoAccountText();
//    String myAccountHeader = headerPage.getAccountText();
//
//    //then
//    assertThat(headerText).isEqualTo(expectedMyAccountHeader);
//    assertThat(myAccountHeader).isEqualTo(expectedUserHeader);
//    assertThat(infoAccountText).contains(expectedInfoAccount);
//    assertThat(myAccountPage.isLoguoutDisplayed()).isTrue();
//    assertThat(myAccountPage.getUrl()).contains(expectedPartOfUrl);
//  }
//
//  @Test
//  public void checkoutTest(){
//    //given
//    String email = existingUser.getEmail();
//    String password = existingUser.getPassword();
//    String expectedHeading = ExpectedTranslations.ORDER_CONFIRMATION_HEADING.translation();
//    String expectedSummaryTitle = ExpectedTranslations.ORDER_CONFIRMATION_SUMMARY_TITLE.translation();
//
//    //when
//    navigateToBaseUrl();
//    headerPage.goToAuthenticationPage();
//    authenticationPage.fillCredentialsToLogin(email, password);
//    authenticationPage.clickLoginButton();
//    headerPage.clickWomanTab();
//    productPage.clickShortSleeveTShirts();
//    productPage.clickAddToCardButton();
//    productPage.proceed();
//    productPage.secproceed();
//    productPage.clickthproceed();
//    productPage.selectAgreementCheckBox();
//    productPage.clickFourProceed();
//    productPage.clickPayByBankWireMethod();
//    productPage.clickConfirmationButton();
//
//    //then
//    assertThat(orderConfirmationPage.getHeadingText()).isEqualTo(expectedHeading);
//    assertThat(orderConfirmationPage.isFourStepCompleted()).isTrue();
//    assertThat(orderConfirmationPage.isTheCurrentStepTheLast()).isTrue();
//    assertThat(orderConfirmationPage.getSummaryTitle()).isEqualTo(expectedSummaryTitle);
//  }

//
//  protected static final org.apache.log4j.Logger logger = LogManager.getLogger(BaseTest.class.getName());
//
//  @Test
//  public void testone() throws InterruptedException {
//    getNow("test one start");
//    Thread.sleep(5000);
//    getNow("test one stop");
//  }
//  @Test
//  public void testtwo() throws InterruptedException {
//    getNow("test two start");
//    Thread.sleep(5000);
//    getNow("test two stop");
//  }
//  @Test
//  public void testth() throws InterruptedException {
//    getNow("test three start");
//    Thread.sleep(5000);
//    getNow("test three stop");
//  }
//
//  private void getNow(String a ) {
//    int hr = LocalDateTime.now().getHour();
//    int min = LocalDateTime.now().getMinute();
//    int sec = LocalDateTime.now().getSecond();
//    logger.info("hr " + hr +" min " + min +" sec " + sec + "   -> "  + a);
//    logger.info("\n\n");
//  }




    @Test
  public void testth() throws InterruptedException {
    navigateToBaseUrl();
      System.out.println();
      Thread.sleep(5000);
  }

  @Test
  public void asd() throws InterruptedException {
    navigateToBaseUrl();
    System.out.println();
    Thread.sleep(5000);
  }

  @Test
  public void aasgfsd() throws InterruptedException {
    navigateToBaseUrl();
    System.out.println();
    Thread.sleep(5000);
  }

}
