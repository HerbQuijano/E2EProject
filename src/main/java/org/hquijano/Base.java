package org.hquijano;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    //Setting up WebDrier
    public WebDriver driver;
    public Properties prop;

    public WebDriver InitializeDriver() throws IOException {
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




}


