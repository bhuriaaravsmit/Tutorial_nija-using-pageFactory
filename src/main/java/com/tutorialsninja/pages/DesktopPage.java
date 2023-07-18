package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(xpath= "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText ;


   // By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");

  //  @CacheLookup
    @FindBy(xpath= "//h4/a")
    List<WebElement> productsList ;

   // By productsList = By.xpath("//h4/a");

    @CacheLookup
    @FindBy(id= "input-sort")
    WebElement sortBy ;
   // By sortBy = By.id("input-sort");





    public WebElement getDesktopsText() {
        return desktopsText;
    }



    public ArrayList<String> getProductsNameList() {
      //  List<WebElement> products = getListOfElements(webElementList());
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : productsList) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }
    public void selectProductByName(String product) {
       // List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : productsList) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }
}

