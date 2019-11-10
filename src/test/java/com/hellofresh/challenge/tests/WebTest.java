package com.hellofresh.challenge.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.hellofresh.challenge.framework.pageobject.HeaderPage;
import com.hellofresh.challenge.framework.pageobject.MyAccountPage;
import com.hellofresh.challenge.framework.pageobject.OrderConfirmationPage;
import com.hellofresh.challenge.framework.util.BaseTest;
import com.hellofresh.challenge.framework.util.ExpectedResultGenerator;
import com.hellofresh.challenge.framework.util.ExpectedTranslations;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class WebTest extends BaseTest {
  protected final Logger logger = LogManager.getLogger(WebTest.class);


  @Test
  @Description("Sign In Test - new user creation")
  public void signInTest() {
    //given
    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(randomUser);
    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();

    //when
    HeaderPage headerPage = navigateToBaseUrl();
    MyAccountPage myAccountPage = headerPage
        .goToAuthenticationPage()
        .fillEmailToCreateAnAccount(randomUser.getEmail())
        .clickCreateAnAccount()
        .fillUserData(randomUser)
        .clickSubmitButton();

    String headerText = myAccountPage.getHeaderText();
    String myAccountHeader = headerPage.getAccountText();
    String infoAccountText = myAccountPage.getInfoAccountText();

    logger.debug("headerText " + headerText);
    logger.debug("myAccountHeader " + myAccountHeader);
    logger.debug("infoAccountText " + infoAccountText);

    assertThat(headerText).isEqualTo(expectedMyAccountHeader);
    assertThat(myAccountHeader).isEqualTo(expectedUserHeader);
    assertThat(infoAccountText).contains(expectedInfoAccount);
    assertThat(myAccountPage.isLoguoutDisplayed()).isTrue();
    assertThat(myAccountPage.getUrl()).contains(expectedPartOfUrl);
  }

  @Test
  @Description("Log In Test - existing user check")
  public void logInTest() {
    //given
    String email = existingUser.getEmail();
    String password = existingUser.getPassword();
    String expectedMyAccountHeader = ExpectedTranslations.MY_ACCOUNT_HEADER.translation();
    String expectedUserHeader = ExpectedResultGenerator.getHeaderMyAcountText(existingUser);
    String expectedInfoAccount = ExpectedTranslations.MY_ACCOUNT_WELCOME.translation();
    String expectedPartOfUrl = ExpectedTranslations.MY_ACCOUNT_URL.translation();

    //when
    HeaderPage headerPage = navigateToBaseUrl();
    MyAccountPage myAccountPage = headerPage
        .goToAuthenticationPage()
        .fillCredentialsToLogin(email, password)
        .clickLoginButton();

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
  @Description("Check Out Test - perform order action")
  public void checkoutTest() {
    //given
    String email = existingUser.getEmail();
    String password = existingUser.getPassword();
    String expectedHeading = ExpectedTranslations.ORDER_CONFIRMATION_HEADING.translation();
    String expectedSummaryTitle = ExpectedTranslations.ORDER_CONFIRMATION_SUMMARY_TITLE.translation();

    //when
    HeaderPage headerPage = navigateToBaseUrl();
    headerPage
        .goToAuthenticationPage()
        .fillCredentialsToLogin(email, password)
        .clickLoginButton();

    OrderConfirmationPage orderConfirmationPage = headerPage
        .clickWomanTab()
        .clickShortSleeveTShirts()
        .clickAddToCardButton()
        .proceedToCheckout()
        .summaryProceed()
        .addressProceed()
        .selectAgreementCheckBox()
        .shippingProceed()
        .clickPayByBankWireMethod()
        .clickConfirmationButton();

    assertThat(orderConfirmationPage.getHeadingText()).isEqualTo(expectedHeading);
    assertThat(orderConfirmationPage.isFourStepCompleted()).isTrue();
    assertThat(orderConfirmationPage.isTheCurrentStepTheLast()).isTrue();
    assertThat(orderConfirmationPage.getSummaryTitle()).isEqualTo(expectedSummaryTitle);

  }

}
