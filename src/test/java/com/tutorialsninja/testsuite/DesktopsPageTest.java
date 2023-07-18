package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage ;
    ProductPage productPage;

    ShoppingCartPage cartPage ;

    @BeforeMethod(groups = {"sanity","smoke" ,"regression"})
    public void inIT() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
    }



    @Test(groups = "sanity")
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        ArrayList<String> originalProductsName = desktopPage.getProductsNameList();
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        // Select sort by Name Z - A
        sleep(2000);
        desktopPage.selectSortByOption("Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        ArrayList<String> afterSortByZToAProductsName = desktopPage.getProductsNameList();
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        sleep(2000);
        homePage.selectCurrency("£Pound Sterling");
        homePage.mouseHoverOnDesktopsLinkAndClick();
        sleep(2000);
        homePage.selectMenu("Show AllDesktops");

        desktopPage.selectSortByOption("Name (A - Z)");
        desktopPage.selectProductByName("HP LP3065");
        Assert.assertEquals(productPage.getProductText().getText(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDeliveryDate("30", "November", "2023");
        productPage.enterQuantity("1");
        productPage.clickOnAddToCartButton();
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");
        productPage.clickOnShoppingCartLinkIntoMessage();
        Assert.assertTrue(cartPage.getShoppingCartText().getText().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName().getText(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(cartPage.getDeliveryDate().getText().contains("2023-11-30"), "Delivery date not matched");
        Assert.assertEquals(cartPage.getModel().getText(), "Product 21", "Model not matched");
  //      Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}

