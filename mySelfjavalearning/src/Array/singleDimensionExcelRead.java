package Array;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;

public class singleDimensionExcelRead {

	// WebDriver Initialization
	public WebDriver driver;
	//Declaring file objects with caseNumber.xls
	File objfile = new File("E:\\Selenium Training\\mySelfjavalearning\\caseNumbers.xls");

	//@BeforeMethod (description = "File initialization")
	
	
	@Test (priority = 0, description = "H1B case tracker")
	
	public void f() throws InterruptedException {
		
		int totalReceiveStatus = 0;
		int totalApprovedStatus = 0;
		int totalOtherStatus = 0;
		

		try {

			// Declaring Workbook and WorkSheet Objects
			Workbook objWorkbook = Workbook.getWorkbook(objfile);
			Sheet objSheet = objWorkbook.getSheet("Sheet1");
			int totalRows = objSheet.getRows();
			int totalCols = objSheet.getColumns();

			// Initializing 2 dimensional arrays
			String[][] row_col = new String[totalRows][totalCols];
/* 00  01  
   10  11
   20  21
   30  31*/
			// Displaying Total Rows = 3 //TotalCols = 1
			System.out.println("The Total rows are " + totalRows);
			System.out.println("The Total cols are " + totalCols);

			// Fetching content from the rows and columns
			for (int row = 1; row < totalRows; row++) {
				
				for (int col = 0; col < totalCols; col++) {

					// Cell objCell = objSheet.getCell(row, col); - This throws
					// Exception

					Cell objCell = objSheet.getCell(col, row);
					row_col[row][col] = objCell.getContents();

					System.out.println("The Case numbers found in this array position " + row + "," + col + " is "
					+ row_col[row][col]);
					
					driver.findElement(By.xpath("//input[@id='receipt_number']")).sendKeys(row_col[row][col]);
					driver.findElement(By.xpath("//input[@type='submit']")).click();
					// Thread.sleep(3000);
					int slNo = 0;
					slNo = row + 1;
					String caseStatus = driver.findElement(By.xpath("//h1")).getText();
					System.out.println(slNo + " The Case status of " + row_col[row][col] + " is " + caseStatus);
					// Thread.sleep(3000);


					if (caseStatus.contains("Received")) {
						totalReceiveStatus = totalReceiveStatus + 1;

					} else if (caseStatus.contains("Approved")) {
						totalApprovedStatus = totalApprovedStatus + 1;

					}

					else {
						totalOtherStatus = totalOtherStatus + 1;
					}

				}
			}

			System.out.println("Total no of cases in received status : " + totalReceiveStatus);
			System.out.println("Total no of cases in Approved status : " + totalApprovedStatus);
			System.out.println("Total no of cases are neither Approved nor Received status and the count is : "
					+ totalOtherStatus);

		}

		catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		// Initializing Web Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://egov.uscis.gov/casestatus/landing.do");
		// Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
