package TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DashBoard.MerchanList;
import DashBoard.ShopGroupManagement;
import DashBoard.Terminal;
import DashBoard.UserGroupPermission;
import Util.ExtentTestListner;
import Util.Helper;
import VIPqabase.TestBase;


@Listeners({ExtentTestListner.class})
public class ShopListTestCase extends TestBase{
	
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	Terminal terminal = new Terminal((WebDriver) driver);
	UserGroupPermission UGP = new UserGroupPermission((WebDriver) driver);
	
	@Test(priority=1, enabled=false)
	public void setuptestdata() {
		
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[1]/a")).click();Helper.staticWait(2000);
		
	}
	
	 @DataProvider 
	  public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME);
		  return data;
	  }
	  
	  @Test(priority=2, enabled=false,dataProvider = "getContactsTestData")
	  public void TestCase_002_Create_Shop_list(String sid, String tradingname, String rcenter, String propertyid ,String shopid,String grantid,
				String description,String mailingaddress1,String mailingaddress2,String mailingaddress3,String contactperson,String jobtitle
				,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
				,String earnrate,String redeemrate, String sliptitle,String slipheader1,String slipheader2,String slipfooter,String comments
				,String remarks) throws InterruptedException
	  {
        ml.ShopListcopy(sid, tradingname,rcenter ,propertyid,shopid,grantid,description,mailingaddress1,mailingaddress2,mailingaddress3, contactperson,jobtitle
	    , phonenumber, emailaddress ,vendorcode ,contractno , chargeonearn ,chargonburn ,companyname, earnrate, redeemrate,sliptitle
	    , slipheader1 ,slipheader2 ,slipfooter ,comments, remarks);
	  }
	  
	  
	  
	  @Test(priority=3, enabled=true)
	  public void TestCase_003_UserGroupPermission() {
		  UGP.CreateInternalUserGroup();
		  
	  }

	  
	  
	  
	  
	  
	  

}
