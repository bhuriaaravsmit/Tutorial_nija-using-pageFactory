package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath= "//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'input-group date']//button")
    WebElement calendarButton;

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath= "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath= "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
   List<WebElement> dateList ;



    //By productText = By.xpath("//div[@id = 'content']//h1");
    //By calendarButton = By.xpath("//div[@class = 'input-group date']//button");
    //By monthAndYearText = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    //By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    //By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
   // By qtyField = By.cssSelector("#input-quantity");

    @CacheLookup
    @FindBy(xpath= "//button[@id='button-cart']")
    WebElement addToCartButton;



    @CacheLookup
    @FindBy(xpath= "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    //By addToCartButton = By.xpath("//button[@id='button-cart']");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
   // By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
   @CacheLookup
   @FindBy(xpath= "//div[@class = 'input-group date']//button")
   WebElement datePicker;

    //By datePicker = By.xpath("//div[@class = 'input-group date']//button");



    public WebElement getProductText() {
        return productText;
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = monthAndYearText.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
       // List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : dateList) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"clickOnAddToCartButton");
    }

    public String getProductAddedSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS,"clickOnShoppingCartLinkIntoMessage");
    }

    public void enterQuantity(String qty) {
        //clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);

    }
}

