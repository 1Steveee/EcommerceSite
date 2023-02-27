package org.EcommerceSite;

import com.github.javafaker.Faker;
import org.EcommerceSite.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SeleniumTest extends BaseTest {

    private WebDriver driver;
    private Faker faker;
    private String email;
    private String firstName;
    private String lastName;
    private String telephone;
    private String password;
    private MainPage mainPage;
    private SearchPage searchPage;
    private ProductPage productPage;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        this.mainPage = new MainPage(driver);
        this.faker = new Faker();
        this.firstName = this.faker.name().firstName();
        this.lastName = this.faker.name().lastName();
        this.email = this.faker.internet().emailAddress();
        this.telephone = Integer.toString(this.faker.number().numberBetween(99900000, 99988888));
        this.password = this.faker.internet().password(8,12);
    }

    @Test
    public void testUserRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccount(this.firstName, this.lastName, this.email, this.telephone, this.password);
        // Create a person or profile class
        assertEquals(registerPage.accountCreationSuccessMessage(), "Your Account Has Been Created!");
        assertTrue(registerPage.isUserLoggedIn());
    }

    @Test(dependsOnMethods = "testUserRegistration")
    public void testSearchForCategoryAndProduct() {
        this.searchPage = this.mainPage.searchForCategoryAndProduct("Phones & PDAs","iphone");
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
        assertEquals(productPage.addToCartSuccessMessage(), "Success: You have added\n" +
                this.productPage.getProductTitle() + "\n" +
                "to your\n" +
                "shopping cart\n" +
                "!");
    }

    @Test(dependsOnMethods = "testAddProductToCart")
    public void testCheckoutProduct() {
        CheckOutPage checkOutPage = this.productPage.checkOut();
        assertEquals(checkOutPage.getProductName(), "iPhone");
        //how do I pass it multiple values so the actual result is not hard coded
    }

}
