// filepath: /Users/lorenzourbini/Documents/code_challenge/src/main/java/com/example/utils/ScreenshotUtil.java
package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), new File("./screenshots/" + fileName).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}