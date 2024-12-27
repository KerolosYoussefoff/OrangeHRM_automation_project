package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_adminPage {
    SHAFT.GUI.WebDriver driver;

    // constructor
    public P03_adminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By numOfRecords = By.xpath("//*[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]//span[contains(. , \"Records\")]");
    By addButton = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\" and contains(., \"Add\")]");
    // function to get the number of records
    public String getNumberOfRecords(){
        return driver.element().getText(numOfRecords).replaceAll("[^0-9]]+","");
    }
    public P04_addRequestPage clickOnAdd(){
        driver.element().click(addButton);
        return new P04_addRequestPage (driver);
    }
}


