package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.kodilla.testing2.config.WebDriverConfig.CHROME;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "gLFyf";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(CHROME);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.className(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
