package DashBoard;

import java.io.File;
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

public class MerchantProfile extends TestBase  {
	 PropertyFileReader pfr = new PropertyFileReader();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	public MerchantProfile(WebDriver driver) {}
	
	
	public void CreateMerchant() {
		
		System.out.println("Create Merchant Profile List..");
		
		//click on the Merchant from menu 
		 driver.findElement(By.xpath("//a[contains(text(),'Merchant')]")).click(); Helper.staticWait(3000);
		//click on new item for merchant 
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='newItemMain']")));
		 driver.findElement(By.xpath("//div[@id='newItemMain']")).click(); Helper.staticWait(3000);
		 
		 //MID
		 driver.findElement(By.xpath("//input[@id='genDetail_MERCHANT_ID']")).sendKeys(pfr.getMID()); Helper.staticWait(3000);
		 
		 //Merchant name
		 driver.findElement(By.xpath("//input[@id='genDetail_MERCHANT_NAME']")).sendKeys(pfr.getMerchantName()); Helper.staticWait(3000);
		 
		 driver.findElement(By.xpath("//input[@id='genDetail_DESCRIPTION']")).sendKeys(pfr.getDescription()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_1']")).sendKeys(pfr.getADDRESS_1()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_2']")).sendKeys(pfr.getADDRESS_2()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_3']")).sendKeys(pfr.getADDRESS_3()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_CONTACT']")).sendKeys(pfr.getCONTACT()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_JOB_TITLE']")).sendKeys(pfr.getJOB_TITLE()); 
		 driver.findElement(By.xpath("//input[@id='genDetail_PHONE_NO']")).sendKeys(pfr.getPHONE_NO());
		 driver.findElement(By.xpath("//input[@id='genDetail_EMAIL_ADDRESS']")).sendKeys(pfr.getEMAIL_ADDRESS()); 
		 driver.findElement(By.xpath("//textarea[@id='genDetail_COMMENTS']")).sendKeys(pfr.getCOMMENTS()); 
		 driver.findElement(By.xpath("//textarea[@id='genDetail_REMARKS']")).sendKeys(pfr.getREMARKS()); Helper.staticWait(3000);
		 
		 
		
		 driver.findElement(By.xpath("//select[@id='genDetail_ACTIVED']")).click(); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//select[@id='genDetail_ACTIVED']//option[contains(text(),'Active')]")).click(); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//button[@id='sliderBtnSaveNew']")).click();Helper.staticWait(5000);
	}
	
	public void MerchantAdvancedSearch() {
		System.out.println("Veirfy Merchant Advanced Search Profile List..");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='advSearchBtn']")));
		driver.findElement(By.xpath("//div[@id='advSearchBtn']")).click();Helper.staticWait(3000);
		
		
		 WebElement elementmerchantname = driver.findElement(By.xpath("//select[@id='advSearch_Select_MERCHANT_ID']"));
		 elementmerchantname.click();Helper.staticWait(3000);
 		
      	Select select = new Select(elementmerchantname); 
      	
 		 List<WebElement> dropdownmerchantname = select.getOptions();
 		 for(int i=0;i<dropdownmerchantname.size();i++){
 			 String drop_down_merchantname = dropdownmerchantname.get(i).getText();
 			 System.out.println("dropdown values are " + drop_down_merchantname);  }
 		         select.selectByVisibleText("VOLVIC");Helper.staticWait(3000);
 		         driver.findElement(By.xpath("//div[@id='advSearch_Search']")).click();
 		         
		
	}
	
	public void MerchantSearch() {
		try {
		System.out.println("Veirfy Merchant Search Profile List..");
		driver.findElement(By.xpath("//a[contains(text(),'Merchant')]")).click(); Helper.staticWait(3000);
		
		  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement merchantname =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  
		  merchantname.sendKeys(pfr.getMerchantName());Helper.staticWait(2000);
		  
		  
		 
		WebElement elereportsearch = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[3]"));
		String mesreportsearch = elereportsearch.getText();System.out.println(mesreportsearch);
		Assert.assertEquals("VOLVIC", mesreportsearch);Helper.staticWait(5000);
		merchantname.clear();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void  MerchantDownloadPDF() {
		try {
		String name = "MERCHANT LIST.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Download Merchant PDF Profile List..");
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(5000);
		 
		    File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
		    String fileName = getLatestFile.getName();
		    System.out.println(fileName);
		    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded PDF file name is not matching with expected file name");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void  MerchantDownloadExcel() {
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String name = "MERCHANT LIST.xlsx";
	System.out.println("Download Merchant excel Profile List..");
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(5000);
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	   String fileName = getLatestFile.getName();
	   System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded Excel file name is not matching with expected file name");
	    
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
