package DashBoard;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;

import Util.Helper;
import VIPqabase.TestBase;


public class MerchanList extends TestBase {
	public MerchanList(WebDriver driver) {}
	
	
	public void setshoplist() {
		//click again on shop from dashboard for create mew Shop
		 driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();
		  Helper.staticWait(2000);
		  //click on Shop List for open new 
		  driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[1]/a")).click();Helper.
		  staticWait(2000);
		 // driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		
	}
	
	
	
	public void ShopListcopy(String sid, String tradingname , String rcenter, String propertyid, String shopid, String grantid,
			String description,String mailingaddress1,String mailingaddress2,String mailingaddress3, String contactperson
			,String jobtitle,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
			,String earnrate,String redeemrate ,String sliptitle,String slipheader1,String slipheader2,String slipfooter ,String comments ,String remarks) throws InterruptedException {


		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000); 
		  
		WebElement SID = driver.findElement(By.id("genDetail_SHOP_ID"));
		//SID.clear();
		SID.sendKeys(sid);Helper.staticWait(2000);
		


		WebElement TradingName = driver.findElement(By.id("genDetail_SHOP_NAME"));
		//TradingName.clear();
		TradingName.sendKeys(tradingname);Helper.staticWait(2000);
		
		
		driver.findElement(By.id("genDetail_ACTIVED")).click();
		Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();
		Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_SHOP_GROUP")).click();
		Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[contains(text(),'MOKO')]")).click();
		Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_MERCHANT_ID")).click();
		Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_MERCHANT_ID\"]/option[10]")).click();
		Helper.staticWait(2000);
		
	
		WebElement RevenueCenter = driver.findElement(By.id("genDetail_REVENUE_CENTER_CODE"));
		//RevenueCenter.clear();
		RevenueCenter.sendKeys(rcenter);	Helper.staticWait(2000);

		WebElement PropertyID = driver.findElement(By.id("genDetail_PROPERTY_NO"));
		//PropertyID.clear();
		PropertyID.sendKeys(propertyid);	Helper.staticWait(2000);

		WebElement ShopID = driver.findElement(By.id("genDetail_SHOP_NO"));
		//ShopID.clear();
		ShopID.sendKeys(shopid);Helper.staticWait(2000);

		WebElement GrantID = driver.findElement(By.id("genDetail_LEASE_NO"));
		//GrantID.clear();
		GrantID.sendKeys(grantid); Helper.staticWait(2000);
		
		WebElement Description =driver.findElement(By.id("genDetail_DESCRIPTION"));
		//Description.clear();
		Description.sendKeys(description);Helper.staticWait(2000);
		
		WebElement MailingAddress1 =driver.findElement(By.id("genDetail_ADDRESS_1"));
		//MailingAddress1.clear();
		MailingAddress1.sendKeys(mailingaddress1); Helper.staticWait(2000);
		
		WebElement MailingAddress2 =driver.findElement(By.id("genDetail_ADDRESS_2"));
		//MailingAddress2.clear();
		MailingAddress2.sendKeys(mailingaddress2);Helper.staticWait(2000);
		
		WebElement MailingAddress3 =driver.findElement(By.id("genDetail_ADDRESS_3"));
		//MailingAddress3.clear();
		MailingAddress3.sendKeys(mailingaddress3);Helper.staticWait(2000);
		
		  WebElement ContactPerson = driver.findElement(By.id("genDetail_CONTACT"));
		  //ContactPerson.clear();
		  ContactPerson.sendKeys(contactperson); Helper.staticWait(2000);
		 
		  
		  WebElement JobTitle = driver.findElement(By.id("genDetail_JOB_TITLE"));
		  //JobTitle.clear();
		  JobTitle.sendKeys(jobtitle);Helper.staticWait(2000);
		  
		  
		  WebElement PhoneNumber = driver.findElement(By.id("genDetail_PHONE_NO"));
		 // PhoneNumber.clear();
		  PhoneNumber.sendKeys(phonenumber);Helper.staticWait(2000);
		  
		  WebElement EmailAddress =driver.findElement(By.id("genDetail_EMAIL_ADDRESS"));
		 // EmailAddress.clear();
		  EmailAddress.sendKeys(emailaddress); Helper.staticWait(2000);
		 
		  WebElement VendorCode = driver.findElement(By.id("genDetail_VENDOR_CODE"));
		 // VendorCode.clear();
		  VendorCode.sendKeys(vendorcode);Helper.staticWait(2000);
		  
		  WebElement ContractNo = driver.findElement(By.id("genDetail_CONTRACT_NO"));
		  //ContractNo.clear();
		  ContractNo.sendKeys(contractno);Helper.staticWait(2000);
		  
		  WebElement ChargeonEarn =driver.findElement(By.id("genDetail_CHARGE_ON_EARN"));
		  ChargeonEarn.clear();
		  ChargeonEarn.sendKeys(chargeonearn);Helper.staticWait(2000);
		 
		  WebElement ChargonBurn=driver.findElement(By.id("genDetail_CHARGE_ON_BURN"));
		  ChargonBurn.clear();
		  ChargonBurn.sendKeys(chargonburn); Helper.staticWait(2000);
		  
		  //payment Method
		  driver.findElement(By.id("genDetail_PAYMENT_METHOD")).click();
		  Helper.staticWait(2000);
		  driver.findElement(By.xpath("//*[@id=\"genDetail_PAYMENT_METHOD\"]/option[4]"
		  )).click();Helper.staticWait(2000);
		  
			  WebElement CompanyName = driver.findElement(By.id("genDetail_COMPANY_NAME"));
			  //CompanyName.clear();
			  CompanyName.sendKeys(companyname);
			  Helper.staticWait(2000);
			  
			  
				/*
				 * WebElement ContractEffectiveDate
				 * =driver.findElement(By.id("genDetail_Date_CONTRACT_EFFECTIVE_DATE_From"));
				 * ContractEffectiveDate.click();
				 * 
				 * 
				 * 
				 * WebElement ContractexpiryDate
				 * =driver.findElement(By.id("genDetail_Date_CONTRACT_EXPIRY_DATE_From"));
				 * ContractexpiryDate.click();
				 */
			  
			  WebElement EarnRate = driver.findElement(By.id("genDetail_EARN_RATE"));
			  Actions actions = new Actions(driver); actions.moveToElement(EarnRate);
			 // EarnRate.clear();
			  EarnRate.sendKeys(earnrate);Helper.staticWait(2000);
			 
			  WebElement RedeemRate = driver.findElement(By.id("genDetail_REDEEM_RATIO"));
			  //RedeemRate.clear();
			  RedeemRate.sendKeys(redeemrate);Helper.staticWait(2000);
			  
				  WebElement SlipTitle = driver.findElement(By.id("genDetail_SHOP_TITLE"));
				  //SlipTitle.clear();
				  SlipTitle.sendKeys(sliptitle);Helper.staticWait(2000);
				  
				  WebElement SlipHeader1 =driver.findElement(By.id("genDetail_SHOP_HEADER_1"));
				  //SlipHeader1.clear();
				  SlipHeader1.sendKeys(slipheader1);Helper.staticWait(2000);
				  
				  WebElement SlipHeader2 =driver.findElement(By.id("genDetail_SHOP_HEADER_2"));
				  //SlipHeader2.clear();
				  SlipHeader2.sendKeys(slipheader2);Helper.staticWait(2000);
				  
				  WebElement SlipFooter= driver.findElement(By.id("genDetail_SHOP_FOOTER"));
				  //SlipFooter.clear();
				  SlipFooter.sendKeys(slipfooter);Helper.staticWait(2000);
				 
				  WebElement Comments = driver.findElement(By.id("genDetail_COMMENTS"));
				  //Comments.clear();
				  Comments.sendKeys(comments);Helper.staticWait(2000);
				  
				  WebElement Remarks = driver.findElement(By.id("genDetail_REMARKS"));
				 // Remarks.clear();
				  Remarks.sendKeys(remarks);Helper.staticWait(2000);
				  
				  WebElement Saveall = driver.findElement(By.id("sliderBtnSaveNew"));
				  Actions actions1 = new Actions(driver);
				  actions1.moveToElement(Saveall).build().perform();
				  Helper.staticWait(2000);
				  
				  WebElement Saveall1 = driver.findElement(By.id("sliderBtnSaveNew"));
				  Saveall1.click();
				  Helper.staticWait(5000);
	}





}









