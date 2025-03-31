// filepath: /Users/lorenzourbini/Documents/code_challenge/src/main/java/com/example/listeners/TestListener.java
package com.example.listeners;

import com.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        // No action needed on test start
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // No action needed on test success
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture a screenshot on test failure
        Object testClass = result.getInstance();
        try {
            driver = (WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
            ScreenshotUtil.takeScreenshot(driver, result.getName() + ".png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // No action needed on test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No action needed
    }

    @Override
    public void onStart(ITestContext context) {
        // No action needed on start
    }

    @Override
    public void onFinish(ITestContext context) {
        // No action needed on finish
    }
}