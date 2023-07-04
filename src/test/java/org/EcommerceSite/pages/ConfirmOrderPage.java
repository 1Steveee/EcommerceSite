package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmOrderPage {
    private final WebDriverWait wait;
    private WebDriver driver;

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds (10));
    }

    private WebElement productName() {
        return driver.findElement(By.cssSelector("#content > div > table > tbody > tr > td:nth-child(1)"));
    }

    private WebElement checkOutQuantity() {
        return driver.findElement(By.cssSelector("#content > div > table > tbody > tr > td:nth-child(3)"));
    }

    private WebElement totalPrice() {
        return driver.findElement(By.cssSelector("#content > div > table > tfoot > tr:nth-child(3) > td:nth-child(2)"));
    }
    private WebElement subTotalPrice() {
        return driver.findElement(By.cssSelector("#content > div > table > tfoot > tr:nth-child(1) > td:nth-child(2)"));
    }

    private WebElement confirmOrderButton() {
        return driver.findElement(By.id("button-confirm"));
    }

    private WebElement paymentAddress() {
        return driver.findElement(By.cssSelector("#content > div > div:nth-child(1) > div > div"));
    }

    private WebElement shippingAddress() {
        return driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > div"));
    }

    private WebElement successIcon() {
        return driver.findElement(By.cssSelector("#content > h1 > i"));
    }

    public String getProductName() {
        return productName().getText();
    }

    public String getCheckOutQuantity() {
        return checkOutQuantity().getText();
    }


    public String getSubtotalPrice() {
        return subTotalPrice().getText();
    }

    public String getTotalPrice() {
        return totalPrice().getText();
    }

    public String getPaymentAddress() {
        return paymentAddress().getText();
    }

    public String getShippingAddress() {
        return shippingAddress().getText();
    }

    public SuccessPage confirmOrder() {
        confirmOrderButton().click();
        this.wait.until(ExpectedConditions.visibilityOf(successIcon()));
        return new SuccessPage(this.driver);
    }
}
