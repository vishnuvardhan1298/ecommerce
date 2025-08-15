package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import com.demoblaze.util.TestData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click login link
        driver.findElement(By.id("login2")).click();

        // Wait for modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));

        // Use credentials from SignUpTests via TestData
        driver.findElement(By.id("loginusername")).sendKeys(TestData.username);
        driver.findElement(By.id("loginpassword")).sendKeys(TestData.password);

        // Click login
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Check if alert appears (login failed)
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("❌ Login failed: " + alert.getText());
            alert.accept();
            Assert.fail("Login failed because an alert appeared.");
        } catch (TimeoutException e) {
            System.out.println("✅ No alert appeared after login attempt.");
        }

        // Only check for logout if no alert was found
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
        System.out.println("✅ Login successful.");
    }
}

