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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Util.Helper;
import Util.PropertyFileReader;
import VIPqabase.TestBase;

public class DailyReport extends TestBase{
	
	 Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	 PropertyFileReader pfr = new PropertyFileReader();
	public DailyReport(WebDriver driver) {}
	
	
	public void ReportDaily() {
		
		System.out.println("Create a Daily Report..");
			
		        Helper.staticWait(3000);
			//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(3000);
			driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Report')]")).click();Helper.staticWait(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Daily Report')]")).click();Helper.staticWait(3000);
			
			 DateFormat customFormat = new SimpleDateFormat("d"); 
			 Date currentdate = new Date(); 
			 String D = customFormat.format(currentdate); System.out.println(D);
			 
		    driver.findElement(By.id("advSearch_Date_txn_date")).click();Helper.staticWait(3000);
		
			
			
		    driver.findElement(By.id("ui-datepicker-div")).click();Helper.staticWait(3000);
			  
			 
			  WebElement datePicker =driver.findElement(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]")); 
			  List<WebElement> noOfColumns = datePicker .findElements(By.tagName("td")); 
			  for (WebElement cell :noOfColumns) { 
				  if(cell.getText().equals(D)) {
			            cell.findElement(By.linkText(D)).click();
			            break;
			            } 
				  }
				  }
			 
			
		
	
	
	
	
	
	
	
	public void DailyReportShopGroupFilter() {
		
		System.out.println("Create a Daily Report  Based on Shop Group filter..");
		/*
		 * //Shop Group Filter WebElement ElementDailyReportShopGroup =
		 * driver.findElement(By.id("advSearch_Select_shop_group"));
		 * ElementDailyReportShopGroup.click();Helper.staticWait(3000); Select select =
		 * new Select(ElementDailyReportShopGroup);
		 * 
		 * List<WebElement> DropDownShopGroupDailyReport = select.getOptions(); for(int
		 * i=0;i<DropDownShopGroupDailyReport.size();i++){ String
		 * drop_down_ShopGroupDailyReport=DropDownShopGroupDailyReport.get(i).getText();
		 * System.out.println("dropdown values are " + drop_down_ShopGroupDailyReport);
		 * } select.selectByVisibleText("Spectra QA");Helper.staticWait(3000);
		 */
		//driver.findElement(By.xpath("//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click();Helper.staticWait(3000);
	}
	
	//public void DailyReportShopFilter() {
	
		//Shop Filter 
		         
		/*
		 * WebElement ElementDailyReportShopName =
		 * driver.findElement(By.id("advSearch_Select_shop_name"));
		 * ElementDailyReportShopName.click();Helper.staticWait(3000); Select sselect =
		 * new Select(ElementDailyReportShopName);
		 * 
		 * List<WebElement> DropDownShopNameDailyReport = sselect.getOptions(); for(int
		 * i=0;i<DropDownShopNameDailyReport.size();i++){ String
		 * drop_down_ShopNameDailyReport=DropDownShopNameDailyReport.get(i).getText();
		 * System.out.println("dropdown values are " + drop_down_ShopNameDailyReport); }
		 * sselect.selectByVisibleText("Welcome");Helper.staticWait(3000);}
		 */
		 		
	
						/*
						 * public void DailyReportPaymentFilter() { //Payment Filter
						 * 
						 * driver.findElement(By.id("advSearch_Select_payment_method")).click();Helper.
						 * staticWait(3000); //cash driver.findElement(By.xpath(
						 * "//*[@id=\"advSearch_Select_payment_method\"]/option[1]")).click();}
						 */
		
						
						  public static void DailyReportCardTierFilter() {
						  
						  //Card Tier
						  
							/*
							 * WebElement ElementDailyReportCardTier =
							 * driver.findElement(By.id("advSearch_Select_card_tier"));
							 * ElementDailyReportCardTier.click();Helper.staticWait(3000); Select cselect =
							 * new Select(ElementDailyReportCardTier);
							 * 
							 * List<WebElement> DropDownCardTierDailyReport = cselect.getOptions(); for(int
							 * i=0;i<DropDownCardTierDailyReport.size();i++){ String
							 * drop_down_CardTierDailyReport=DropDownCardTierDailyReport.get(i).getText();
							 * System.out.println("dropdown values are " + drop_down_CardTierDailyReport); }
							 * cselect.selectByVisibleText("DIAMOND");Helper.staticWait(3000);
							 */
						  
						  
						  
							
							/*
							 * Select card = new Select
							 * (driver.findElement(By.id("advSearch_Select_card_tier")));
							 * card.selectByVisibleText("DIAMOND"); //card.selectByIndex(6);
							 */							 
							  Helper.staticWait(3000); 
							  
						      driver.findElement(By.xpath("//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click() ;Helper.staticWait(5000);
							 
						  
						  }
						 
	
	
						/*
						 * public void DailyReportSubmitFilter() throws InterruptedException {
						 * 
						 * driver.findElement(By.xpath(
						 * "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")).click();Helper.
						 * staticWait(3000); driver.findElement(By.xpath(
						 * "//*[@id=\"advSearchContentWrapper\"]/div[2]/div/button")).click();Helper.
						 * staticWait(3000);
						 * 
						 * }
						 */
	
	
	
	public void DailyReportpDownloadPDF() {

		String name = "Shop Group List Record.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
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
		    
		    
		    //File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
		    //String fileName = getLatestFile.getName();
		    //System.out.println(fileName);
		    //Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
		
	}
	
	
	public void DailyReportDownloadExcel() {
		
		try {
		
		DateFormat customFormat = new SimpleDateFormat("yyyyMMdd"); 
		 Date currentdate = new Date(); 
		 String D = customFormat.format(currentdate); System.out.println("Today Date is = " +D);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String name = "Daily_Billing_Report_"+D+"_Abhishek.g";
		//shop menu
		//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		//shop group management 
		//driver.findElement(By.xpath("//*[@id=\"mm-2\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
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
	
	
	
public void DailyReportSearch() {
		
		System.out.println("Search Daily Report by Merchant ID ");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement monthlyreportsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  monthlyreportsearch.sendKeys(pfr.getMerchantID());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement elereportsearch = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[6]"));
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		Assert.assertEquals("1000000004", mesreportsearch);Helper.staticWait(5000);
	}
	
	
	public void DailyReportExportRawData() {
		try {
		System.out.println("Click Daily Report Raw Data  ");
		
		String name = "DAILY REPORT RECORD.xlsx";
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
