package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Login/Signup related ---
    public void clickLogin() {
        driver.findElement(By.id("login2")).click();
    }

    public void clickSignUp() {
        driver.findElement(By.id("signin2")).click();
    }

    public String getLoggedInUsername() {
        return driver.findElement(By.id("nameofuser")).getText();
    }

    // --- Product related ---
    public void selectProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void goToCart() {
        driver.findElement(By.id("cartur")).click();
    }

    // --- Navigation related ---
    public void navigateToCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }

    public boolean isCategoryDisplayed(String categoryName) {
        try {
            return driver.findElement(By.linkText(categoryName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}






