package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends Utility {


    @CacheLookup
    @FindBy(xpath= "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;


   // By returningCustomerText = By.xpath("//div[@id='content']/div/div[2]//h2");
   @CacheLookup
   @FindBy(xpath= "//div[@id='content']/div/div[1]//h2")
   WebElement newCustomerText;


   // By newCustomerText = By.xpath("//div[@id='content']/div/div[1]//h2");

    @CacheLookup
    @FindBy(id="input-email")
    WebElement emailAddressField;

    //By emailAddressField = By.id("input-email");

    @CacheLookup
    @FindBy(id="input-password")
    WebElement passwordField;

    //By passwordField = By.id("input-password");

    @CacheLookup
    @FindBy(xpath="//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    //By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");


    public WebElement getReturningCustomerText() {
        return returningCustomerText;
    }



    public void enterEmailAddress(String email) {
        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
    }

}

