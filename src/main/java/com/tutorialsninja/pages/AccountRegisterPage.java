package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath= "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

        //By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");

    @CacheLookup
    @FindBy(id= "input-firstname")
    WebElement firstNameField;
   // By firstNameField = By.id("input-firstname");

    @CacheLookup
    @FindBy(id= "input-lastname")
    WebElement LastNameField;

   // By LastNameField = By.id("input-lastname");

    @CacheLookup
    @FindBy(id= "input-email")
    WebElement emailField;

   // By emailField = By.id("input-email");

    @CacheLookup
    @FindBy(id= "input-telephone")
    WebElement telephoneField;

   // By telephoneField = By.id("input-telephone");

    @CacheLookup
    @FindBy(id= "input-password")
    WebElement passwordField;

   // By passwordField = By.id("input-password");

    @CacheLookup
    @FindBy(id= "input-confirm")
    WebElement passwordConfirmField;

  //  By passwordConfirmField = By.id("input-confirm");

    @CacheLookup
    @FindBy(xpath= "//fieldset[3]//input")
    List<WebElement> subscribeRadios;

   // By subscribeRadios = By.xpath("//fieldset[3]//input");

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

   // By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;


   // By continueBtn = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    @CacheLookup
    @FindBy(xpath= "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


   // By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");



    public WebElement getRegisterAccountText() {
        return registerAccountText;
    }

    public void enterFirstName(String fName) {

        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +fName);
    }

    public void enterLastName(String lName)
    {
        sendTextToElement(LastNameField, lName);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +lName);
    }

    public void enterEmail(String email) {

        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +email);
    }

    public void enterTelephone(String telephone)
    {
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +telephone);
    }

    public void enterPassword(String password)
    {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +password);
    }

    public void enterConfirmPassword(String cPassword)
    {
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +cPassword);
    }

   /* public WebElement getSubscribeRadios() {
        return subscribeRadios;
    }*/

   public void selectSubscription(String option) {
       // List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : subscribeRadios) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"clickOnPrivacyPolicyCheckBox");

    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"clickOnContinueButton");

    }

}

