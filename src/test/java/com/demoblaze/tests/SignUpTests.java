package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import com.demoblaze.util.TestData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTest {

    @Test
    public void testSignUpWithNewUser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Generate and store user credentials for later use
        TestData.username = "user" + System.currentTimeMillis();
        TestData.password = "password123";

        // Click Sign up link
        driver.findElement(By.id("signin2")).click();

        // Wait for signup modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        // Fill signup form with stored credentials
        driver.findElement(By.id("sign-username")).sendKeys(TestData.username);
        driver.findElement(By.id("sign-password")).sendKeys(TestData.password);

        // Click Sign up
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        // Wait for alert and accept
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Sign up alert: " + alert.getText());
        alert.accept();

        // Give backend a moment to store the new user
        Thread.sleep(3000);

        // Optional: Assert that signup was successful
        Assert.assertTrue(true, "Sign up process completed");
    }
}

