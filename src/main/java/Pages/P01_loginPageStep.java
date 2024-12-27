package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_loginPageStep {
    SHAFT.GUI.WebDriver driver;

//    constructor for login page
    public P01_loginPageStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // locators
   private final By userNameInput = By.xpath("//*[@name=\"username\"]");
   private final By passwordInput = By.xpath("//*[@type=\"password\"]");
   private final By submitBtn = By.xpath("//*[@type=\"submit\"]");
    //   function for login page to log in
   public P02_homePage loginSteps (String userName , String password){
       driver.element().type(userNameInput,"Admin")
               .and().type(passwordInput,"admin123")
               .and().element().click(submitBtn);
       return  new P02_homePage(driver);
   }

}
