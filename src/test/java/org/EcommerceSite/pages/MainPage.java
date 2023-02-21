package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement myAccountLink() {
        return driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
    }

    private WebElement productSearchField() {
        return driver.findElement(By.name("search"));
    }

    private WebElement productLink() {
        return driver.findElement(By.cssSelector("a#mz-product-grid-image-40-212469"));
    }

    private WebElement searchButton() {
        return driver.findElement(By.cssSelector(".search-button > button.type-text"));
    }

    private WebElement registerLink() {
        return driver.findElement(By.cssSelector(".mz-sub-menu-96 > li:nth-child(2) > a"));
    }

    public void clickRegisterAccount() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink()).pause(Duration.ofSeconds(2))
                .click(registerLink()).build().perform();

    }

    public void navigateToProductPage(String productName) {
        productSearchField().sendKeys(productName);
        searchButton().click();
        productLink().click();
    }
}
