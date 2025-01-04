package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_homePage {
    SHAFT.GUI.WebDriver driver;

    // Constructor to initialize the driver
    public P02_homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the Home page
    private final By adminTab = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");

    // Method to navigate to the Admin page
    public void selectAdminFromPanel() {
        // Click on the Admin tab to navigate to the Admin page
        driver.element().click(adminTab);

        // Return an instance of P03_adminPage for method chaining
    }
}