package org.hquijano;

import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


import java.io.IOException;


//extends Base to access InitializeDriver Method
public class LandingPageTest extends Base {

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        driver = InitializeDriver();
    }

    @Test(dataProvider = "getData")
    public void testHomePageNavigationLogin(String username, String password) throws IOException {

        driver.get(prop.getProperty("url"));
       // Actions builder = new Actions(driver);
        LandingPage landingPage = new LandingPage(driver);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOf(landingPage.getAnnoyingPopup()));
       // Action pressEsc = builder.sendKeys(landingPage.getAnnoyingPopup(), Keys.ESCAPE).build();
       // pressEsc.perform();
        LoginPage loginPage = new LoginPage(driver);
        landingPage.GetLoginLink().click();
        loginPage.GetEmailField().sendKeys(username);
        loginPage.GetPasswordField().sendKeys(password);
        loginPage.GetLoginButton().click();

    }

    @AfterMethod
    public void tearDown() {
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
