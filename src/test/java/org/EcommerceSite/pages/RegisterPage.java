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

    private void sendKeys(String fieldId, String string) {
        driver.findElement(By.cssSelector(fieldId)).sendKeys(string);
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

        sendKeys("input#input-firstname", firstName);
        sendKeys("input#input-lastname", lastName);
        sendKeys("input#input-email", email);
        sendKeys("input#input-telephone",telephone);
        sendKeys("input#input-password",password);
        sendKeys("input#input-confirm",password);
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
