package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    private By title = By.cssSelector(".title");
    private By inventoryContainer = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElements(inventoryContainer).size() > 0;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
