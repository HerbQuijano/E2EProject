package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    By emailField = By.xpath("//input[@type='email']");
    By passwordField = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//input[@type='submit']");
    //By loginButton = By.xpath("//input[@name='commit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
}
