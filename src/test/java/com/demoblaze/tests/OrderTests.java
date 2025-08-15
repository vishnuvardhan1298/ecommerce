package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.OrderPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTests extends BaseTest {

    @Test
    public void testPlaceOrder() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        OrderPage order = new OrderPage(driver);

        // Step 1: Select a product
        home.selectProduct("Nokia lumia 1520");

        // Step 2: Add to cart
        cart.addToCart();

        // Step 3: Handle alert after adding to cart
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Step 4: Place the order
        cart.placeOrder();

        // Step 5: Fill out order form
        order.fillOrderForm("John Doe", "USA", "New York", "1234567812345678", "12", "2025");

        // Step 6: Confirm the order
        String confirmationText = order.confirmOrder();

        // Step 7: Verify confirmation message contains amount and success text
        Assert.assertTrue(confirmationText.contains("Id") && confirmationText.contains("Amount"),
                "❌ Order confirmation details not found.");

        System.out.println("✅ Order placed successfully. Details: " + confirmationText);
    }
}
