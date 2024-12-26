package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_homePage {
    SHAFT.GUI.WebDriver driver;

    // constructor
    public P02_homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By adminTab = By.xpath("//*[@href=\"/web/index.php/admin/viewAdminModule\"]");    // there is another locator //*[@href="/web/index.php/admin/viewAdminModule"]//span[contains(. , "admin")]

    public void selectAdminFromPanel(){
        driver.element().click(adminTab);
    }

}

