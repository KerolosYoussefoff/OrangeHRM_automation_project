package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P04_addRequestPage {
    SHAFT.GUI.WebDriver driver;

    // constructor
    public P04_addRequestPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By userRoleSelect  =              By.xpath("(//label[contains(  . ,\"User Role\" )] // following::div[1])");
    By selectRoleAdmin =              By.xpath("//*[@class=\"oxd-select-option\" and contains(. , \"Admin\")]");
    By employeeName    =              By.xpath("//label[contains( . ,\"Employee Name\" )] // following::input[1]");
    By nameOfEmployee  =              By.xpath("//*[@class=\"oxd-userdropdown-name\"]");
    By employeeStatus  =              By.xpath("//label[contains(  . ,\"Status\" )] // following::div[1]");
    By selectEmployeeStatus =         By.xpath("//div[@class=\"oxd-select-option\" and contains(. , \"Enabled\")] ");
    By employeeUsername =             By.xpath("//label[contains(.,\"Username\" )]//following::input[1]");
    By employeePassword =             By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input[@type='password']");
    By confirmEmployeePassword =      By.xpath("//label[contains(. , \"Confirm Password\")]//following::input[1]");
    By saveButton  =                  By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

    // function to get the number of records
    public void fillData(String employeeUserNameData , String employeePasswordData , String confirmEmployeePasswordData ){
        driver.element()
                .click(userRoleSelect)  // driver clicks on the user role select
                .and().click(selectRoleAdmin) //driver selects the Admin role for employee
                .and().type(employeeName,getEmployeeName(nameOfEmployee)) //the driver gets the data from the ja
                .and().click(employeeStatus) // the driver clicks on the status of the employee
                .and().click(selectEmployeeStatus)  //the driver selects the enabled status for the employee
                .and().type(employeeUsername,employeeUserNameData) // the driver types the username of the employee
                .and().type(employeePassword,employeePasswordData) // the driver types the password of the employee
                .and().type(confirmEmployeePassword,confirmEmployeePasswordData) // the driver confirms the password of the employee
                .and().click(saveButton);
    }

    private String getEmployeeName(By locator){
       return driver.element().getText(locator);
    }
}


