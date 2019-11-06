package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends PageObject{

    @FindBy(id="email_create")
    private WebElement emailCreateForm;
    @FindBy(id="SubmitCreate")
    private WebElement submitCreateButton;
    @FindBy(id="email")
    private WebElement emailLoginForm;
    @FindBy(id="passwd")
    private WebElement passwordLoginForm;
    @FindBy(id="SubmitLogin")
    private WebElement submitLoginButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillEmailToCreateAnAccount(String email){
        emailCreateForm.sendKeys(email);
    }

    public void clickCreateAnAccount(){
        submitCreateButton.click();
    }

    public void fillCredentialsToLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
    }

    public void clickLoginButton(){
        submitLoginButton.click();
    }

    private void fillEmail(String email){
        emailLoginForm.sendKeys(email);
    }

    private void fillPassword(String password){
        passwordLoginForm.sendKeys(password);
    }
}
