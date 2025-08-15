package com.demoblaze.pages;

import com.demoblaze.core.BasePage;
import com.demoblaze.core.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderModal extends BasePage {
    private Waits waits;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    public PlaceOrderModal(WebDriver driver) {
        super(driver);
        waits = new Waits(driver);
    }

    public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        waits.waitForVisibility(nameField);
        type(nameField, name);
        type(countryField, country);
        type(cityField, city);
        type(cardField, card);
        type(monthField, month);
        type(yearField, year);
    }

    public void clickPurchase() {
        click(purchaseButton);
    }
}
