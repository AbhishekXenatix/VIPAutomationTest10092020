package TestScript;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DashBoard.MerchanList;
import Util.Helper;
import VIPqabase.TestBase;

public class ShopList extends TestBase{
	
	MerchanList ml = new MerchanList((WebDriver) driver);
	
	
	@Test(priority=1,enabled=true ) 
	public void TestCase_006_Shop_List_Verify_TradingName01() throws InterruptedException  {
		 
		ml.VerifyshopMerchantNameM();
	
		  
	  }
	
	

	@Test(priority=2,enabled=true ) 
	public void TestCase_007_Shop_List_Verify_TradingName02() throws InterruptedException  {
		 
		
		ml.VerifyshopMerchantNameS();
		  
	  }
	
	
	 @DataProvider 
	  public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME);
		  return data;
	  }
	  
	  @Test(priority=3, enabled=true,dataProvider = "getContactsTestData")
	  public void TestCase_008_Create_Shop_list(String tradingname, String rcenter, String propertyid ,String shopid,String grantid,
				String description,String mailingaddress1,String mailingaddress2,String mailingaddress3,String contactperson,String jobtitle
				,String phonenumber,String emailaddress,String vendorcode,String contractno,String chargeonearn,String chargonburn ,String companyname
				,String earnrate,String redeemrate, String sliptitle,String slipheader1,String slipheader2,String slipfooter,String comments
				,String remarks) throws InterruptedException, AWTException {
		  
		      ml.setshoplist();
			  ml.ShopListcopy(tradingname,rcenter
			  ,propertyid,shopid,grantid,description,mailingaddress1,mailingaddress2,
			  mailingaddress3, contactperson,jobtitle , phonenumber, emailaddress
			  ,vendorcode ,contractno , chargeonearn ,chargonburn ,companyname, earnrate,
			  redeemrate,sliptitle , slipheader1 ,slipheader2 ,slipfooter ,comments, remarks); 
			 
		  
	  }
	  
	  @Test(priority=4, enabled=true)
	  public void TestCase_009_PointSchemeShopList() throws AWTException {
		  
		 
		  ml.CreatePointScheme();
	
		 
	  }
	  
	  
	  @Test(priority=5, enabled=false)
	  public void TestCase_010_PointSchemeUpdateShopList() throws AWTException {
		  
		 
		
		  ml.UpdatePointScheme();
		 
	  }
	  
	  
	  @Test(priority=6,enabled=true)
		  public void TestCase_011_shopListAdvSearch() {
			  
			  ml.ShopListAdvancedSearch();
			  
		  }
	  
	  
	  @Test(priority=7,enabled=true)
	  public void TestCase_012_shop_List_DownloadPDF() {
		  
	      ml.ShopDownloadPDF();
	   
		  
	  }
	  
	  
	  @Test(priority=8,enabled=true)
	  public void TestCase_013_shop_List_DownloadExcel() {
		  
	      ml.ShopDownloadExcel();
		  
	  }

}
