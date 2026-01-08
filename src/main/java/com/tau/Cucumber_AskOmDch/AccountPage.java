package com.tau.Cucumber_AskOmDch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /** Account header */
    private By accountHeader = By.cssSelector(".wp-block-cover__inner-container h1");

    /** Login fields */
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.name("login");

    /** Registration fields */
    private By regUsername = By.id("reg_username");
    private By regEmail = By.id("reg_email");
    private By regPassword = By.id("reg_password");
    private By registerButton = By.name("register");

    /** Shared elements across login/registration */
    private By welcomeText = By.xpath("//p[contains(text(),'Hello')]");
    private By errorMessage = By.cssSelector(".woocommerce-error li");
    private By logout = By.linkText("Logout");

    /** Forgot Password elements */
    private By lostPassword = By.cssSelector("p.woocommerce-LostPassword a");
    private By recoverEmail = By.id("user_login");
    private By resetButton = By.cssSelector("button.woocommerce-Button");
    private By successMessage = By.cssSelector(".woocommerce-message");


    public AccountPage enterLoginUsername(String value) {
        driver.findElement(username).sendKeys(value);
        return this;
    }

    public AccountPage enterLoginPassword(String value) {
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public AccountPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    public AccountPage enterRegUsername(String value) {
        driver.findElement(regUsername).sendKeys(value);
        return this;
    }


    public AccountPage enterRegEmail(String value) {
        driver.findElement(regEmail).sendKeys(value);
        return this;
    }

    public AccountPage enterRegPassword(String value) {
        driver.findElement(regPassword).sendKeys(value);
        return this;
    }

    public AccountPage clickRegister() {
        driver.findElement(registerButton).click();
        return this;
    }

    public AccountPage clickLogout() {
        driver.findElement(logout).click();
        return this;
    }

    public String getWelcomeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public String getAccountHeader() {
        return driver.findElement(accountHeader).getText();
    }

    public AccountPage clickForgotPassword() {
        driver.findElement(lostPassword).click();
        return this;
    }

    public AccountPage sendLoginCredentialToReset(String email) {
        driver.findElement(recoverEmail).sendKeys(email);
        return this;
    }

    public AccountPage submitPasswordReset() {
        driver.findElement(resetButton).click();
        return this;
    }

    public String getResetSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getResetErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}

