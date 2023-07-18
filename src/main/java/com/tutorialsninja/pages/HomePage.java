package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;

   // By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    @CacheLookup
    @FindBy(linkText= "Desktops")
    WebElement desktopLink;

   // By desktopLink = By.linkText("Desktops");

    @CacheLookup
    @FindBy(linkText= "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    //By laptopsAndNotebooksLink = By.linkText("Laptops & Notebooks");

    @CacheLookup
    @FindBy(linkText= "Components")
    WebElement componentsLinks;
    //By componentsLinks = By.linkText("Components");

    @CacheLookup
    @FindBy(xpath= "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    //By currencyTab = By.xpath("//span[contains(text(),'Currency')]");

    @CacheLookup
    @FindBy(xpath= "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;
   // By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");

  //  @CacheLookup
    @FindBy(xpath= "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    //By myAccountTab = By.xpath("//span[contains(text(),'My Account')]");

   // @CacheLookup
    @FindBy(xpath= "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;
   // By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");


    public void selectMenu(String menu) {
     //   List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenu) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
           // topMenuList = driver.findElements(topMenu);
        }
    }



    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS,"mouseHoverOnDesktopsLinkAndClick");
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS,"mouseHoverOnLaptopsAndNotebooksLinkAndClick");
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
        CustomListeners.test.log(Status.PASS,"mouseHoverOnComponentLinkAndClick");
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
    //    List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyAccountTab() {
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS,"clickOnMyAccountTab");
    }

    public void selectMyAccountOptions(String option) {
       // List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountOptions) {
                System.out.println("+++++"+options.getText());
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            //myAccountList = getListOfElements(myAccountOptions);
        }
    }
}

