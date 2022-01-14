package org.hquijano;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//extends Base to access InitializeDriver Method
public class LandingPageTest extends Base {

    //Example TestNG Test
    @Test(dataProvider = "getData")
    public void testHomePageNavigation(String username, String password) throws IOException {
        System.out.println("Home page test");

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
        LoginPage loginPage = new LoginPage(driver);
        landingPage.GetLoginLink().click();
        loginPage.GetEmailField().sendKeys(username);
        loginPage.GetPasswordField().sendKeys(password);
        loginPage.GetLoginButton().click();

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
