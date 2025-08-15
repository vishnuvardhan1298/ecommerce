package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");
    private By confirmationDialog = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//p");
    private By okButton = By.xpath("//button[text()='OK']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public String confirmOrder() {
        driver.findElement(purchaseButton).click();
        String confirmation = driver.findElement(confirmationDialog).getText();
        driver.findElement(okButton).click();
        return confirmation;
    }
}


