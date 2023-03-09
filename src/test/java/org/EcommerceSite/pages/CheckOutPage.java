package org.EcommerceSite.pages;

import org.EcommerceSite.Data.BillingUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    private WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getCheckoutFormField(String id) {
        return driver.findElement(By.id(id));
    }

    private WebElement agreeToTermsCheckbox() {
        return driver.findElement(By.cssSelector("#input-agree + label"));
    }

    private WebElement continueButton() {
        return driver.findElement(By.id("button-save"));
    }

    private Select countryField() {
        return new Select(getCheckoutFormField("input-payment-country"));
    }

    private Select stateField() {
        return new Select(getCheckoutFormField("input-payment-zone"));
    }
    private void inputFormData(BillingUserData billingUserData) {
        getCheckoutFormField("input-payment-firstname").sendKeys(billingUserData.getFirstName());
        getCheckoutFormField("input-payment-lastname").sendKeys(billingUserData.getLastName());
        getCheckoutFormField("input-payment-address-1").sendKeys(billingUserData.getStreetAddress());
        getCheckoutFormField("input-payment-city").sendKeys(billingUserData.getCity());
        getCheckoutFormField("input-payment-postcode").sendKeys(billingUserData.getPostalCode());
        countryField().selectByVisibleText(billingUserData.getCountry());
        stateField().selectByVisibleText(billingUserData.getState());

    }

    public String getCheckOutQuantity() {
        return driver.findElement(By.cssSelector("tr > td:nth-child(3) > div > input")).getAttribute("value");
    }
    public String getProductName() {
        return driver.findElement(By.cssSelector("td.text-left > a")).getText();
    }

    public String getSubtotalPrice() {
        return driver.findElement
                (By.cssSelector("#checkout-total > tbody > tr:nth-child(1) > td.text-right > strong")).getText();
    }

    public String getTotalPrice() {
        return driver.findElement
                (By.cssSelector("#checkout-total > tbody > tr:nth-child(5) > td.text-right > strong")).getText();
    }

    public ConfirmOrderPage checkout(BillingUserData billingUserData) {
        inputFormData(billingUserData);
        agreeToTermsCheckbox().click();
        continueButton().click();
        return new ConfirmOrderPage(driver);
    }



}
