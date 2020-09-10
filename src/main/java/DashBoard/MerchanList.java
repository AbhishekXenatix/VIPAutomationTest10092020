package DashBoard;

import java.awt.AWTException;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import Util.Helper;
import VIPqabase.TestBase;


public class MerchanList extends TestBase {
	 Helper helper = new Helper();
	 public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	public MerchanList(WebDriver driver) {}
	
	
	public void setshoplist() {
		//click again on shop from dashboard for create mew Shop
		   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();
		  Helper.staticWait(2000);
		  //click on Shop List for open new 
		  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Shop List')]")));
		  driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper. staticWait(12000);
		 
		
	}
	
	
	
	public void ShopListcopy(String tradingname , String rcenter, String propertyid, String shopid, String grantid,
			String description,String mailingaddress1,String mailingaddress2,String mailingaddress3, String contactperson
			,String jobtitle,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
			,String earnrate,String redeemrate ,String sliptitle,String slipheader1,String slipheader2,String slipfooter ,String comments ,String remarks) throws InterruptedException {

		try {
		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("newItemMain")));
		  driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000); 
		  
			
		WebElement TradingName = driver.findElement(By.id("genDetail_SHOP_NAME"));
		TradingName.sendKeys(tradingname);Helper.staticWait(2000);
		
		
		driver.findElement(By.id("genDetail_ACTIVED")).click();
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();
		
		
		driver.findElement(By.id("genDetail_SHOP_GROUP")).click();
		driver.findElement(By.xpath("//*[contains(text(),'MOKO')]")).click();
		
	
		//Merchant Name
		
		 WebElement elementmerchantname = driver.findElement(By.id("genDetail_MERCHANT_ID"));
		 elementmerchantname.click();Helper.staticWait(3000);
      	 Select select = new Select(elementmerchantname); 
      	
 		 List<WebElement> dropdownmerchantname = select.getOptions();
 		 for(int i=0;i<dropdownmerchantname.size();i++){
 			 String drop_down_merchantname = dropdownmerchantname.get(i).getText();
 			  System.out.println("dropdown values are " + drop_down_merchantname);  }
 		         select.selectByVisibleText("SPECTRA - Sample Merchant");Helper.staticWait(3000);
 		         
	
		WebElement RevenueCenter = driver.findElement(By.id("genDetail_REVENUE_CENTER_CODE"));RevenueCenter.sendKeys(rcenter);

		WebElement PropertyID = driver.findElement(By.id("genDetail_PROPERTY_NO"));PropertyID.sendKeys(propertyid);
		
		WebElement ShopID = driver.findElement(By.id("genDetail_SHOP_NO"));ShopID.sendKeys(shopid);
		
		WebElement GrantID = driver.findElement(By.id("genDetail_LEASE_NO"));GrantID.sendKeys(grantid); 
		
		WebElement Description =driver.findElement(By.id("genDetail_DESCRIPTION"));Description.sendKeys(description);
		
		WebElement MailingAddress1 =driver.findElement(By.id("genDetail_ADDRESS_1"));MailingAddress1.sendKeys(mailingaddress1);
		
		WebElement MailingAddress2 =driver.findElement(By.id("genDetail_ADDRESS_2"));MailingAddress2.sendKeys(mailingaddress2);
		
		WebElement MailingAddress3 =driver.findElement(By.id("genDetail_ADDRESS_3"));MailingAddress3.sendKeys(mailingaddress3);
		
		WebElement ContactPerson = driver.findElement(By.id("genDetail_CONTACT")); ContactPerson.sendKeys(contactperson); 
		 
		WebElement JobTitle = driver.findElement(By.id("genDetail_JOB_TITLE"));JobTitle.sendKeys(jobtitle);
		  
		WebElement PhoneNumber = driver.findElement(By.id("genDetail_PHONE_NO"));PhoneNumber.sendKeys(phonenumber);
		
		WebElement EmailAddress =driver.findElement(By.id("genDetail_EMAIL_ADDRESS"));EmailAddress.sendKeys(emailaddress); 
		
		WebElement VendorCode = driver.findElement(By.id("genDetail_VENDOR_CODE")); VendorCode.sendKeys(vendorcode);
		 
		WebElement ContractNo = driver.findElement(By.id("genDetail_CONTRACT_NO")); ContractNo.sendKeys(contractno);
		
		WebElement ChargeonEarn =driver.findElement(By.id("genDetail_CHARGE_ON_EARN")); ChargeonEarn.clear();ChargeonEarn.sendKeys(chargeonearn);
		 
		WebElement ChargonBurn=driver.findElement(By.id("genDetail_CHARGE_ON_BURN"));ChargonBurn.clear();ChargonBurn.sendKeys(chargonburn);
		  
		  //payment Method
		  driver.findElement(By.id("genDetail_PAYMENT_METHOD")).click();
		  driver.findElement(By.xpath("//*[@id=\"genDetail_PAYMENT_METHOD\"]/option[4]" )).click();Helper.staticWait(2000);
		  
		 WebElement CompanyName = driver.findElement(By.id("genDetail_COMPANY_NAME"));  CompanyName.sendKeys(companyname);
			 
			
			 
			  WebElement EarnRate = driver.findElement(By.id("genDetail_EARN_RATE"));
			  Actions actions = new Actions(driver); actions.moveToElement(EarnRate);
			 EarnRate.clear();EarnRate.sendKeys(earnrate);Helper.staticWait(2000);
			 
			  WebElement RedeemRate = driver.findElement(By.id("genDetail_REDEEM_RATIO"));
			  RedeemRate.clear(); RedeemRate.sendKeys(redeemrate);Helper.staticWait(2000);
			  
				  WebElement SlipTitle = driver.findElement(By.id("genDetail_SHOP_TITLE"));SlipTitle.sendKeys(sliptitle);
				
				  WebElement SlipHeader1 =driver.findElement(By.id("genDetail_SHOP_HEADER_1"));  SlipHeader1.sendKeys(slipheader1);
				  
				  WebElement SlipHeader2 =driver.findElement(By.id("genDetail_SHOP_HEADER_2"));SlipHeader2.sendKeys(slipheader2);
				
				  WebElement SlipFooter= driver.findElement(By.id("genDetail_SHOP_FOOTER"));SlipFooter.sendKeys(slipfooter);
				 
				  WebElement Comments = driver.findElement(By.id("genDetail_COMMENTS")); Comments.sendKeys(comments);
				 
				  WebElement Remarks = driver.findElement(By.id("genDetail_REMARKS"));Remarks.sendKeys(remarks);
				
				  
				  WebElement Saveall = driver.findElement(By.id("sliderBtnSaveNew"));
				  Actions actions1 = new Actions(driver); actions1.moveToElement(Saveall).build().perform();
				 
				  WebElement Saveall1 = driver.findElement(By.id("sliderBtnSaveNew"));
				  Saveall1.click();  Helper.staticWait(12000);
				
				  
				  System.out.println("Shop List entry finished..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	
	public void ShopDownloadPDF() {
		
		try {
		String name = "SHOP LIST RECORD.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		 driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop group management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(12000);
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(2000);
		
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
	   
	    System.out.println("ShopDownloadPDF finished..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void ShopDownloadExcel() {
		try {
		String name = "SHOP LIST RECORD.xlsx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop group management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(12000);
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(3000);
		
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
	    
	   
	    System.out.println("ShopDownloadExcel finished..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public  void CreatePointScheme() throws AWTException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Create Point Scheme from shop list");
		//shop menu
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop list management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(12000);
		
		
		//click on new item button
		//driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input")).sendKeys("Mannings");Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(3000);
		driver.findElement(By.id("table_main")).click();Helper.staticWait(2000);
		
		driver.findElement(By.xpath("//*[@id=\"slider_1\"]/div/div[2]/div[2]/div[2]/div[2]"));Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_block_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(3000);
		
		//create new Entry
		//Effective from
		
		driver.findElement(By.id("DTE_Field_EFFECTIVE_PERIOD_FROM")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr[2]/td[2]/button")).click();Helper.staticWait(3000);
		
		//Effective to 
		
		driver.findElement(By.id("DTE_Field_EFFECTIVE_PERIOD_TO")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//button[contains(text(),'30')]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("DTE_Field_EARN_RATE")).sendKeys("1");Helper.staticWait(2000);
		driver.findElement(By.id("DTE_Field_REDEEM_RATIO")).sendKeys("5");;Helper.staticWait(2000);
		driver.findElement(By.id("DTE_Field_COMMENTS")).sendKeys("Testing..");Helper.staticWait(2000);
		driver.findElement(By.id("DTE_Field_REMARKS")).sendKeys("for testing..");Helper.staticWait(2000);
		
		WebElement chargeonearn = driver.findElement(By.id("DTE_Field_CHARGE_ON_EARN"));
		chargeonearn.clear();chargeonearn.sendKeys("2");Helper.staticWait(2000);
		
		WebElement chargeonbarn = driver.findElement(By.id("DTE_Field_CHARGE_ON_BURN"));
		chargeonbarn.clear();chargeonbarn.sendKeys("3");Helper.staticWait(2000);
		
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		//chargeonbarn.sendKeys("3");chargeonbarn.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("sliderBtnSaveEdit")).click();Helper.staticWait(15000);
		
		System.out.println("CreatePointScheme finished..");
		
	}
	
	public void UpdatePointScheme()  {
		System.out.println("Update Point Scheme from shop list");
		
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop list management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(12000);
		
		
		//click on new item button
		//driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input")).sendKeys("Welcome");Helper.staticWait(2000);
		
		WebElement elesid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[2]"));
		//elesid.click();
		String ssid = elesid.getText();
		System.out.println("SID Number is : " + ssid);
		Helper.staticWait(2000);
		
		//click selected row
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(2000);
		driver.findElement(By.id("table_main")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"slider_1\"]/div/div[2]/div[2]/div[2]/div[2]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.xpath("//*[@id=\"table_block\"]/tbody/tr")).click();Helper.staticWait(2000);
		

	
		WebElement  SID = driver.findElement(By.xpath("//*[@id=\"table_block\"]/tbody/tr/td[1]"));
		String sid = SID.getText();System.out.println("Point Scheme SID Number is : " + sid);Helper.staticWait(2000);
		
		if(((SID).getText().equalsIgnoreCase(ssid))) {
		
		driver.findElement(By.xpath("//*[@id=\"table_block_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(2000);
		
		WebElement ER = driver.findElement(By.id("DTE_Field_EARN_RATE"));ER.clear();ER.sendKeys("2");Helper.staticWait(2000);
		WebElement CE = driver.findElement(By.id("DTE_Field_CHARGE_ON_EARN"));CE.clear();CE.sendKeys("3");Helper.staticWait(2000);
		WebElement CB = driver.findElement(By.id("DTE_Field_CHARGE_ON_BURN"));CB.clear();CB.sendKeys("4");CB.sendKeys(Keys.ENTER);CB.sendKeys(Keys.ESCAPE);Helper.staticWait(5000);}
		//driver.findElement(By.xpath("//button[@class='btn']")).click();
		else {
			System.out.println("Please check Point update scheme");
		}
		
		driver.findElement(By.id("sliderBtnSaveEdit")).click();Helper.staticWait(15000);

		System.out.println("UpdatePointScheme finished..");
	}
	
	
	public void ShopListAdvancedSearch() {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop list management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(12000);
		System.out.println("click on new Item from shop list");
		
		//click on Advanced search button
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		
		//select shop group drop down list
		
		WebElement elementshopgroup = driver.findElement(By.id("advSearch_Select_group_id"));
		elementshopgroup.click();Helper.staticWait(3000);
		Select select = new Select(elementshopgroup); 
		
		 List<WebElement> dropdownshopgroup=select.getOptions();
		 for(int i=0;i<dropdownshopgroup.size();i++){
			 String drop_down_shopgroup=dropdownshopgroup.get(i).getText();
			 System.out.println("dropdown values are "+drop_down_shopgroup);  }
		         select.selectByVisibleText("MOKO");Helper.staticWait(3000);
		
		
		  //select Trading name from drop down
		         
		     	WebElement elementtradingname = driver.findElement(By.id("advSearch_Select_trading_name"));
		     	elementtradingname.click();Helper.staticWait(3000);
		     	Select oselect = new Select(elementtradingname); 
		     	
				 List<WebElement> dropdowntradingname=oselect.getOptions();
				 for(int i=0;i<dropdowntradingname.size();i++){
					 String drop_down_tradingname=dropdowntradingname.get(i).getText();
					 System.out.println("dropdown values are " + drop_down_tradingname);  }
				         oselect.selectByVisibleText("Mannings");Helper.staticWait(3000);
		         
				       //select Merchant name from drop down
				         
				         WebElement elementmerchantname = driver.findElement(By.id("advSearch_Select_merchant_name"));
				         elementmerchantname.click();Helper.staticWait(3000);
					     	Select mselect = new Select(elementmerchantname); 
					     	
							 List<WebElement> dropdownmerchantname=mselect.getOptions();
							 for(int i=0;i<dropdownmerchantname.size();i++){
								 String drop_down_merchantname=dropdownmerchantname.get(i).getText();
								 System.out.println("dropdown values are " + drop_down_merchantname);  }
							         mselect.selectByVisibleText("SPECTRA - Sample Merchant");Helper.staticWait(3000);
							         
							         
										/*
										 * //select Shop Id from drop down
										 * 
										 * WebElement elementshopid =
										 * driver.findElement(By.id("advSearch_Select_shop_id"));
										 * elementshopid.click();Helper.staticWait(3000); Select sselect = new
										 * Select(elementshopid);
										 * 
										 * List<WebElement> dropdownshopid=sselect.getOptions(); for(int
										 * i=0;i<dropdownshopid.size();i++){ String
										 * drop_down_shopid=dropdownshopid.get(i).getText();
										 * System.out.println("dropdown values are " + drop_down_shopid); }
										 * sselect.selectByVisibleText("MTR");Helper.staticWait(3000);
										 * 
										 * 
										 * //click on Active button
										 * 
										 * driver.findElement(By.id("advSearch_Select_active")).click();
										 * driver.findElement(By.xpath("//*[@id=\"advSearch_Select_active\"]/option[2]")
										 * ).click();Helper.staticWait(3000);
										 * 
										 * 
										 * //Revenue center
										 * driver.findElement(By.id("advSearch_revenue_center")).sendKeys("");Helper.
										 * staticWait(3000);
										 * 
										 * //Property Id
										 * 
										 * driver.findElement(By.id("advSearch_property_id")).sendKeys("");Helper.
										 * staticWait(3000);
										 * 
										 * //Grant ID
										 * driver.findElement(By.id("advSearch_grant_id")).sendKeys("");Helper.
										 * staticWait(3000);
										 */
										         
										         
										         
										         driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(3000);
										         
										         System.out.println("ShopListAdvancedSearch finished..");
		         
	}
	
	
	
	
	
	public void DeleteGroupnameforshoplist() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop list management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(13000);
		//click on Advance search 
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(3000);
		//enter value in group name search 
		
		
		WebElement elementshopgroupforshoplist = driver.findElement(By.id("advSearch_Select_trading_name"));
		elementshopgroupforshoplist.click();Helper.staticWait(3000);
     	Select select = new Select(elementshopgroupforshoplist); 
     	
		 List<WebElement> dropdownshopgroupforshoplist = select.getOptions();
		 for(int i=0;i<dropdownshopgroupforshoplist.size();i++){
			 String drop_down_shopgroupforshoplist=dropdownshopgroupforshoplist.get(i).getText();
			 System.out.println("dropdown values are " + drop_down_shopgroupforshoplist);  }
		         select.selectByVisibleText("Mannings");Helper.staticWait(3000);
		
		
	
		driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(3000);
		driver.findElement(By.id("deleteBtn")).click();Helper.staticWait(3000);
		driver.findElement(By.id("YESDele")).click();Helper.staticWait(12000);
		  System.out.println("DeleteGroupnameforshoplist finished..");
	}
	
	
	public void DeleteGroupnameforshoplistSeven() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		//shop list management 
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(13000);
		//click on Advance search 
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(7000);
		//enter value in group name search 
		
		
		WebElement elementshopgroupforshoplist = driver.findElement(By.id("advSearch_Select_trading_name"));
		elementshopgroupforshoplist.click();Helper.staticWait(3000);
     	Select select = new Select(elementshopgroupforshoplist); 
     	
		 List<WebElement> dropdownshopgroupforshoplist = select.getOptions();
		 for(int i=0;i<dropdownshopgroupforshoplist.size();i++){
			 String drop_down_shopgroupforshoplist=dropdownshopgroupforshoplist.get(i).getText();
			 System.out.println("dropdown values are " + drop_down_shopgroupforshoplist);  }
		         select.selectByVisibleText("Seven11");Helper.staticWait(3000);
		
		
	
		driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(3000);
		driver.findElement(By.id("deleteBtn")).click();Helper.staticWait(3000);
		driver.findElement(By.id("YESDele")).click();Helper.staticWait(15000);
		System.out.println("DeleteGroupnameforshoplistSeven finished..");
	}
	
	
	
	
public void VerifyshopMerchantNameM() throws InterruptedException  {
		String nodata ="No matching records found";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(13000);
		  driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input") ).sendKeys("Mannings");Helper.staticWait(3000);
		WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td"));
			System.out.println((searchresult).getText());
			if(((searchresult).getText().equalsIgnoreCase(nodata))) {
				System.out.println("Create a new Shop");
			} else {
				System.out.println("Please delete Manning shop");
				DeleteGroupnameforshoplist();
		}
		}
		

public void VerifyshopMerchantNameS() throws InterruptedException  {
	String nodata ="No matching records found";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(13000);
	  driver.findElement(By.xpath("//*[@id=\"table_main_filter\"]/label/input") ).sendKeys("Seven11");Helper.staticWait(3000);
	  
	WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td"));
		System.out.println((searchresult).getText());
		if(((searchresult).getText().equalsIgnoreCase(nodata))) {
			System.out.println("Create a new Shop");
		} else {
			System.out.println("Please delete Seven11 shop");
			DeleteGroupnameforshoplistSeven();
			
	}
	}
	
	
	

	







}









