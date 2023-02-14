package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement myAccountLink() {
        return driver.findElement(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"));
    }

    private WebElement registerLink() {
        return driver.findElement(By.cssSelector(".mz-sub-menu-96 > li:nth-child(2) > a"));
    }

    public void registerAccount() {
        Actions actions = new Actions(driver);

        actions.moveToElement(myAccountLink()).pause(Duration.ofSeconds(2))
                .moveToElement(registerLink()).build().perform();
    }
}
