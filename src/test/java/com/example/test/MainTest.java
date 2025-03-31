package com.example.test;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.example.test.pages.LoginPage;
import com.example.utils.RetryAnalyzer;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MainTest {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

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
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);
    }

    // TODO: Configure the timeout globally
    @Test(timeOut = 30000, retryAnalyzer = RetryAnalyzer.class)
    public void sampleTest() {

        LoginPage loginPage = new LoginPage(driver, wait);
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