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
	Terminal terminal = new Terminal((WebDriver) driver);
	UserGroupPermission UGP = new UserGroupPermission((WebDriver) driver);
	UserListForSetting ULFS = new UserListForSetting((WebDriver) driver);
	Transactions trns = new Transactions((WebDriver) driver);
	MonthlyReport monthlyreport = new MonthlyReport((WebDriver) driver);
	DailyReport dailyreport = new DailyReport((WebDriver) driver);
	
	
	
	
	@Test(priority=1,enabled=false ) 
	public void TestCase_001_Click_Shop_menu() throws InterruptedException  {
		 
		  shopgroupm.Createshop();
		  shopgroupm.ShopGroupList();
		  shopgroupm.VerifyshopGroupName();
		  
	  }
	
	@Test(priority=2,enabled=false ) 
	public void TestCase_002_Shop_menu() throws InterruptedException  {
		 
		  shopgroupm. GroupDownloadPDF();
		  shopgroupm.GroupDownloadExcel();
	  }
	
	
	 @DataProvider 
	  public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME);
		  return data;
	  }
	  
	  @Test(priority=3, enabled=false,dataProvider = "getContactsTestData")
	  public void TestCase_003_Create_Shop_list(String sid, String tradingname, String rcenter, String propertyid ,String shopid,String grantid,
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
	  
	  
	  @Test(priority=4,enabled=false)
		  public void TestCase_004_shopAdvSearch() {
			  
			  ml.ShopListAdvancedSearch();
			  
		  }
	  
	  
	  @Test(priority=5,enabled=false)
	  public void TestCase_005_shop_Download() {
		  
	      ml.ShopDownloadPDF();
	      ml.ShopDownloadExcel();
		  
	  }
	  
	  
	  @Test(priority=6,enabled=false ) 
	  
	  public void TestCase_006_Terminal() throws InterruptedException  {
	  
		  terminal.CreatTerminal();

	  }
	  
	  
       @Test(priority=7,enabled=false ) 
	   public void TestCase_007_TerminalSearch() throws InterruptedException  {
	  
	   terminal.TerminalAdvancedSearch();
	  
	   }
 
 
       @Test(priority=8,enabled=false ) 
 
       public void TestCase_008_TerminalDownload() throws InterruptedException  {
      
        terminal.TerminalDownloadPDF();
        terminal.TerminalDownloadExcel();
 
       }
 
	  
	  @Test(priority=9, enabled=false)
	  public void TestCase_009_UserGroupPermission() {
		  UGP.CreateInternalUserGroup();
		  UGP.CreatMerchantUserGroup();
		  
	  }
	  
	  
	  @Test(priority=10, enabled=false)
	  public void TestCase_010_UserListForSetting() {
		 ULFS.CreateUserListforMerchant();
		 ULFS.CreateUserListforInternal();
		  
	  }
	  
	  
	  @Test(priority=11, enabled=false)
	  public void TestCase_011_Transactions() {
		  String from = "1";
		 
		  trns.Advancedsearchtransactions();
		  trns.selectDatefrom(from);
		  trns.selectDateto();
		 
	  }
	  
	  @Test(priority=12, enabled=false)
	  public void TestCase_012_TransactionsDownload() {
		  
		  trns.TransactionDownloadPDF();
		  trns.TransactionDownloadExcel();
	  }
	  
	  
	  @Test(priority=13,enabled=false)
	  public void TestCase_013_MonthlyReport() {
		  
		  monthlyreport.ReportMonthly();
		  monthlyreport.ReportDownloadPDF();
		  monthlyreport.ReportDownloadExcel();
		  
		  
		  
		  
	  }
	  
	  
	  @Test(priority=14,enabled=false)
	  public void TestCase_014_DailyReport() throws InterruptedException {
		  
		  dailyreport.ReportDaily();
		  dailyreport.DailyReportSubmitFilter();
		  dailyreport.DailyReportpDownloadPDF();
		  dailyreport.DailyReportDownloadExcel();
	  }
	  
	  
	  
	  
	  
	
	  
	  @Test(priority=15, enabled=false)
	  public void TestCase_015_ShopGroupDelete() {
		  
		  shopgroupm.DeleteGroupname();
		 
	  }
	  
	  @Test(priority=16, enabled=false)
	  public void TestCase_016_ShopListDelete() {
		  
		 ml.DeleteGroupnameforshoplist();
	  }
	  
	  
	 
	  
	  @Test(priority=17, enabled=false)
	  public void TestCase_017_TerminalnotApollo() {
		  
		 terminal.createterminalnotapollo();
		  
		 
	  }
	  
	  @Test(priority=18, enabled=true)
	  public void TestCase_018_PointSchemeShopList() throws AWTException {
		  
		 
		  ml.CreatePointScheme();
		  ml.UpdatePointScheme();
		 
	  }
	  
	  
	  
	  
	
	
	
	
	
	  

}
