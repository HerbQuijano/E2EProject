package org.hquijano;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;

import java.io.IOException;


public class ValidateTitleTextTest extends Base {
    private static final Logger log = LogManager.getLogger(ValidateTitleTextTest.class.getName());
    public WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() throws IOException {

        //Initialize driver, driver comes from Base class
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validateHomePageCenterText() {

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getCenterText().getText(), "FEATUREDd COURSES");
        log.info("successfully validated the text" + landingPage.getCenterText().getText());


    }

    @Test(groups = {"Smoke"})
    public void validateHomePageCenterTextDisplay() {
        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getCenterText().isDisplayed());
        log.info("successfully validated the text displayed");


    }

    @AfterTest
    public void tearDown() {
        log.info("Test completed");
        driver.quit();
    }

}
