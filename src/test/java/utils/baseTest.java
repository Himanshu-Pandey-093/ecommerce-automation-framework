package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (ChromeDriver in this example)
    	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        //driver.manage().window().maximize(); // Maximize browser window
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}