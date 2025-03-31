package com.example.test.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    // Constructor to initialize the driver and elements
    public LoginPage(WebDriver driver, FluentWait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Web elements on the login page
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    // Actions
    public void openLoginPage(String url) {
        driver.get(url);
        // TODO: Replace this with a more robust explict wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void enterUsername(String username) {
        wait.until(
                d -> {
                    usernameField.sendKeys(username);
                    return true;
                });
    }

    public void enterPassword(String password) {
        wait.until(
                d -> {
                    passwordField.sendKeys(password);
                    return true;
                });
    }

    public void clickLoginButton() {
        // TODO: Make sure element is clickable
        loginButton.click();
    }
}