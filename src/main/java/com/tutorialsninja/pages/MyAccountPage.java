package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath= "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath= "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;

   // @CacheLookup
    @FindBy(xpath= "//a[contains(text(),'Continue')]")
    WebElement continueBtn;



    //By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
   // By accountCreatedText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    //By continueBtn = By.xpath("//a[contains(text(),'Continue')]");


    public WebElement getAccountLogoutText() {
        return accountLogoutText;
    }


    public WebElement getAccountCreatedText() {
        return accountCreatedText;
    }


    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"clickOnContinueButton");
    }
}

