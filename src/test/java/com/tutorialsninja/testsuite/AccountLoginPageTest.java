package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {

    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;


    @BeforeMethod(groups = {"sanity","smoke" ,"regression"})
    public void inIT() {
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();
    }


    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        sleep(2000);
        homePage.selectMyAccountOptions("Login");
        sleep(2000);
        Assert.assertEquals(accountLoginPage.getReturningCustomerText().getText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = "smoke")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("Prime1234_7@gmail.com");
        accountLoginPage.enterPassword("Prime123");
        accountLoginPage.clickOnLoginButton();
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.getAccountLogoutText().getText(), "Account Logout", "Not logged out");
    }

}

