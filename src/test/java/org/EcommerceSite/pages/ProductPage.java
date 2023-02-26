package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement productTitle() {
        return driver.findElement(By.className("h3"));
    }

    private WebElement addQuantityButton() {
        return driver.findElement(By.cssSelector("#entry_216841 > div > .input-group-append > button"));
    }

    private WebElement addToCartButton() {
        return driver.findElement(By.cssSelector("#entry_216842 > button"));
    }

    private WebElement productPrice() {
        return driver.findElement(By.cssSelector("h3.price-new"));
    }

    public String getProductTitle() {
        return productTitle().getText();
    }

    public String getProductPrice() {
        return productPrice().getText();
    }

    private void addQuantity(int quantity) {
        for (int added = 0; added < quantity - 1; added++) {
            addQuantityButton().click();
        }
    }

    public void addProductToCart(int quantity) {
        addQuantity(5);
        addToCartButton().click();
    }
}
