package org.hquijano;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

//extends Base to access InitializeDriver Method
public class HomePageTest extends Base {

    //Example TestNG Test
    @Test
    public void testHomePageNavigation() throws IOException {

        System.out.println("Home page test");
        //Initialize driver, driver comes from Base class
        driver = InitializeDriver();
        driver.get("http://www.qaclickacademy.com");
        driver.quit();

    }

}
