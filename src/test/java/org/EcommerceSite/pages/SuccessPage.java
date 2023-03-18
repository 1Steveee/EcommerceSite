package org.EcommerceSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {

    private WebDriver driver;
    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement successConfirmationMessage() {
        return driver.findElement(By.cssSelector("#content > p:nth-child(3)"));
    }

    private WebElement successHeaderMessage() {
        return driver.findElement(By.cssSelector("#content > h1"));
    }

    public String getSuccessHeaderMessage() {
        return successHeaderMessage().getText();
    }

    public String getSuccessConfirmationMessage() {
        return successConfirmationMessage().getText();
    }
}
