package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class WebDrivers extends Google {

//System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
protected WebDriver driver;
protected String baseUrl="https://www.google.com";


@BeforeClass
public void driverinitiate() {
	
	
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		System.out.println("Chrome driver opened");
		System.out.println("baseURL" + baseUrl);
		driver.get(baseUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	



@AfterClass
public void driverclose(){
	
	driver.close();
	
	
}





	}


