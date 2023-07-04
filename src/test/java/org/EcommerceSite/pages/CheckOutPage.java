package org.EcommerceSite.pages;

import org.EcommerceSite.Data.BillingUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    private final WebDriverWait wait;
    private WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (this.driver, Duration.ofSeconds (10));
    }

    private WebElement getCheckoutFormFieldById(String id) {
        return driver.findElement(By.id(id));
    }

    private WebElement firstNameField(){
        return driver.findElement(By.id("input-payment-firstname"));
    }

    private WebElement lastNameField() {
        return driver.findElement(By.id("input-payment-lastname"));
    }

    private WebElement addressField() {
        return driver.findElement(By.id("input-payment-address-1"));
    }

    private WebElement cityField() {
        return driver.findElement(By.id("input-payment-city"));
    }

    private WebElement postCodeField() {
        return driver.findElement(By.id("input-payment-postcode"));
    }

    private WebElement agreeToTermsCheckbox() {
        return driver.findElement(By.cssSelector("#input-agree + label"));
    }

    private WebElement continueButton() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("button-save")));
    }

    private Select countryField() {
        return new Select(getCheckoutFormFieldById("input-payment-country"));
    }

    private Select stateField() {
        return new Select(getCheckoutFormFieldById("input-payment-zone"));
    }
    private void inputFormData(BillingUserData billingUserData) {
        //separate each field
        firstNameField().sendKeys(billingUserData.getFirstName());
        lastNameField().sendKeys(billingUserData.getLastName());
        addressField().sendKeys(billingUserData.getStreetAddress());
        cityField().sendKeys(billingUserData.getCity());
        postCodeField().sendKeys(billingUserData.getPostalCode());
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
