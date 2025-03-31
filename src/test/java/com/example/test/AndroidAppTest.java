package com.example.test;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.example.utils.RetryAnalyzer;

import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidAppTest {
    // TODO: Configure the timeout globally
    @Test(timeOut = 30000, retryAnalyzer = RetryAnalyzer.class)
    public void SampleTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554"); // Replace with your emulator's name
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("chromedriverExecutable",
                "/Users/lorenzourbini/Documents/Documents - MacBook Pro di Lorenzo/code_challenge/src/test/java/com/example/driver/chromedriver_128");

        // Point to the local APK file, a webview version of the website
        caps.setCapability("app",
                "/Users/lorenzourbini/Documents/Documents - MacBook Pro di Lorenzo/code_challenge/androidWebViewApp/app-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        Thread.sleep(5000); // Wait for 5 seconds to observe the app

        // Switch to WebView context
        // Set<String> contextNames = driver.getContextHandles();
        // for (String contextName : contextNames) {
        // System.out.println("Available context: " + contextName);
        // }

        // Switch to WebView
        driver.context("WEBVIEW_com.example.mywebsite");

        // Interact with the login form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("student");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Password123");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

        // TODO: Replace with explicit wait
        Thread.sleep(5000); // Wait for 5 seconds to redirect

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://practicetestautomation.com/logged-in-successfully/");

        driver.quit();
    }
}