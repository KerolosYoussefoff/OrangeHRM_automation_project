package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_addRequestPage {
    SHAFT.GUI.WebDriver driver;

    // Constructor to initialize the driver
    public P04_addRequestPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the Add Request page
    private final By userRoleSelect = By.xpath("(//label[contains(  . ,\"User Role\" )] // following::div[1])");
    private final By selectRoleAdmin = By.xpath("//*[@class=\"oxd-select-option\" and contains(. , \"Admin\")]");
    private final By employeeName = By.xpath("//label[contains( . ,\"Employee Name\" )] // following::input[1]");
    private final By nameOfEmployee = By.xpath("//*[@class=\"oxd-userdropdown-name\"]");
    private final By selectNameOfEmployee = By.xpath("//*[@role=\"option\"][1]");
    private final By employeeStatus = By.xpath("//label[contains(  . ,\"Status\" )] // following::div[1]");
    private final By selectEmployeeStatus = By.xpath("//div[@class=\"oxd-select-option\" and contains(. , \"Enabled\")] ");
    private final By employeeUsername = By.xpath("//label[contains(.,\"Username\" )]//following::input[1]");
    private final By employeePassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@type='password']");
    private final By confirmEmployeePassword = By.xpath("//label[contains(. , \"Confirm Password\")]//following::input[1]");
    private final By saveButton = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

    // Method to fill in employee data and save the request
    public P03_adminPage fillData(String employeeUserNameData, String employeePasswordData, String confirmEmployeePasswordData) {
        // Click on the User Role dropdown and select 'Admin'
        driver.element()
                .click(userRoleSelect)
                .and().click(selectRoleAdmin);

        // Type the employee name (fetched from the home page) into the Employee Name field
        driver.element().type(employeeName, getEmployeeName(nameOfEmployee));

        // Wait for the employee name dropdown to appear and select the first option
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectNameOfEmployee));
        driver.element().click(selectNameOfEmployee);

        // Click on the Employee Status dropdown and select 'Enabled'
        driver.element()
                .click(employeeStatus)
                .and().click(selectEmployeeStatus);

        // Fill in the username, password, and confirm password fields
        driver.element()
                .type(employeeUsername, employeeUserNameData)
                .and().type(employeePassword, employeePasswordData)
                .and().type(confirmEmployeePassword, confirmEmployeePasswordData);

        // Click the Save button to submit the form
        driver.element().click(saveButton);

        // Return an instance of P03_adminPage for method chaining
        return new P03_adminPage(driver);
    }

    // Helper method to get the employee name from the home page
    private String getEmployeeName(By locator) {
        return driver.element().getText(locator);
    }
}