package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.kodilla.testing2.config.WebDriverConfig.CHROME;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "_nkw";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(CHROME);
        driver.get("https://www.ebay.com");

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
