package org.EcommerceSite;

import org.EcommerceSite.Data.BillingUserData;
import org.EcommerceSite.Data.RegisterUserData;
import org.EcommerceSite.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.EcommerceSite.Data.DataBuilder.getBillingUserData;
import static org.EcommerceSite.Data.DataBuilder.getRegisterUserData;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SeleniumTest extends BaseTest {

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    //Make Global Price and Global Search Value

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void testUserRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterUserData registerUserData = getRegisterUserData();
        registerPage.registerAccount(registerUserData.getFirstName(), registerUserData.getLastName(), registerUserData.getEmail(), registerUserData.getTelephone(), registerUserData.getPassword());
        // Create a person or profile class
        // Reg
        assertEquals(registerPage.accountCreationSuccessMessage(), "Your Account Has Been Created!");
        assertTrue(registerPage.isUserLoggedIn());
    }

    @Test(dependsOnMethods = "testUserRegistration")
    public void testSearchForCategoryAndProduct() {
        // String searchValue = "iPhone"
        // Use DataProvider - use website
        this.searchPage = this.mainPage.searchForCategoryAndProduct("Phones & PDAs", "iphone");
        // use data provider to let user pick product
        String searchPageProductName = searchPage.getProductName();
        String searchPageProductPrice = searchPage.getProductPrice();
        assertEquals(searchPageProductName, "iPhone");
        assertEquals(searchPageProductPrice, "$123.20");

        this.productPage = this.searchPage.navigateToIphoneProductPage();
        assertEquals(searchPageProductName, productPage.getProductTitle());
        assertEquals(searchPageProductPrice, productPage.getProductPrice());
    }

    @Test(dependsOnMethods = "testSearchForCategoryAndProduct")
    public void testAddProductToCart() {
        productPage.addProductToCart(5);
        assertEquals(productPage.addToCartSuccessMessage(), "Success: You have added\n" + this.productPage.getProductTitle() + "\n" + "to your\n" + "shopping cart\n" + "!");
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testCheckoutProduct() {
        CheckOutPage checkOutPage = this.productPage.checkOut();
        BillingUserData billingUserData = getBillingUserData();

        assertEquals(checkOutPage.getProductName(), "iPhone");
        assertEquals(checkOutPage.getCheckOutQuantity(), "5");
        assertEquals(checkOutPage.getSubtotalPrice(), "$505.00");
        assertEquals(checkOutPage.getTotalPrice(), "$624.00");
        ConfirmOrderPage confirmOrderPage = checkOutPage.checkout(billingUserData);
    }



}
