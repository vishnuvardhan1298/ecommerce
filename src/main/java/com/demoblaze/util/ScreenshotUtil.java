package com.demoblaze.util;

import com.demoblaze.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName) {
        WebDriver driver = DriverFactory.getDriver();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
            Files.copy(source.toPath(), Paths.get(destinationPath));
            System.out.println("✅ Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }

        return destinationPath;
    }
}

