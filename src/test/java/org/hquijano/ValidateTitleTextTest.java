package org.hquijano;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;

import java.io.IOException;


public class ValidateTitleTextTest extends Base {

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void homePageCenterTextValidation() throws IOException {


        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getCenterText().getText(), "FEATURED COURSES");


    }

    @Test(groups = {"Smoke"})
    public void homePageCenterTextDisplay() throws IOException {
        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getCenterText().isDisplayed());


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
