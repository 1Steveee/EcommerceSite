package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement productLink() {
        return driver.findElement(By.cssSelector("div:nth-child(1) > div > .caption > h4 > a"));
    }

    private WebElement productPrice() {
        return driver.findElement(By.cssSelector("div:nth-child(1) > div > .caption > div > .price-new"));
    }

    public String getProductName() {
        return productLink().getText();
    }

    public String getProductPrice() {
        return productPrice().getText();
    }

    public ProductPage navigateToIphoneProductPage() {
        productLink().click();
        return new ProductPage(driver);
    }
}
