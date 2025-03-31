package com.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.example.test.pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MainTest {
    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
            // capabilities.setCapability("goog:chromeOptions", Map.of("binary",
            // "../driver/chromedriver"));
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
            // capabilities.setCapability("moz:firefoxOptions", Map.of("binary",
            // "../driver/geckodriver"));
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @Test
    public void sampleTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage("https://practicetestautomation.com/practice-test-login/");
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://practicetestautomation.com/logged-in-successfully/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}