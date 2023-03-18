package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderPage {
    private WebDriver driver;

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
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
        return driver.findElement(By.cssSelector(".buttons > #button-confirm"));
    }

    private WebElement paymentAddress() {
        return driver.findElement(By.cssSelector("#content > div > div:nth-child(1) > div > div"));
    }

    private WebElement shippingAddress() {
        return driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > div"));
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
        System.out.println(paymentAddress().getText());
        return paymentAddress().getText();
    }

    public String getShippingAddress() {
        System.out.println(shippingAddress().getText());
        return shippingAddress().getText();
    }

    public SuccessPage confirmOrder() {
        confirmOrderButton().click();
        return new SuccessPage(this.driver);
    }
}
