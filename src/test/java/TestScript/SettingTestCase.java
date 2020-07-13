package TestScript;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DashBoard.MerchanList;
import DashBoard.ShopGroupManagement;
import DashBoard.Terminal;
import DashBoard.Transactions;
import DashBoard.UserGroupPermission;
import DashBoard.UserListForSetting;
import Util.ExtentTestListner;
import VIPqabase.TestBase;


@Listeners({ExtentTestListner.class})
public class SettingTestCase extends TestBase{
	
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	Terminal terminal = new Terminal((WebDriver) driver);
	UserGroupPermission UGP = new UserGroupPermission((WebDriver) driver);
	UserListForSetting ULFS = new UserListForSetting((WebDriver) driver);
	Transactions trns = new Transactions((WebDriver) driver);
	
	  
	  @Test(priority=1, enabled=false)
	  public void TestCase_001_UserGroupPermission() {
		  UGP.CreateInternalUserGroup();
		  UGP.CreatMerchantUserGroup();
		  
	  }
	  
	  
	  @Test(priority=2, enabled=false)
	  public void TestCase_002_UserListForSetting() {
		 ULFS.CreateUserListforMerchant();
		 ULFS.CreateUserListforInternal();
		  
	  }
	  
	  
	  @Test(priority=3, enabled=false)
	  public void TestCase_003_Transactions() {
		  String from = "1";
		 
		  trns.Advancedsearchtransactions();
		  trns.selectDatefrom(from);
		  trns.selectDateto();
		  trns.TransactionDownloadPDF();
		  trns.TransactionDownloadExcel();
	  }

	  
	  
	  
	  
	  
	  

}
