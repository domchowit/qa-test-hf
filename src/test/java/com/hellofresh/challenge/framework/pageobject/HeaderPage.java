package com.hellofresh.challenge.framework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends PageObject {

    @FindBy(className="login")
    private WebElement signInButton;
    @FindBy(className = "account")
    private WebElement account;
    @FindBy(linkText = "Women")
    private WebElement womenButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage goToAuthenticationPage(){
        this.signInButton.click();
        return new AuthenticationPage(driver);
    }

    public String getAccountText(){
        return account.getText();
    }

    public ProductPage clickWomanTab(){
        womenButton.click();
        return new ProductPage(driver);
    }

}