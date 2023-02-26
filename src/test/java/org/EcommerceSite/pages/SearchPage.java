package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(By.cssSelector("div:nth-child(1) > div > .caption > h4 > a")).getText();
    }

    public String getProductPrice() {
        return driver.findElement(By.cssSelector("div:nth-child(1) > div > .caption > div > .price-new")).getText();
    }
}
