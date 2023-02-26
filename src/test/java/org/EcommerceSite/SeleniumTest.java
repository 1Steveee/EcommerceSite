package org.EcommerceSite;

import com.github.javafaker.Faker;
import org.EcommerceSite.pages.MainPage;
import org.EcommerceSite.pages.ProductPage;
import org.EcommerceSite.pages.RegisterPage;
import org.EcommerceSite.pages.SearchPage;
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
    private String productName;
    private String productPrice;
    private SearchPage searchPage;

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
        this.productName = searchPage.getProductName();
        this.productPrice = searchPage.getProductPrice();
        assertEquals(productName, "iPhone");
        assertEquals(productPrice, "$123.20");

    }

    @Test(dependsOnMethods = "testSearchForCategoryAndProduct")
    public void testAddProductToCart() {
        ProductPage productPage = this.searchPage.navigateToIphoneProductPage();

        assertEquals(this.productName, productPage.getProductTitle());
        assertEquals(this.productPrice, productPage.getProductPrice());

        //create product page method to add product to cart by quantity

        productPage.addProductToCart(5);

        //assert success message
    }

}
