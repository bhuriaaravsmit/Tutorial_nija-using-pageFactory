package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.AccountRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {
    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;

    @BeforeMethod(groups = {"sanity","smoke" ,"regression"})
    public void inIT() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        sleep(1000);
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText().getText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Register");
        accountRegisterPage.enterFirstName("prime" + getAlphaNumericString(4));
        accountRegisterPage.enterLastName("test" + getAlphaNumericString(4));
        accountRegisterPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        accountRegisterPage.enterTelephone("07988112233");
        accountRegisterPage.enterPassword("test123");
        accountRegisterPage.enterConfirmPassword("test123");
        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
        Assert.assertEquals(accountPage.getAccountCreatedText().getText(), "Your Account Has Been Created!",
                "Account not created");
        accountPage.clickOnContinueButton();
        homePage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        sleep(1000);
        Assert.assertEquals(accountPage.getAccountLogoutText().getText(), "Account Logout", "Not logged out");
        accountPage.clickOnContinueButton();
    }

}
