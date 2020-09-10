package DashBoard;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util.ExtentTestManager;
import Util.Helper;
import VIPqabase.TestBase;

public class Terminal extends TestBase{
	public static ExtentTest test;
	 Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	 static SoftAssert softassert = new SoftAssert();
	public Terminal(WebDriver driver) {}
	
	
	
	
	public void PortalLoginAudit() {
		
		System.out.println("Verify the Portal logon Audit log..");
		
		DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentdate = new Date();
		String todaydateandtime = customFormat.format(currentdate); System.out.println("System Current Date & Time..............: " + todaydateandtime);
		
		//System.out.println("Current Date & Time: "+java.time.LocalDateTime.now());  
		
		driver.findElement(By.xpath(" //a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Audit Log')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Portal Logon Audit Log')]")).click();Helper.staticWait(5000);
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"table_main\"]/tbody/tr[1]/td[1]")));
		WebElement dandt = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr[1]/td[1]"));
		String mesdandt =  dandt.getText();System.out.println("Portal logon audit captured Date and time." + mesdandt);
		
		softassert.assertEquals(todaydateandtime, mesdandt, "Error on Date and Time Validation ");Helper.staticWait(2000);
		
		String UserAccount = "Abhishek.g";
		
		WebElement useracc = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr[1]/td[2]"));
		String mesuseracc =  useracc.getText();System.out.println("Portal logon audit captured User Account. = " + mesuseracc);
		
		softassert.assertEquals(UserAccount, mesuseracc);;Helper.staticWait(2000);
		softassert.assertAll();
	}

	
	public void CreatTerminal() throws InterruptedException {

		System.out.println("Create a Terminal..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();
		
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
	
	
	
	
	public void TerminalDownloadPDF() {
		try {
		String name = "TERMINAL RECORD.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Terminal List menu
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")));
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();Helper.staticWait(3000);
		//Terminal List PDF download 
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(3000);
		
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
	   
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
	}
	
	
	public void TerminalDownloadExcel() {
		try {
		String name = "TERMINAL RECORD.xlsx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Terminal List menu
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")));
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();Helper.staticWait(3000);
		//Terminal List Excel download
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(3000);
		
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	   
		
		
	}
	
	
	
	public void TerminalAdvancedSearch() {
		
		System.out.println("Advanced search start for Terminal..");
		
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();Helper.staticWait(3000);
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='advSearchBtn']")));
		  driver.findElement(By.xpath("//div[@id='advSearchBtn']")).click(); Helper.staticWait(3000);
		
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
		
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();Helper.staticWait(4000);
		driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input")).sendKeys("5F00000604");;Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(3000);
		driver.findElement(By.id("deleteBtn")).click();Helper.staticWait(3000);
		driver.findElement(By.id("YESDele")).click();Helper.staticWait(5000);
		 ExtentTestManager.getTest().log(Status.INFO,  "***********Delete from Terminal ");
		
	}
	
	
	public void Terminalsearch() {
		System.out.println("Search the Terminal..");
		
		driver.findElement(By.xpath("//div[@id='panel-menu']//a[@class='mm-listitem__text'][contains(text(),'Terminal')]")).click();
		
		 
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement terminalsearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  
		  terminalsearch.sendKeys("5F00000604");Helper.staticWait(5000);
		  
		
		  WebElement eleterminalid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[3]"));
	           String meseleterminalid =   eleterminalid.getText();
	           System.out.println(meseleterminalid);
	         Assert.assertEquals("5F00000604", meseleterminalid);
	}
	
	

	
	
	

}
