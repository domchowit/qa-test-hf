package com.hellofresh.challenge.framework.pageobject;

import net.bytebuddy.asm.Advice.This;
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

    public AuthenticationPage fillEmailToCreateAnAccount(String email){
        emailCreateForm.sendKeys(email);
        return this;
    }

    public AccountCreationPage clickCreateAnAccount(){
        submitCreateButton.click();
        return new AccountCreationPage(driver);
    }

    public AuthenticationPage fillCredentialsToLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
        return this;
    }

    public MyAccountPage clickLoginButton(){
        submitLoginButton.click();
        return new MyAccountPage(driver);
    }

    private AuthenticationPage fillEmail(String email){
        emailLoginForm.sendKeys(email);
        return this;
    }

    private AuthenticationPage fillPassword(String password){
        passwordLoginForm.sendKeys(password);
        return this;
    }
}
