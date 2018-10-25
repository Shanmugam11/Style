package TrainingPrograms;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excelread {
	public static String user_name;
	public static String pwd;
	public static String email;

	public static void main(String[] args) {
		
		try {
			try {
				File objfile = new File("E:\\Selenium Training\\Training\\Google login.xls");
				Workbook objworkbook = Workbook.getWorkbook(objfile);
				Sheet objsheet = objworkbook.getSheet("Sheet1");
				int rows = objsheet.getRows();
				int cols = objsheet.getColumns();
				System.out.println(" The no of rows " + rows);
				System.out.println(" The no of cols " + cols);
				String[][] exceldata = new String [rows][cols];
							
				
				for (int row=0;row < rows;row++)
				{
					for (int col=0;col < cols;col++)
					{
					Cell objcell = objsheet.getCell(col, row);
					exceldata[row][col] = objcell.getContents();
					System.out.println("The Value at " + row + "," + col + " is " + exceldata[row][col]);
																		
					}
						
				}
				
				user_name = exceldata[2][2];
				pwd = exceldata[2][1];
				email = exceldata[2][0];
				
				System.out.println(user_name);
				System.out.println(pwd);
				System.out.println(email);
				
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.google.com/");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[@href='https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.com/']")).click();
					driver.findElement(By.xpath("//*[@id = 'identifierId']")).sendKeys(email);
					//*[@id="gb_70"]
					driver.findElement(By.xpath("//*[@id = 'identifierNext']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
					driver.findElement(By.xpath("//*[@id = 'passwordNext']")).click();
					driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://www.google.com/']")).click();
					String User_id = driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[2]/div[4]/div[2]/div[1]/div/div[1]")).getText();
					
					if(User_id.equalsIgnoreCase(user_name))
					{
						System.out.println("Login authenticated");
					}
					else
					{
						System.out.println("User name not correct");
					}
					
							
								
				
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	private static void If(boolean equalsIgnoreCase) {
		// TODO Auto-generated method stub
		
	}

}
