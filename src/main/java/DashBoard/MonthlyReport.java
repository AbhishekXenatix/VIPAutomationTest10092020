package DashBoard;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[7]/a")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Monthly Report')]")).click();Helper.staticWait(3000);
		
		
		//Date
		WebElement tdate = driver.findElement(By.id("advSearch_Date_txn_month"));
		tdate.click();tdate.sendKeys(Keys.ENTER);Helper.staticWait(3000);
		
		
		  //Shop Group
		 WebElement eleshopgroup = driver.findElement(By.id("advSearch_Select_shop_group"));
		 eleshopgroup.click();Helper.staticWait(3000);Select select = new Select(eleshopgroup); 
		 List<WebElement> dropdowneleshopgroup = select.getOptions();
		 
		 for(int i=0;i<dropdowneleshopgroup.size();i++){
			 String drop_down_eleshopgroup=dropdowneleshopgroup.get(i).getText();
			 System.out.println("dropdown values are " + drop_down_eleshopgroup);  }
		         select.selectByVisibleText("Spectra QA");Helper.staticWait(3000);
		 
		  
		  //Shop Name 
		  //driver.findElement(By.id("advSearch_Select_shop_name")).click();
		  
		  //Payment Method
		  //driver.findElement(By.id("advSearch_Select_payment_method")).click();
		  
			
			  //Card Tier
				/*
				 * WebElement elecardtier =
				 * driver.findElement(By.id("advSearch_Select_card_tier"));
				 * elecardtier.click();Helper.staticWait(3000);Select selectct = new
				 * Select(eleshopgroup); List<WebElement> dropdownelecardtier =
				 * selectct.getOptions();
				 * 
				 * for(int i=0;i<dropdownelecardtier.size();i++){ String
				 * drop_down_elecardtier=dropdownelecardtier.get(i).getText();
				 * System.out.println("dropdown values are " + drop_down_elecardtier); }
				 * selectct.selectByVisibleText("GOLD");Helper.staticWait(3000);
				 */
		         
		         
		         Select card =  new Select (driver.findElement(By.id("advSearch_Select_card_tier")));
		         card.selectByVisibleText("GOLD");
		         card.selectByIndex(8);
			 
		         
		         
		         
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/button")).click();Helper.staticWait(5000);
		
		
		
	}
	
	
	
	public void ReportDownloadPDF() {
		//String fileName = "Monthly_Billing_Report_202007_Abhishek.g.pdf";
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
