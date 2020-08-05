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
public class RegressionTestThree  extends TestBase {
	
	
	UserGroupPermission UGP = new UserGroupPermission((WebDriver) driver);
	UserListForSetting ULFS = new UserListForSetting((WebDriver) driver);
	Transactions trns = new Transactions((WebDriver) driver);
	MonthlyReport monthlyreport = new MonthlyReport((WebDriver) driver);
	DailyReport dailyreport = new DailyReport((WebDriver) driver);
	MerchanList ml = new MerchanList((WebDriver) driver);
	ShopGroupManagement shopgroupm = new ShopGroupManagement((WebDriver) driver);
	Terminal terminal = new Terminal((WebDriver) driver);
	
	
	
	  @Test(priority=1, enabled=true) public void
	  TestCase_016_UserGroupPermission_Internal() { UGP.CreateInternalUserGroup();
	  
	  }
	  
	  
	  @Test(priority=2, enabled=true) public void
	  TestCase_017_UserGroupPermission_Merchant() {
	  
	  UGP.CreatMerchantUserGroup();
	  
	  }
	  
	  
	  @Test(priority=3, enabled=true) public void
	  TestCase_018_UserListForSetting_CreateMerchant() {
	  ULFS.CreateUserListforMerchant();
	  
	  
	  }
	  
	  
	  @Test(priority=4, enabled=true) public void
	  TestCase_019_UserListForSetting_CreateInternal() {
	  
	  ULFS.CreateUserListforInternal();
	  
	  }
	  
	  
	  
	  @Test(priority=5, enabled=true) public void TestCase_020_Transactions() {
	  String from = "1";
	  
	  trns.Advancedsearchtransactions(); trns.selectDatefrom(from);
	  trns.selectDateto();
	  
	  }
	  
	  @Test(priority=6, enabled=true) public void
	  TestCase_021_TransactionsDownloadPDF() {
	  
	  trns.TransactionDownloadPDF();
	  
	  }
	  
	  
	  @Test(priority=7, enabled=true) public void
	  TestCase_022_TransactionsDownloadExcel() {
	  
	  
	  trns.TransactionDownloadExcel(); }
	 
	  
	  
	  @Test(priority=8,enabled=true)
	  public void TestCase_023_MonthlyReport() {
		  
		  monthlyreport.ReportMonthly();
		 
		    
	  }
	  
	  
	  @Test(priority=9,enabled=false)
	  public void TestCase_024_MonthlyReportPDF() {
		  
		
		  monthlyreport.ReportDownloadPDF();
		 
		    
	  }
	  
	  
	  
	  @Test(priority=10,enabled=false)
	  public void TestCase_025_MonthlyReportExcel() {
		  
		  monthlyreport.ReportDownloadExcel();
		    
	  }
	  
	  
	  
	  @Test(priority=11,enabled=false)
	  public void TestCase_026_DailyReport() throws InterruptedException {
		  
		  dailyreport.ReportDaily();
		  dailyreport.DailyReportShopGroupFilter();
		  dailyreport.DailyReportCardTierFilter();
		 
	  }
	  
	  @Test(priority=12,enabled=false)
	  public void TestCase_027_DailyReportPDF() throws InterruptedException {
		  
		
		  dailyreport.DailyReportpDownloadPDF();
		 
	  }
	  
	  
	  
	  @Test(priority=13,enabled=false)
	  public void TestCase_028_DailyReportExcel() throws InterruptedException {
		  
		  
		
		  dailyreport.DailyReportDownloadExcel();
	  }
	  
	  
	  
	  
	
	  
	  
	  
	
	  
	  @Test(priority=14, enabled=true)
	  public void TestCase_030_ShopGroupDelete() {
		  
		  shopgroupm.DeleteGroupname();
		 
	  }
	  
	  @Test(priority=15, enabled=true)
	  public void TestCase_031_ShopListDelete() {
		  
		 ml.DeleteGroupnameforshoplist();
		 ml.DeleteGroupnameforshoplistSeven();
	  }
	  
	  
	  @Test(priority=16, enabled=true)
	  public void TestCase_032_DeleteOthers() {
		  
		  terminal.deleteall();
		 
	  }
	  
	  
	  
	  @Test(priority=16, enabled=true)
	  public void TestCase_033_DeleteSetting() {
		  
		  
		 UGP.DeleteusergrouppermissionMerchant();
		UGP.DeleteusergrouppermissionInternal();
		  ULFS.DeleteuserListMerchant();
		  ULFS.DeleteuserListInternal();
	  }
	  

}
