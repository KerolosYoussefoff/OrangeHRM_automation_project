package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_loginPageStep {
    SHAFT.GUI.WebDriver driver;

    // Constructor to initialize the driver
    public P01_loginPageStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators for elements on the Login page
    private final By userNameInput = By.xpath("//*[@name=\"username\"]");
    private final By passwordInput = By.xpath("//*[@type=\"password\"]");
    private final By submitBtn = By.xpath("//*[@type=\"submit\"]");

    // Method to perform login steps
    public P02_homePage loginSteps(String userName, String password) {
        // Enter the username and password
        driver.element()
                .type(userNameInput, userName) // Type the username
                .and().type(passwordInput, password); // Type the password

        // Click the submit button to log in
        driver.element().click(submitBtn);

        // Return an instance of P02_homePage for method chaining
        return new P02_homePage(driver);
    }
}