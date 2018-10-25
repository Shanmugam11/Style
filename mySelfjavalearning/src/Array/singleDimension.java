package Array;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.*;

public class singleDimension {
	
	//WebDriver Initialization
	public WebDriver driver;
	//Initializing the Case number
	String[] caseNumber = {"LIN1709750785", "LIN1816351114", "LIN1811950200"};
	int s = caseNumber.length;
  @Test (priority=0,description="H1 B Case Status")
  public void f() {
		try {
			for (int i=0;i<s;i++){
			
			driver.findElement(By.xpath("//input[@id='receipt_number']")).sendKeys(caseNumber[i]);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			String text = driver.findElement(By.xpath("//h1")).getText();
			System.out.println(text);
		
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
  @BeforeClass
  public void beforeClass() {
  
  }
  @BeforeTest
  public void beforeTest() {
	  
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://egov.uscis.gov/casestatus/landing.do");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
  }

  @AfterTest
  public void afterTest() {
  }

}

for (inti=0;i<3;i++)
{
	for(intj=0){
		excel_data
	}
}