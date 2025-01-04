package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_adminPage {
    SHAFT.GUI.WebDriver driver;
    private static int originalNumberOfRecords, currentNumberOfRecords;

    // Constructor to initialize the driver
    public P03_adminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the Admin page
    private final By numOfRecords = By.xpath("//*[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]//span[contains(. , \"Records\")]");
    private final By addButton = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\" and contains(., \"Add\")]");
    private final By successfulMsg = By.xpath("//*[@class=\"oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text\"]");
    private final By searchUsername = By.xpath("//div[@class=\"oxd-grid-item oxd-grid-item--gutters\" and contains(. , \"Username\")]//input[1]");
    private final By submitButton = By.xpath("//button[@type=\"submit\"]");
    private final By deleteButton = By.xpath("//div[@class=\"oxd-table-card\" and contains(., \"kerolosypised\")]//button[@type=\"button\"]//i[@class=\"oxd-icon bi-trash\"]");
    private final By deleteAlert = By.xpath("//*[@role=\"document\"]");
    private final By yesDeleteButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");

    // Method to get the number of records displayed on the page
    public int getNumberOfRecords() {
        // SHAFT automatically waits for the element to be visible and interactable
        String text = driver.element().getText(numOfRecords).replaceAll("[^0-9]+", "");

        // Check if the text is empty or null
        if (text.isEmpty()) {
            throw new RuntimeException("No numeric value found in the element text.");
        }

        // Parse and return the integer value
        return Integer.parseInt(text);
    }

    // Method to click on the 'Add' button and navigate to the Add Request page
    public P04_addRequestPage clickOnAdd() {
        driver.element().click(addButton);
        return new P04_addRequestPage(driver);
    }

    // Method to verify that the user was saved successfully by checking the success message
    public P03_adminPage userSavedSuccessfully() {
        driver.element().assertThat(successfulMsg).isVisible().perform();
        return this;
    }

    // Method to store the original number of records before any operation
    public P03_adminPage getOriginalNumberOfRecords() {
        originalNumberOfRecords = getNumberOfRecords();
        System.out.println("The original number of records is: " + originalNumberOfRecords);
        return this;
    }

    // Method to store the current number of records after an operation
    public P03_adminPage getCurrentNumberOfRecords() {
        currentNumberOfRecords = getNumberOfRecords();
        System.out.println("The current number of records is: " + currentNumberOfRecords);
        return this;
    }

    // Method to verify that the number of records increased by one
    public P03_adminPage verifyTheRecordsIncreasedByOne() {
        SHAFT.Validations.verifyThat().object(currentNumberOfRecords).isEqualTo(originalNumberOfRecords + 1).perform();
        return this;
    }

    // Method to verify that the number of records decreased by one
    public void verifyTheRecordsDecreasedByOne() {
        SHAFT.Validations.verifyThat().object(currentNumberOfRecords).isEqualTo(originalNumberOfRecords - 1).perform();
    }

    // Method to search for a user by their username
    public P03_adminPage searchByUsername(String username) {
        driver.element().type(searchUsername, username).and().click(submitButton);
        return this;
    }

    // Method to perform the delete process for a user
    public P03_adminPage deleteProcess() {
        driver.element().click(deleteButton);

        // Wait for the delete confirmation alert to appear
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(deleteAlert));

        // Click on the 'Yes, Delete' button to confirm deletion
        driver.element().click(yesDeleteButton);
        return this;
    }

    // Method to refresh the current page
    public P03_adminPage refreshPage3() {
        driver.browser().refreshCurrentPage();
        return this;
    }
}