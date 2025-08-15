package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal {
    private WebDriver driver;

    public LoginModal(WebDriver driver) {
        this.driver = driver;
    }

    // Login method
    public void login(String username, String password) {
        driver.findElement(By.id("loginusername")).clear();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).clear();
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    // Sign up method
    public void signUp(String username, String password) {
        driver.findElement(By.id("sign-username")).clear();
        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).clear();
        driver.findElement(By.id("sign-password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
    }
}

