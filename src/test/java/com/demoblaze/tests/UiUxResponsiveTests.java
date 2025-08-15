package com.demoblaze.tests;

import com.demoblaze.core.BaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

public class UiUxResponsiveTests extends BaseTest {

    @Test
    public void testResponsiveDesign() {
        // Desktop view
        driver.manage().window().setSize(new Dimension(1920, 1080));

        // Tablet view
        driver.manage().window().setSize(new Dimension(768, 1024));

        // Mobile view
        driver.manage().window().setSize(new Dimension(375, 667));
    }
}


