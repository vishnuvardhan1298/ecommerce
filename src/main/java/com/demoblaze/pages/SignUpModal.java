package com.demoblaze.pages;

import com.demoblaze.core.BasePage;
import com.demoblaze.core.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpModal extends BasePage {
    private Waits waits;

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpButton;

    public SignUpModal(WebDriver driver) {
        super(driver);
        waits = new Waits(driver);
    }

    public void signUp(String username, String password) {
        waits.waitForVisibility(usernameField);
        type(usernameField, username);
        type(passwordField, password);
        click(signUpButton);
        
        
    }
}


