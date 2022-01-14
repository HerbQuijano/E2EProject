package org.hquijano;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValidateTitleTextTest extends Base {

    @Test
    public void testHomePageNavigation() throws IOException {
        //Setting up properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/resources/data.properties");
        prop.load(fis);

        //Setting up url from data.properties file
        String url = prop.getProperty("url");

        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get(url);

        //creates an object of LandingPage class
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getCenterText().getText(), "FEATURED COURSES");

        driver.quit();
    }

}
