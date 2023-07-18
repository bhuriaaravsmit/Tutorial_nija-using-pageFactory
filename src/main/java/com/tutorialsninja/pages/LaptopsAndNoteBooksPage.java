package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath= "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

  //  @CacheLookup
    @FindBy(xpath= "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath= "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id= "input-sort")
    WebElement sortBy;


    //By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
   // By productsPrices = By.xpath("//p[@class ='price']");
   // By productsList = By.xpath("//h4/a");
 //   By sortBy = By.id("input-sort");



    public WebElement getLaptopsAndNotebooksText() {
        return laptopsAndNotebooksText;
    }

    public ArrayList<Double> getProductsPriceList() {
      //  List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : productsPrices) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
      //  List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : productsList) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}

