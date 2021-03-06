package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By forgotPassButton = By.cssSelector(".link-below-button");
    //By loginButton = By.xpath("//input[@name='commit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPassPage ForgotPassPage()
    {
        driver.findElement(forgotPassButton).click();
        return new ForgotPassPage(driver);
    }

       public WebElement getEmailField()
    {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField()
    {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton()
    {
        return driver.findElement(loginButton);
    }

    public WebElement getForgotPassButton()
    {
        return driver.findElement(forgotPassButton);
    }
}
