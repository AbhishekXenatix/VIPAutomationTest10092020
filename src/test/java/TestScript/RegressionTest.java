package TestScript;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DashBoard.DailyReport;
import DashBoard.MerchanList;
import DashBoard.MonthlyReport;
import DashBoard.ShopGroupManagement;
import DashBoard.Terminal;
import DashBoard.Transactions;
import DashBoard.UserGroupPermission;
import DashBoard.UserListForSetting;
import Util.ExtentTestListner;
import Util.Helper;
import VIPqabase.TestBase;

@Listeners({ExtentTestListner.class})
public class RegressionTest extends TestBase{
	
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	
	
	
	
	
	@Test(priority=1,enabled=true ) 
	public void TestCase_001_Click_Shop_menu() throws InterruptedException  {
		 
		
		  shopgroupm.Createshop();
		  shopgroupm.ShopGroupList();
		  shopgroupm.VerifyshopGroupName();
		  
	  }
	
	@Test(priority=2,enabled=false ) 
	public void TestCase_002_Shop_menu_DownloadPDF() throws InterruptedException  {
		 
		  shopgroupm. GroupDownloadPDF();
		 
	  }
	
	@Test(priority=3,enabled=false ) 
	public void TestCase_003_Shop_menu_DownloadExcel() throws InterruptedException  {
		 
		
		  shopgroupm.GroupDownloadExcel();
	  }
	

	@Test(priority=4,enabled=false ) 
	public void TestCase_004_Shop_menu_Verifym() throws InterruptedException  {
		 
		ml.VerifyshopMerchantNameM();
	
		  
	  }
	
	

	@Test(priority=5,enabled=false ) 
	public void TestCase_005_Shop_menu_Verifys() throws InterruptedException  {
		 
		
		ml.VerifyshopMerchantNameS();
		  
	  }
	
	
	 @DataProvider 
	  public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME);
		  return data;
	  }
	  
	  @Test(priority=6, enabled=false,dataProvider = "getContactsTestData")
	  public void TestCase_006_Create_Shop_list(String sid, String tradingname, String rcenter, String propertyid ,String shopid,String grantid,
				String description,String mailingaddress1,String mailingaddress2,String mailingaddress3,String contactperson,String jobtitle
				,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
				,String earnrate,String redeemrate, String sliptitle,String slipheader1,String slipheader2,String slipfooter,String comments
				,String remarks) throws InterruptedException, AWTException {
		  
		      ml.setshoplist();
			  ml.ShopListcopy(sid, tradingname,rcenter
			  ,propertyid,shopid,grantid,description,mailingaddress1,mailingaddress2,
			  mailingaddress3, contactperson,jobtitle , phonenumber, emailaddress
			  ,vendorcode ,contractno , chargeonearn ,chargonburn ,companyname, earnrate,
			  redeemrate,sliptitle , slipheader1 ,slipheader2 ,slipfooter ,comments, remarks); 
			 
		  
	  }
	  
	  @Test(priority=7, enabled=false)
	  public void TestCase_006_PointSchemeShopList() throws AWTException {
		  
		 
		  ml.CreatePointScheme();
	
		 
	  }
	  
	  
	  @Test(priority=8, enabled=false)
	  public void TestCase_008_PointSchemeUpdateShopList() throws AWTException {
		  
		 
		
		  ml.UpdatePointScheme();
		 
	  }
	  
	  
	  @Test(priority=9,enabled=false)
		  public void TestCase_009_shopAdvSearch() {
			  
			  ml.ShopListAdvancedSearch();
			  
		  }
	  
	  
	  @Test(priority=10,enabled=false)
	  public void TestCase_010_shop_DownloadPDF() {
		  
	      ml.ShopDownloadPDF();
	   
		  
	  }
	  
	  
	  @Test(priority=11,enabled=false)
	  public void TestCase_011_shop_DownloadExcel() {
		  
	      ml.ShopDownloadExcel();
		  
	  }
	  
	  
	
 
	  
	 
	  
	 
	  
	
	 
	  
	  
	  
	  
	
	
	
	
	
	  

}
