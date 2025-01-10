package orangeHRM;

import Pages.P01_loginPageStep;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {

    SHAFT.GUI.WebDriver driver; // SHAFT WebDriver instance
    SHAFT.TestData.JSON testData; // SHAFT TestData instance for JSON

    // Test method to verify login and navigation
    @Test
    public void testLoginAndNavigation() {
        // Perform login using credentials from test data
        new P01_loginPageStep(driver).loginSteps(
                        "", // Get username from test data
                        "") // Get password from test data
                .validateThatDidNotLoginDueToEmptyFields(); // Validate that the hme page didn't open due to empty fields
    }

    // Setup method to initialize the driver and load test data
    @BeforeClass
    public void setup() {
        // Initialize the SHAFT WebDriver
        driver = new SHAFT.GUI.WebDriver();

        // Navigate to the OrangeHRM application URL
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/");

        // Load test data from the JSON file
        testData = new SHAFT.TestData.JSON("D:\\automation testing\\shaft_project\\src\\test\\resources\\testDataFiles\\orangeHRMtestdata.json");
    }

    // Teardown method to close the browser after the test
    @AfterMethod
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
}