package org.hquijano;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;

import java.io.IOException;

//Add logs
//Generate report
//Add screenshot
//Jenkins

public class ValidateNavigationBarTest extends Base {
    private static final Logger log = LogManager.getLogger(ValidateNavigationBarTest.class.getName());
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        //Initialize driver, driver comes from Base class
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));

    }

    @Test(groups = {"Smoke"})
    public void homePageNavigationBarDisplay() {

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
        log.info("Navigation bar is displayed");

    }

    @AfterTest
    public void tearDown() {
        log.info("Test completed");
        driver.quit();
    }


}
