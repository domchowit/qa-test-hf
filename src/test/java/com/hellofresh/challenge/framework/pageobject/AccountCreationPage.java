package com.hellofresh.challenge.framework.pageobject;

import com.hellofresh.challenge.framework.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage extends PageObject {

  @FindBy(id = "customer_firstname")
  private WebElement customerFirstnameForm;
  @FindBy(id = "customer_lastname")
  private WebElement customerLastnameForm;
  @FindBy(id = "passwd")
  private WebElement passwordForm;
  @FindBy(id = "days")
  private WebElement daysDropDown;
  @FindBy(id = "months")
  private WebElement monthsDropDown;
  @FindBy(id = "years")
  private WebElement yearsDropDown;
  @FindBy(id = "company")
  private WebElement companyForm;
  @FindBy(id = "address1")
  private WebElement address1Form;
  @FindBy(id = "address2")
  private WebElement address2Form;
  @FindBy(id = "city")
  private WebElement cityForm;
  @FindBy(id = "id_state")
  private WebElement stateDropDown;
  @FindBy(id = "postcode")
  private WebElement postcodeForm;
  @FindBy(id = "other")
  private WebElement otherForm;
  @FindBy(id = "phone")
  private WebElement phoneForm;
  @FindBy(id = "phone_mobile")
  private WebElement phoneMobileForm;
  @FindBy(id = "alias")
  private WebElement aliasForm;
  @FindBy(id = "submitAccount")
  private WebElement submitButton;

  public AccountCreationPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Step
  public AccountCreationPage fillUserData(User user) {
    fillUserName(user.getName());
    fillUserSurname(user.getSurname());
    fillPassword(user.getPassword());
    selectDayOfBirth(user.getDateOfBirth().getDayOfMonth());
    selectMonthOfBirth(user.getDateOfBirth().getMonthValue());
    selectYearOfBirth(user.getDateOfBirth().getYear());
    fillCompany(user.getCompany());
    fillAddress1(user.getAddress());
    fillAddress2(user.getAddress());
    fillCity(user.getCity());
    selectState(user.getState());
    fillPostcode(user.getPostCode());
    fillOther(user.getOther());
    fillPhone(user.getPhone());
    fillPhoneMobile(user.getPhoneMobile());
    fillAlias(user.getAddressAlias());
    return this;
  }

  @Step
  public MyAccountPage clickSubmitButton() {
    submitButton.click();
    return new MyAccountPage(driver);
  }

  @Step
  private AccountCreationPage fillUserName(String name) {
    customerFirstnameForm.sendKeys(name);
    return this;
  }

  @Step
  private AccountCreationPage fillUserSurname(String surname) {
    customerLastnameForm.sendKeys(surname);
    return this;
  }

  @Step
  private AccountCreationPage fillPassword(String password) {
    passwordForm.sendKeys(password);
    return this;
  }

  @Step
  private AccountCreationPage selectDayOfBirth(Integer day) {
    Select select = new Select(daysDropDown);
    select.selectByValue(day.toString());
    return this;
  }

  @Step
  private AccountCreationPage selectMonthOfBirth(Integer month) {
    Select select = new Select(monthsDropDown);
    select.selectByValue(month.toString());
    return this;
  }

  @Step
  private AccountCreationPage selectYearOfBirth(Integer year) {
    Select select = new Select(yearsDropDown);
    select.selectByValue(year.toString());
    return this;
  }

  @Step
  private AccountCreationPage fillCompany(String company) {
    companyForm.sendKeys(company);
    return this;
  }

  @Step
  private AccountCreationPage fillAddress1(String address) {
    address1Form.sendKeys(address);
    return this;
  }

  @Step
  private AccountCreationPage fillAddress2(String address) {
    address2Form.sendKeys(address);
    return this;
  }

  @Step
  private AccountCreationPage fillCity(String city) {
    cityForm.sendKeys(city);
    return this;
  }

  @Step
  private AccountCreationPage selectState(String state) {
    Select select = new Select(stateDropDown);
    select.selectByVisibleText(state);
    return this;
  }

  @Step
  private AccountCreationPage fillPostcode(Integer postcode) {
    postcodeForm.sendKeys(postcode.toString());
    return this;
  }

  @Step
  private AccountCreationPage fillOther(String other) {
    otherForm.sendKeys(other);
    return this;
  }

  @Step
  private AccountCreationPage fillPhone(String phone) {
    phoneForm.sendKeys(phone);
    return this;
  }

  @Step
  private AccountCreationPage fillPhoneMobile(String mobile) {
    phoneMobileForm.sendKeys(mobile);
    return this;
  }

  @Step
  private AccountCreationPage fillAlias(String alias) {
    aliasForm.sendKeys(alias);
    return this;
  }

}