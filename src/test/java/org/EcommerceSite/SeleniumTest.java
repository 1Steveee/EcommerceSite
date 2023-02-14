package org.EcommerceSite;

import org.EcommerceSite.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setupTest() {
        this.driver = driverManager.getDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    @Test
    public void testUserRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.registerAccount();

    }
}
