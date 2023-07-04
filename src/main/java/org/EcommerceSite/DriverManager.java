package org.EcommerceSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.remote.Browser.*;

public class DriverManager {
    private final String HUB_URL = "http://localhost:4444/wd/hub";
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
        } else if(browser.equalsIgnoreCase("remote-chrome")) {
            createRemoteChromeDriver();
        } else if(browser.equalsIgnoreCase("remote-firefox")) {
            createRemoteFireFoxDriver();
        } else if(browser.equalsIgnoreCase("remote-edge")) {
            createRemoteEdgeDriver();
        }
        else {
            System.out.println("Browser should either be chrome, edge, or firefox.");
        }

        setUpTimeOut();
        setUpFullScreen();
    }

    private void createRemoteChromeDriver() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName ("chrome");
            driver = new RemoteWebDriver(new URL(HUB_URL), caps);
        } catch (final MalformedURLException e) {
            System.out.println(e.toString());
        }
    }

    private void createRemoteEdgeDriver () {
        try {
            DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName(EDGE.browserName());
            caps.setVersion("114.0");
            driver = new RemoteWebDriver (new URL (HUB_URL), caps);
        } catch (final MalformedURLException e) {
            System.out.println(e.toString());
        }
    }

    private void createRemoteFireFoxDriver () {
        try {
            DesiredCapabilities caps = new DesiredCapabilities ();
            caps.setBrowserName (FIREFOX.browserName());
            driver = new RemoteWebDriver (new URL (HUB_URL), caps);
        } catch (final MalformedURLException e) {
            System.out.println(e.toString());
        }
    }

    private void createEdgeDriver() {
        driver = new EdgeDriver();
    }

    private void createFirefoxDriver() {
        driver = new FirefoxDriver();
    }

    private void createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void stopDriver() {
        driver.quit();
    }

    private void setUpFullScreen() {
        driver.manage().window().maximize();
    }

    private void setUpTimeOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
