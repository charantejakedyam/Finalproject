package test_cases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseTest {

	public static WebDriver driver;
	
    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) throws Exception {
    	switch(browser.toLowerCase()) {
        case "chrome": driver = new ChromeDriver(); 
                	   break;
        case "edge": driver = new EdgeDriver(); 
                	 break;
        case "firefox": driver=new FirefoxDriver();
        			 break;
        case "safari": driver=new SafariDriver();
        			 break;
        default: System.err.println("Invalid Browser");
                 return;
        }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().deleteAllCookies();
         driver.get(new ConfigReader().getUrl());
         System.out.println("--------"+browser+"--------");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("-------------------------");
    }
    
}