package org.hquijano;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Base {

    //Setting up WebDrier
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        //Setting up properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/resources/data.properties");
        prop.load(fis);

        //Setting up browser
        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        //Setting up browser preferences
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //returning driver
        return driver;

    }

    public void closeDriver() {
        driver.quit();
    }

    public void closeBrowser() {
        driver.close();
    }

    public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
        TakesScreenshot takeShot = (TakesScreenshot) driver;
        File source = takeShot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDate localDate = LocalDate.now();
        //String destinationFile = System.getProperty("user.dir") + "/reports/screenshots/" + testMethodName + localDate + ".png";
        String destinationFile = "./reports/screenshots/" + testMethodName + localDate + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }


}


