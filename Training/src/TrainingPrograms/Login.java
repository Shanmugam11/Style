package TrainingPrograms;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	//Declaring Global static variables
	public static String s_Email;
	public static String s_Password;
	public static String s_Username;
	public static void main(String[] args) throws IOException, Exception {
	try {
		//Loading file
		Properties objprop = new Properties();
		objprop.load(new FileInputStream("dataProp.properties"));
		
		//Initializing Global variable 
		s_Email=objprop.getProperty("Email");
		s_Password=objprop.getProperty("Password");
		s_Username = objprop.getProperty("Username");
		System.out.println("The Email is " + s_Email);
		System.out.println("The Username is " +s_Username );
		System.out.println("The password is " +s_Password);
		//Initializing Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@href='https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/']")).click();
			driver.findElement(By.xpath("//*[@id = 'identifierId']")).sendKeys(s_Email);
			driver.findElement(By.xpath("//*[@id = 'identifierNext']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(s_Password);
			driver.findElement(By.xpath("//*[@id = 'passwordNext']")).click();
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
		

	}

}
