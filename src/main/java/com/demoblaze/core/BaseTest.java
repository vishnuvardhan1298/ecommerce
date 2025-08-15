package com.demoblaze.core;

import com.demoblaze.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        // Load values from config.properties
        baseUrl = ConfigReader.get("baseUrl");
        String browser = ConfigReader.get("browser");

        // Validate config properties
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new RuntimeException("❌ Missing property 'baseUrl' in config.properties");
        }
        if (browser == null || browser.trim().isEmpty()) {
            throw new RuntimeException("❌ Missing property 'browser' in config.properties");
        }

        // Setup WebDriverManager for browser drivers
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("❌ Browser not supported: " + browser);
        }

        // Maximize browser window
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Could not maximize window. Continuing...");
        }

        // Set implicit wait and navigate
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
