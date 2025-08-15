package com.demoblaze.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {

    private WebDriver driver;

    @FindBy(id = "signin2")
    private WebElement signUpLink;

    @FindBy(id = "login2")
    private WebElement loginLink;

    @FindBy(id = "nameofuser")
    private WebElement loggedInUser;

    @FindBy(id = "logout2")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[text()='Cart']")
    private WebElement cartLink;

    public NavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to Sign Up modal
    public void clickSignUp() {
        signUpLink.click();
    }

    // Navigate to Login modal
    public void clickLogin() {
        loginLink.click();
    }

    // Click Logout
    public void clickLogout() {
        logoutLink.click();
    }

    // Go to Cart page
    public void clickCart() {
        cartLink.click();
    }

    // Go to Home page
    public void clickHome() {
        homeLink.click();
    }

    // Get logged in username text
    public String getLoggedInUsername() {
        return loggedInUser.getText();
    }

    // Helper to navigate directly using driver (removes unused warning)
    public void navigateTo(String url) {
        driver.get(url);
    }
}

