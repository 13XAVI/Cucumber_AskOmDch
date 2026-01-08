package com.tau.Cucumber_AskOmDch;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage{
    private WebDriver driver;
    private WebDriverWait wait;
    private  By account = By.id("menu-item-1237");
    private  By store = By.id("menu-item-1227");
    private By addToCartButton = By.cssSelector("a.add_to_cart_button");
    private By viewCartButton = By.cssSelector("a.added_to_cart.wc-forward");


    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait =  new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void clickPageMenu(By menuItem){
        driver.findElement(menuItem).click();
    }

    public AccountPage clickAccount(){
        clickPageMenu(account);
        return new AccountPage(driver);
    }
    public HomePage goToHomePage(){
        return this;
    }
    public StorePage clickToStorePage(){
        clickPageMenu(store);
        return new StorePage(driver);
    }

    public HomePage clickToAddToCart(){
        clickPageMenu(addToCartButton);
        return this;
    }
    public String getViewCartText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton)).getText();
    }

    public CartPage clickViewCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton)).click();
        return new CartPage(driver);
    }




}

