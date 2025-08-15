package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(By.linkText("Add to cart")).click();
    }

    public void placeOrder() {
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }

    // ✅ New method to verify if product exists in cart
    public boolean isProductInCart(String productName) {
        try {
            return driver.findElement(By.xpath("//td[text()='" + productName + "']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}



