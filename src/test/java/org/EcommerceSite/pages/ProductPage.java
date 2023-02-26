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

    private WebElement productPrice() {
        return driver.findElement(By.cssSelector("h3.price-new"));
    }

    public String getProductTitle() {
        return productTitle().getText();
    }

    public String getProductPrice() {
        return productPrice().getText();
    }



}
