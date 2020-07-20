package DashBoard;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import Util.Helper;
import VIPqabase.TestBase;

public class MonthlyReport extends TestBase {
	
	Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	
	public MonthlyReport(WebDriver driver) {}
	
	
	public void ReportMonthly() {
		
		
	System.out.println("Create a Monthly Report..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Monthly Report')]")).click();Helper.staticWait(2000);
		
		
		//Date
		WebElement tdate = driver.findElement(By.id("advSearch_Date_txn_month"));
		tdate.click();tdate.sendKeys(Keys.ENTER);Helper.staticWait(2000);
		
		
		
		
		  //Shop Group
		 // driver.findElement(By.id("advSearch_Select_shop_group")).click();
		  
		  //Shop Name 
		  //driver.findElement(By.id("advSearch_Select_shop_name")).click();
		  
		  //Payment Method
		  //driver.findElement(By.id("advSearch_Select_payment_method")).click();
		  
		  //Card Tier 
		  //driver.findElement(By.id("advSearch_Select_card_tier")).click();
		 
		
		driver.findElement(By.xpath("//*[contains(text(),'Submit')]")).click();Helper.staticWait(5000);
		
		
		
	}
	
	
	
	public void ReportDownloadPDF() {
		String name = "Monthly_Billing_Report_202007_Abhishek.g.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();
		
		  Set<String> handles = driver.getWindowHandles();
		    String currentHandle = driver.getWindowHandle();
		    for (String handle : handles) {

		     if (!handle .equals(currentHandle))
		     {
		         driver.switchTo().window(handle);
		     }
		   }
		    Helper.staticWait(5000);
		    
		   
		   
		    ((JavascriptExecutor) driver).executeScript("print()");Helper.staticWait(3000);
		    driver.switchTo().window(currentHandle);Helper.staticWait(3000);
		   
		 	
	}
	
	
	public void ReportDownloadExcel() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(5000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, "Monthly_Billing_Report_202007_Abhishek.g.xlsx"), "Failed to download Expected document");
		
		
	}
	
	
	
	

}
