package DashBoard;

import java.io.File;
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
import Util.PropertyFileReader;
import VIPqabase.TestBase;

public class MonthlyReport extends TestBase {
	
	Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	 PropertyFileReader pfr = new PropertyFileReader();
	public MonthlyReport(WebDriver driver) {}
	
	
	public void ReportMonthly() {
		
		
	System.out.println("Create a Monthly Report..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Report')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Monthly Report')]")).click();Helper.staticWait(3000);
		
		
		//Date
		WebElement tdate = driver.findElement(By.id("advSearch_Date_txn_month"));
		tdate.click();Helper.staticWait(3000);
		
		 Select mnth =  new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 mnth.selectByVisibleText("Aug");
          
          tdate.sendKeys(Keys.ENTER);Helper.staticWait(3000);
		
		
		
		  //Shop Group
       
		 WebElement eleshopgroup = driver.findElement(By.cssSelector("#advSearch_Select_shop_group"));
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
		         
		         
		        // Select card =  new Select (driver.findElement(By.id("advSearch_Select_card_tier")));
		       //  card.selectByVisibleText("GOLD");
		       //   Helper.staticWait(3000);
			 
		         
		         
		         
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary float-right reportsubmit']")).click();Helper.staticWait(5000);
		
		
		
	}
	
	
	
	public void ReportDownloadPDF() {
		try {
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
		   // File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
		   // String fileName = getLatestFile.getName();
		   // System.out.println(fileName);
		   // Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void ReportDownloadExcel() {
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String name = "Monthly_Billing_Report_202008_Abhishek.g.xls";
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(5000);
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	   String fileName = getLatestFile.getName();
	   System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
		
	}
	
	
	public void MonthlyReportSearch() {
		try {
		
		System.out.println("Search Monthly Report by wrong value ");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement monthlyreportsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  monthlyreportsearch.sendKeys(pfr.getMonthlyReportSearch());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement elereportsearch = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		Assert.assertEquals("No matching records found", mesreportsearch);Helper.staticWait(5000);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void MonthlyReportExportRawData() {
		try {
		System.out.println("Click Monthly Report Raw Data  ");
		
		String name = "MONTHLY REPORT RECORD.xlsx";
		driver.findElement(By.xpath("//button[@class='dt-button buttons-excel buttons-html5']")).click();Helper.staticWait(5000);
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	   String fileName = getLatestFile.getName();
	   System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	
	

}
