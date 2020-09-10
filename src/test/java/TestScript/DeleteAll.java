package TestScript;

import org.openqa.selenium.WebDriver;
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
import VIPqabase.TestBase;

@Listeners({ExtentTestListner.class})
public class DeleteAll  extends TestBase {
	
	
	UserGroupPermission UGP = new UserGroupPermission((WebDriver) driver);
	UserListForSetting ULFS = new UserListForSetting((WebDriver) driver);

	
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	Terminal terminal = new Terminal((WebDriver) driver);
	
	
	
	  @Test(priority=1, enabled=false) public void
	  TestCase_016_UserGroupPermission_Internal() { UGP.CreateInternalUserGroup();
	  
	  }
	  
	  
	  @Test(priority=2, enabled=false) public void
	  TestCase_017_UserGroupPermission_Merchant() {
	  
	  UGP.CreatMerchantUserGroup();
	  
	  }
	  
	  
	  @Test(priority=3, enabled=false) public void
	  TestCase_018_UserListForSetting_CreateMerchant() {
	  ULFS.CreateUserListforMerchant();
	  
	  
	  }
	  
	  
	  @Test(priority=4, enabled=false) public void
	  TestCase_019_UserListForSetting_CreateInternal() {
	  
	  ULFS.CreateUserListforInternal();
	  
	  }
	  
	  
	
	  
	
	  

	  
	  @Test(priority=14, enabled=true)
	  public void TestCase_ShopGroupDelete() {
		  
		  shopgroupm.DeleteGroupname();
		 
	  }
	  
	  @Test(priority=16, enabled=true)
	  public void TestCase_031_ShopListDelete() {
		  
		 ml.DeleteGroupnameforshoplist();
		 ml.DeleteGroupnameforshoplistSeven();
	  }
	  
	  
	  @Test(priority=15, enabled=true)
	  public void TestCase_DeleteTerminal() {
		  
		  terminal.deleteall();
		 
	  }
	  
	  
	  
	  @Test(priority=16, enabled=false)
	  public void TestCase_033_DeleteSetting() {
		  
		  
		 UGP.DeleteusergrouppermissionMerchant();
		UGP.DeleteusergrouppermissionInternal();
		  ULFS.DeleteuserListMerchant();
		  ULFS.DeleteuserListInternal();
	  }
	  

}
