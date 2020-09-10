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
public class ShopGroupManagementTest extends TestBase{
	
	
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	
	
	
	
	
	@Test(priority=1,enabled=true ) 
	public void TestCase_001_Click_Shop_Group_Management() throws InterruptedException  {
		 
		
		  shopgroupm.Createshop();
		  shopgroupm.ShopGroupList();
		  shopgroupm.VerifyshopGroupName();
		  
	  }
	
	@Test(priority=2,enabled=true ) 
	public void TestCase_002_Shop_Group_Management_DownloadPDF() throws InterruptedException  {
		 
		  shopgroupm. GroupDownloadPDF();
		 
	  }
	
	@Test(priority=3,enabled=true ) 
	public void TestCase_003_Shop_Group_Management_DownloadExcel() throws InterruptedException  {
		 
		
		  shopgroupm.GroupDownloadExcel();
	  }
	
	
	@Test(priority=4,enabled=true) 
	public void TestCase_004_Shop_Group_AdvancedSearch() throws InterruptedException  {
		 
		
		  shopgroupm.ShopGroupAdvancedSearch();
	  }

	

	 
		
		  @Test(priority=5,enabled=true , dataProvider = "getContactsTestData" )
		  public void TestCase_005_Shop_Group_NameSearch(String ShopGroupID) throws
		  InterruptedException {
		  
		  
		  shopgroupm.ShopGroupSearch(ShopGroupID); }
		  
		  
		  @DataProvider 
		  public Object[][] getContactsTestData(){ 
			  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME_SEARCH_SHOPGROUPNAME);
			  return data; 
			  }
		  
		 
	
	
	
	
	  

}
