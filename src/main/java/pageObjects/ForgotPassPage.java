package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassPage {

    WebDriver driver;

    private By emailField = By.xpath("//input[@type='email']");
    private By sendInstruction = By.xpath("//input[@type='submit']");

   public ForgotPassPage(WebDriver driver) {
       this.driver = driver;
   }

    public WebElement getForgotEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement sendInstructionForgot() {
        return driver.findElement(sendInstruction);
    }
}
