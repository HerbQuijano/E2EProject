package org.hquijano;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateNavigationBarTest extends Base {


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

    }

    @Test(groups = {"Smoke"})
    public void homePageNavigationBarDisplay() {

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
