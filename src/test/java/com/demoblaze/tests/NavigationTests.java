package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import com.demoblaze.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigateToPhonesCategory() {
        HomePage home = new HomePage(driver);

        // Step 1: Navigate to category
        home.navigateToCategory("Phones");

        // Step 2: Verify that products for that category are displayed
        boolean isCategoryDisplayed = home.isCategoryDisplayed("Phones");
        Assert.assertTrue(isCategoryDisplayed, "❌ Phones category products are not displayed.");
        System.out.println("✅ Successfully navigated to Phones category.");
    }
}
