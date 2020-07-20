package DashBoard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Util.Helper;
import VIPqabase.TestBase;

public class DailyReport extends TestBase{
	
	 Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	
	public DailyReport(WebDriver driver) {}
	
	
	public void ReportDaily() {
		
		System.out.println("Create a Daily Report..");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
			driver.findElement(By.xpath("//*[@id=\"mm-2\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
			
			
			
			DateFormat customFormat = new SimpleDateFormat("dd");
			Date currentdate = new Date();
			String D = customFormat.format(currentdate);
			System.out.println(D);
			
			//Date
			driver.findElement(By.id("advSearch_Date_txn_date")).click();Helper.staticWait(2000);
			WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> noOfColumns = datePicker
					.findElements(By.tagName("td"));
			for (WebElement cell : noOfColumns) {
				if(cell.getText().equals(D)) {
					cell.findElement(By.linkText(D)).click();
					break;
				}
			}
			
		}
	
	
	
	public void DailyReportShopGroupFilter() {
		
		System.out.println("Create a Daily Report and Based on Shop Group filter..");
		
		//Shop Group Filter
		WebElement ElementDailyReportShopGroup = driver.findElement(By.id("advSearch_Select_shop_group"));
		ElementDailyReportShopGroup.click();Helper.staticWait(3000);
     	Select select = new Select(ElementDailyReportShopGroup); 
     	
		 List<WebElement> DropDownShopGroupDailyReport = select.getOptions();
		 for(int i=0;i<DropDownShopGroupDailyReport.size();i++){
			 String drop_down_ShopGroupDailyReport=DropDownShopGroupDailyReport.get(i).getText();
			 System.out.println("dropdown values are " + drop_down_ShopGroupDailyReport);  }
		         select.selectByVisibleText("Spectra QA");Helper.staticWait(3000);
		//driver.findElement(By.xpath("//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click();Helper.staticWait(3000);
	}
	
	public void DailyReportShopFilter() {
	
		//Shop Filter 
		         
		         WebElement ElementDailyReportShopName = driver.findElement(By.id("advSearch_Select_shop_name"));
		         ElementDailyReportShopName.click();Helper.staticWait(3000);
		      	Select sselect = new Select(ElementDailyReportShopName); 
		      	
		 		 List<WebElement> DropDownShopNameDailyReport = sselect.getOptions();
		 		 for(int i=0;i<DropDownShopNameDailyReport.size();i++){
		 			 String drop_down_ShopNameDailyReport=DropDownShopNameDailyReport.get(i).getText();
		 			 System.out.println("dropdown values are " + drop_down_ShopNameDailyReport);  }
		 		         sselect.selectByVisibleText("Welcome");Helper.staticWait(3000);}
		 		
	
	public void DailyReportPaymentFilter() {
		//Payment Filter
		 		         
		 		         driver.findElement(By.id("advSearch_Select_payment_method")).click();Helper.staticWait(3000);
		 //cash		         
		 		         driver.findElement(By.xpath("//*[@id=\"advSearch_Select_payment_method\"]/option[2]")).click();}
		 		         
		
	public static  void DailyReportCardTierFilter() { 		         
		 		         
		 //Card Tier 
		 		         
		 		        WebElement ElementDailyReportCardTier = driver.findElement(By.id("advSearch_Select_card_tier"));
		 		       ElementDailyReportCardTier.click();Helper.staticWait(3000);
				      	Select cselect = new Select(ElementDailyReportCardTier); 
				      	
				 		 List<WebElement> DropDownCardTierDailyReport = cselect.getOptions();
				 		 for(int i=0;i<DropDownCardTierDailyReport.size();i++){
				 			 String drop_down_CardTierDailyReport=DropDownCardTierDailyReport.get(i).getText();
				 			 System.out.println("dropdown values are " + drop_down_CardTierDailyReport);  }
				 		         cselect.selectByVisibleText("RUBY");Helper.staticWait(3000);
				 		         
	}
	
	
	public void DailyReportSubmitFilter() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click();Helper.staticWait(3000);
		
	}

	
	
	
	public void DailyReportpDownloadPDF() {
		String name = "Shop Group List Record.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		//shop group management 
		//driver.findElement(By.xpath("//*[@id=\"mm-2\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
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
		    
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, name), "Failed to download Expected document");
		
		
	}
	
	
	public void DailyReportDownloadExcel() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		//shop group management 
		//driver.findElement(By.xpath("//*[@id=\"mm-2\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(2000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, "Shop Group List Record.xlsx"), "Failed to download Expected document");
		
		
	}
	
	
	
	


	
	
	
	
	
	
	
	
		

}
