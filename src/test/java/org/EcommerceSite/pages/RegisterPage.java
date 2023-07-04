package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private MainPage mainPage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement myAccountLink() {
        return driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
    }

    private WebElement passwordConfirmField() {
        return driver.findElement(By.id("input-confirm"));
    }

    private WebElement firstNameField() {
        return driver.findElement(By.id("input-firstname"));
    }

    private WebElement lastNameField() {
        return driver.findElement(By.id("input-lastname"));
    }

    private WebElement passwordField() {
        return driver.findElement(By.id("input-password"));
    }

    private WebElement telephoneField() {
        return driver.findElement(By.id("input-telephone"));
    }

    private WebElement emailField() {
        return driver.findElement(By.id("input-email"));
    }

    private WebElement agreeButton() {
        return driver.findElement(By.cssSelector(".custom-checkbox > label"));
    }

    private WebElement continueButton() {
        return driver.findElement(By.cssSelector(".buttons .btn-primary"));
    }

    private WebElement logoutButton() {
        return driver.findElement(By.cssSelector("ul > li:nth-child(6) > ul > li:nth-child(6) > a"));
    }

    public String accountCreationSuccessMessage() {
        return driver.findElement(By.cssSelector("h1.my-3")).getText();
    }

    public void registerAccount(String firstName, String lastName, String email, String telephone, String password) {
        this.mainPage = new MainPage(driver);
        this.mainPage.clickRegisterAccount();

        firstNameField().sendKeys(firstName);
        lastNameField().sendKeys(lastName);
        emailField().sendKeys(email);
        telephoneField().sendKeys(telephone);
        passwordField().sendKeys(password);
        passwordConfirmField().sendKeys(password);
        agreeButton().click();
        continueButton().click();
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(Duration.ofSeconds(2)).build().perform();
    }

    public boolean isUserLoggedIn() {
        moveToElement(myAccountLink());
        boolean isLogoutButtonDisplayed = logoutButton().isDisplayed();
        driver.navigate().refresh();
        return isLogoutButtonDisplayed;
    }
}
