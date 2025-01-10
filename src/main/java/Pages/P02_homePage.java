package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class P02_homePage {
    SHAFT.GUI.WebDriver driver;
    private static final Logger logger = LogManager.getLogger(P02_homePage.class);
    private static final int TIMEOUT = 10; // Timeout in seconds

    // Constructor to initialize the driver
    public P02_homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the Home page
    private final By adminTab = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");
    private final By requiredFieldForUsername = By.xpath("//div[@class=\"oxd-form-row\" and contains(.,\"Username\")]//*[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");
    private final By requiredFieldForPassword = By.xpath("//div[@class=\"oxd-form-row\" and contains(.,\"Password\")]//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");


    // Method to navigate to the Admin page
    public void selectAdminFromPanel() {
        // Click on the Admin tab to navigate to the Admin page
        driver.element().click(adminTab);

        // Return an instance of P03_adminPage for method chaining
    }
    public void validateThatDidNotLoginDueToEmptyFields() {
        logger.info("Validating failed login due to empty fields...");
        driver.assertThat().element(requiredFieldForUsername).exists().perform();
        driver.assertThat().element(requiredFieldForPassword).exists().perform();
    }
}