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
  }

}
