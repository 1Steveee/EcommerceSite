package org.EcommerceSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            createChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            createFirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            createEdgeDriver();
        } else {
            System.out.println("Browser should either be chrome, edge, or firefox.");
        }

        setUpFullScreen();
    }

    private void createEdgeDriver() {
        driver = new EdgeDriver();
    }

    private void createFirefoxDriver() {
        driver = new FirefoxDriver();
    }

    private void createChromeDriver() {
        driver = new ChromeDriver();
    }

    public void stopDriver() {
        driver.quit();
    }

    private void setUpFullScreen() {
        driver.manage().window().maximize();
    }


}
