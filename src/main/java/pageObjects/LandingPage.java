package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {

    public WebDriver driver;
    By loginLink = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
    By centerText = By.cssSelector("div[class='text-center'] h2");
    By topCenterMenu = By.xpath("//ul[@class='nav navbar-nav navbar-right']/child::li"); //cssSelector = .nav.navbar-nav.navbar-right>li>a
    By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
    By annoyingPopup = By.xpath("//div[@class='listbuilder-popup-content']");

    public LandingPage(WebDriver driver) {
       this.driver = driver;
    }

    public LoginPage getLoginPage()
    {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
    public WebElement getLoginLink() {
        return driver.findElement(loginLink);
    }

    public WebElement getCenterText() {
        return driver.findElement(centerText);
    }

    public List<WebElement> getTopCenterMenu() {
        return driver.findElements(topCenterMenu);
    }

    public WebElement getNavigationBar() {
        return driver.findElement(navigationBar);
    }

    public WebElement getAnnoyingPopup() {
        return driver.findElement(annoyingPopup);
    }

}
