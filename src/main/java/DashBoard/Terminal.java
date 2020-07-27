package DashBoard;

import java.util.List;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util.ExtentTestManager;
import Util.Helper;
import VIPqabase.TestBase;

public class Terminal extends TestBase{
	public static ExtentTest test;
	 Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	
	public Terminal(WebDriver driver) {}
	
	
	public void CreatTerminal() throws InterruptedException {

		System.out.println("Create a Terminal..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();
		
		Helper.staticWait(3000);
		driver.findElement(By.id("newTerminal")).click();
		Helper.staticWait(2000);
		
		/*
		 * WebElement apollod = driver.findElement(By.id("newTerminalJBox"));
		 * apollod.click();Helper.staticWait(2000);
		 * 
		 * WebElement sel = driver.findElement(By.id("newItemMain"));
		 * sel.click();Helper.staticWait(2000);
		 */
		
		
		 WebElement element = driver.findElement(By.id("genDetail_SHOP_ID"));
		 element.click();
		 
		 Select select = new Select(element); 
		 List<WebElement> dropdown=select.getOptions();
		 for(int i=0;i<dropdown.size();i++){
			 
			 String drop_down_values=dropdown.get(i).getText();
			 
			 System.out.println("dropdown values are "+drop_down_values);
			 
			 }
		 
		 select.selectByVisibleText("Mannings");Helper.staticWait(2000);
		
		WebElement activestatus = driver.findElement(By.id("genDetail_ACTIVED"));
		activestatus.click();Helper.staticWait(2000);
		
	    driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
	    
	    driver.findElement(By.id("genDetail_SERIAL_NUM")).sendKeys("5F00000604");Helper.staticWait(2000);
	    
	    driver.findElement(By.id("sliderBtnSaveNew")).click();;Helper.staticWait(6000);
		
	}
	
	
	public void createterminalnotapollo() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Create if not Apollo terminal");
		Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newTerminal")).click();Helper.staticWait(2000);
		
		WebElement apollodno = driver.findElement(By.id("newTerminalJBox"));
		apollodno.click();Helper.staticWait(2000);
		
		driver.findElement(By.id("NOAPO")).click();Helper.staticWait(2000);
		
		WebElement Terminalid = driver.findElement(By.id("genDetail_TERMINAL_ID"));
		Terminalid.sendKeys("1011111111100");Helper.staticWait(2000);
		
		 WebElement ele01 = driver.findElement(By.id("genDetail_SHOP_ID"));
		 ele01.click(); 
		Select select = new Select(ele01); 
		 select.selectByVisibleText("Mannings");Helper.staticWait(3000);
		 
		 
		 WebElement activestatus = driver.findElement(By.id("genDetail_ACTIVED"));
			activestatus.click();Helper.staticWait(2000);
			
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_DESCRIPTION")).sendKeys("Hey this is not for Apollo..");
		driver.findElement(By.id("genDetail_COMMENTS")).sendKeys("Hey Thanks..");
		driver.findElement(By.id("genDetail_REMARKS")).sendKeys("Thanks..");Helper.staticWait(2000);
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(5000);
		
	}
	
	
	public void TerminalDownloadPDF() {
		String fileName = "Terminal Record.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Terminal List menu
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(3000);
		//Terminal List PDF download 
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(3000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, fileName), "Failed to download Expected document");
	   
		
	}
	
	
	public void TerminalDownloadExcel() {
		String fileName = "Terminal Record.xlsx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Terminal List menu
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(3000);
		//Terminal List Excel download
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(3000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, fileName), "Failed to download Expected document");
	   
		
		
	}
	
	
	
	public void TerminalAdvancedSearch() {
		
		System.out.println("Advanced search start for Terminal..");
		
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(3000);
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(3000);
		
		//Active
		driver.findElement(By.id("advSearch_Select_active")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"advSearch_Select_active\"]/option[2]")).click();Helper.staticWait(3000);
		
		//Merchant Name
		
		 WebElement elementmerchantname = driver.findElement(By.id("advSearch_Select_merchant_name"));
		 elementmerchantname.click();Helper.staticWait(3000);
 		
      	Select select = new Select(elementmerchantname); 
      	
 		 List<WebElement> dropdownmerchantname = select.getOptions();
 		 for(int i=0;i<dropdownmerchantname.size();i++){
 			 String drop_down_merchantname = dropdownmerchantname.get(i).getText();
 			 System.out.println("dropdown values are " + drop_down_merchantname);  }
 		         select.selectByVisibleText("SPECTRA - Sample Merchant");Helper.staticWait(3000);
 		         
 		         driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(5000);
	}
	
	
	public void deleteall() {
		
		//terminal delete
		
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[6]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input")).sendKeys("5F00000604");;Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(2000);
		driver.findElement(By.id("deleteBtn")).click();Helper.staticWait(2000);
		driver.findElement(By.id("YESDele")).click();Helper.staticWait(5000);
		 ExtentTestManager.getTest().log(Status.INFO,  "***********Delete from Terminal ");
		
	}
	
	

	
	
	

}
