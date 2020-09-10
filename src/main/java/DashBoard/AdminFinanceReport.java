package DashBoard;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class AdminFinanceReport extends TestBase{
	
	
	Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	 PropertyFileReader pfr = new PropertyFileReader();
	 
	public AdminFinanceReport(WebDriver driver) {}
	
	public void  AdminFinanceReportMonthly() {
		
		
          System.out.println("Create a Admin Finance Report Monthly..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Report')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Admin & Finance Report - Monthly')]")).click();Helper.staticWait(3000);
		
		
		//Date
		WebElement tdate = driver.findElement(By.id("advSearch_Date_txn_month"));
		tdate.click();Helper.staticWait(3000);
		
		 Select mnth =  new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 mnth.selectByVisibleText("May");
          
          tdate.sendKeys(Keys.ENTER);Helper.staticWait(3000);
      	driver.findElement(By.xpath("//button[@class='btn btn-primary float-right reportsubmit']")).click();Helper.staticWait(5000);
		
	}
	
	
	public void AdminFinanceReportMonthlyDownloadPDF() {
		try {
		
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
	
	
	public void AdminFinanceReportMonthlyDownloadExcel() {
		try {
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String name = "Monthly_Admin_Finance_Report_202005_Abhishek.g.xls";
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
	
	
	public void AdminFinanceReportMonthlySearch() {
		try {
		
		System.out.println("Search Monthly Report by wrong value ");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement monthlyreportsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  monthlyreportsearch.sendKeys(pfr.getMonthlyReportSearch());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement elereportsearch = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		Assert.assertEquals("No matching records found", mesreportsearch);Helper.staticWait(5000);
		monthlyreportsearch.clear();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void AdminFinanceReportMonthlyExportRawData() {
		try {
		System.out.println("Click Monthly Report Raw Data  ");
		
		String name = "ADMIN AND FINANCE REPORT RECORD.xlsx";
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
	

	
	
	
	//##############################################################Admin Finance Daily Report###############################################################################################################
	
	
	
	
public void AdminFinanceDailyReport() {
		
		System.out.println("Create a Admin Finance Daily Report ..");
			
			driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Report')]")).click();Helper.staticWait(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Admin & Finance Report - Daily')]")).click();Helper.staticWait(3000);
			
			 DateFormat customFormat = new SimpleDateFormat("dd"); 
			 Date currentdate = new Date(); 
			 String D = customFormat.format(currentdate); System.out.println("Admin Finance Daily Report Date = " + D);
			 
		    driver.findElement(By.id("advSearch_Date_txn_date")).click();Helper.staticWait(3000);
		
			
			
		    driver.findElement(By.id("ui-datepicker-div")).click();Helper.staticWait(3000);
			  
			 
			  WebElement datePicker =driver.findElement(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]")); 
			 
			  List<WebElement> noOfColumns = datePicker.findElements(By.tagName("td")); 
			
			  for (WebElement cell :noOfColumns) { 
				  if(cell.getText().equals(D)) {
					  
			            cell.findElement(By.linkText(D)).click();
			            System.out.println(cell);
			            break;
			            } 
				  }
			  
			  
			  driver.findElement(By.xpath("//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click() ;Helper.staticWait(5000);
				  }
			 
			
					  
	
	public void AdminFinanceDailyReportDownloadPDF() {

		try {
		
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(2000);
		
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
		    
		    
		    //File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
		    //String fileName = getLatestFile.getName();
		    //System.out.println(fileName);
		    //Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
		
	}
	
	
	public void AdminFinanceDailyReportExcel() {
		
		try {
		
		DateFormat customFormat = new SimpleDateFormat("yyyyMMdd"); 
		 Date currentdate = new Date(); 
		 String D = customFormat.format(currentdate); System.out.println("Today Date is = " +D);
		
	
		String firstname = "Daily_Billing_Report_"+D+"_Abhishek.g";
		
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(5000);
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	   // Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
		
	}
	
	
	
public void AdminFinanceDailyReportSearch() {
		
		System.out.println("Search Admin Financ Daily Report by Merchant ID ");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement monthlyreportsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  monthlyreportsearch.sendKeys(pfr.getMerchantID());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement elereportsearch = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[7]"));
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		Assert.assertEquals("1000000004", mesreportsearch);Helper.staticWait(5000);
	}
	
	
	public void AdminFinanceDailyReportExportRawData() {
		try {
		System.out.println("Click Daily Admin Finance Report Raw Data  ");
		
		String name = "DAILY ADMIN AND FINANCE REPORT RECORD.xlsx";
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
	
	
	
	


	
//############################################################################ Monthly Statement Report	######################################################################################################
	
	
	
	
	
	public void  MonthlyStatementReport() {
		
		
        System.out.println("Create a Monthly Statement Report..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Report')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Monthly Statement Report')]")).click();Helper.staticWait(3000);
		
		
		//Date
		WebElement tdate = driver.findElement(By.id("advSearch_Date_txn_month"));
		tdate.click();Helper.staticWait(3000);
		
		 Select mnth =  new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 mnth.selectByVisibleText("Jul");
        
        tdate.sendKeys(Keys.ENTER);Helper.staticWait(3000);
    	driver.findElement(By.xpath("//button[@class='btn btn-primary float-right reportsubmit']")).click();Helper.staticWait(5000);
		
	}
	
	
	public void MonthlyStatementReportDownloadPDF() {
		try {
		
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
	
	
	public void MonthlyStatementReportDownloadExcel() {
		try {
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String name = "Monthly_Statement_Report_202007_Abhishek.g.xls";
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
	
	
	public void MonthlyStatementReportSearch() {
		try {
		
		System.out.println("Search Monthly Report by Merchant ID ");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement monthlyreportsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  monthlyreportsearch.sendKeys(pfr.getMerchantID());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement elereportsearch = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[5]"));
		
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		
		Assert.assertEquals("1000000004", mesreportsearch);Helper.staticWait(5000);
		monthlyreportsearch.clear();Helper.staticWait(5000);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void MonthlyStatementReportRawData() {
		try {
		System.out.println("Click Monthly Report Raw Data  ");
		
		String name = "MONTHLY STATEMENT REPORT RECORD.xlsx";
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
