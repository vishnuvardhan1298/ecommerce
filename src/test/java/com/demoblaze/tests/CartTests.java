package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.CartPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testAddToCart() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        // Step 1: Select a product
        home.selectProduct("Samsung galaxy s6");

        // Step 2: Add to cart
        cart.addToCart();

        // Step 3: Handle alert
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        System.out.println("Alert after adding to cart: " + alertText);

        // Step 4: Go to cart page
        home.goToCart();

        // Step 5: Verify product is in cart
        boolean productInCart = cart.isProductInCart("Samsung galaxy s6");
        Assert.assertTrue(productInCart, "❌ Product was not found in the cart.");
        System.out.println("✅ Product successfully added to cart.");
    }
}
