package org.hquijano;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitleTextTest extends Base {

    @Test
    public void testHomePageNavigation() throws IOException {
        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get("http://www.qaclickacademy.com");

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getCenterText().getText(), "FEATURED COURSES");

        driver.quit();
    }

}
