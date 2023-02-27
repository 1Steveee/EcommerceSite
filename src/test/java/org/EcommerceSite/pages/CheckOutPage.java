package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(By.cssSelector("td.text-left > a")).getText();
    }

}
