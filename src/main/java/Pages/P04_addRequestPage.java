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
    By userRoleDropDown = By.xpath("//*[@class=\"oxd-select-text oxd-select-text--active\" and contains(.,\"Select\")] ");


    // function to get the number of records

}


