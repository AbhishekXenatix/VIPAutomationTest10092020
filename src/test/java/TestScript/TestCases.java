package TestScript;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import DashBoard.MerchanList;
import DashBoard.ShopGroupManagement;
import DashBoard.Terminal;
import Util.ExtentTestListner;
import Util.Helper;
import VIPqabase.TestBase;

@Listeners({ExtentTestListner.class})
public class TestCases extends TestBase{
	
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	Terminal terminal = new Terminal((WebDriver) driver);
	
	
	
	  @Test(priority=1,enabled=true ) 
	  public void TestCase_001_Click_Shop_menu() throws InterruptedException  {
		 
		  shopgroupm.Createshop();
		  shopgroupm.ShopGroupList();
		  shopgroupm.ShopGroupListPositive();
		  
	  }
	  
	  @DataProvider 
	  public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME);
		  return data;
	  }
	  
	  @Test(priority=2, enabled=true,dataProvider = "getContactsTestData")
	  public void TestCase_002_Create_Shop_list(String sid, String tradingname, String rcenter, String propertyid ,String shopid,String grantid,
				String description,String mailingaddress1,String mailingaddress2,String mailingaddress3,String contactperson,String jobtitle
				,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
				,String earnrate,String redeemrate, String sliptitle,String slipheader1,String slipheader2,String slipfooter,String comments
				,String remarks) throws InterruptedException {
		  
		  ml.setshoplist();
	      ml.ShopListcopy(sid, tradingname,rcenter ,propertyid,shopid,grantid,description,mailingaddress1,mailingaddress2,mailingaddress3, contactperson,jobtitle
			  , phonenumber, emailaddress ,vendorcode ,contractno , chargeonearn ,chargonburn ,companyname, earnrate, redeemrate,sliptitle
			 , slipheader1 ,slipheader2 ,slipfooter ,comments, remarks);
	  }
	  
	  @Test(priority=3,enabled=true ) 
		  
		  public void TestCase_003_Terminal() throws InterruptedException  {
		  terminal.CreatTerminal();
		  terminal.createterminalnotapollo();
		  
		  }
	  
	
	  
	  
	  
	  
	  
	  
	  
	}
	
