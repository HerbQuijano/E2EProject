package org.hquijano;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.time.Duration;


//extends Base to access InitializeDriver Method
public class LandingPageTest extends Base {
    private static final Logger log = LogManager.getLogger(LandingPageTest.class.getName());
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test(dataProvider = "getData")
    public void testHomePageNavigationLogin(String username, String password) {

        driver.get(prop.getProperty("url"));
        Actions builder = new Actions(driver);
        LandingPage landingPage = new LandingPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(landingPage.getAnnoyingPopup()));
        Action pressEsc = builder.sendKeys(landingPage.getAnnoyingPopup(), Keys.ESCAPE).build();
        pressEsc.perform();
        landingPage.getLoginLink().click();
        log.info("Clicked on Login Link");
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(prop.getProperty("loginPageUrl"));


        if (driver.getCurrentUrl().equals(prop.getProperty("loginPageUrl"))) {
            log.info("Navigated to Login Page");
            LoginPage loginPage = new LoginPage(driver);
            log.info("Entering username");
            loginPage.getEmailField().sendKeys(username);
            log.info("Entering password");
            loginPage.getPasswordField().sendKeys(password);
            loginPage.getLoginButton().click();
            log.info("Clicked on Login Button");
        } else {
            log.error("Login page is not displayed");
            Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("loginPageUrl"));

        }
    }

    @AfterMethod
    public void tearDown() {
        log.info("Test completed");
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {
        //returns 2 dimensional array6
        Object[][] data = new Object[2][2]; //2 rows and 2 columns
        //row stands for test case
        //column stands for values for each test case
        //row 0, column 0
        data[0][0] = "nonrestricted@qw.com"; //first row, first column
        data[0][1] = "123456";
        //data[0][2] = "Restricted User";

        data[1][0] = "restricted@qw.com"; //first row, first column
        data[1][1] = "456789";
//        data[1][2] = "Non Restricted User";

        return data;
    }

}
