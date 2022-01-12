package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By loginLink = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement GetLoginLink() {
        return driver.findElement(loginLink);
    }


}
