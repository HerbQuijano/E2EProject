package org.hquijano;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

//extends Base to access InitializeDriver Method
public class LandingPageTest extends Base {

    //Example TestNG Test
    @Test
    public void testHomePageNavigation() throws IOException {
        System.out.println("Home page test");

        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get("http://www.qaclickacademy.com");

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        landingPage.GetLoginLink().click();
        loginPage.GetEmailField().sendKeys("username");
        loginPage.GetPasswordField().sendKeys("test123");
        loginPage.GetLoginButton().click();

        driver.quit();


    }

}
