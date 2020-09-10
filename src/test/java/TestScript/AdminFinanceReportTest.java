package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.AdminFinanceReport;
import VIPqabase.TestBase;

public class AdminFinanceReportTest extends TestBase{
	
	
	AdminFinanceReport adminfinancereport = new AdminFinanceReport((WebDriver) driver);
	
	
	
	
	 @Test(priority=1,enabled=true)
	  public void TestCase_035_AdminFinanceReportMonthly() throws InterruptedException {
		  
		 adminfinancereport.AdminFinanceReportMonthly();
		
	  }
	 
	 @Test(priority=2,enabled=true)
	  public void TestCase_036_AdminFinanceReportMonthlySearch() throws InterruptedException {
		  
		 adminfinancereport.AdminFinanceReportMonthlySearch();
		
	  }
	
	 
	 @Test(priority=3,enabled=true)
	  public void TestCase_037_AdminFinanceReportMonthlyDownloadExcel() throws InterruptedException {
		  
		  
		 adminfinancereport.AdminFinanceReportMonthlyDownloadExcel();
	  }
	
	 
	 @Test(priority=4,enabled=true)
	  public void TestCase_038_AdminFinanceReportMonthlyDownloadPDF() throws InterruptedException {
		  
		  
		 adminfinancereport.AdminFinanceReportMonthlyDownloadPDF();
	  }
	
	 
	 @Test(priority=5,enabled=true)
	  public void TestCase_039_AdminFinanceReportMonthlyExportData() throws InterruptedException {
		  
		 adminfinancereport.AdminFinanceReportMonthlyExportRawData();
		
	  }
	
	//######################################################################Admin Finance Daily Report ###############################################################
	
	 @Test(priority=5,enabled=true)
	  public void TestCase_040_AdminFinanceReportDailyExportData() throws InterruptedException {
		  
		 adminfinancereport.AdminFinanceDailyReport();
		
	  }
	 
	 @Test(priority=6,enabled=true)
	  public void TestCase_041_AdminFinanceReportDailyExportData() throws InterruptedException {
		  
		 
		 adminfinancereport.AdminFinanceDailyReportSearch();
	  }

	 
	 @Test(priority=7,enabled=true)
	  public void TestCase_042_AdminFinanceReportDailyExportData() throws InterruptedException {
		  
		 adminfinancereport.AdminFinanceDailyReportDownloadPDF();
		
	  }

	 
	 @Test(priority=8,enabled=true)
	  public void TestCase_043_AdminFinanceReportDailyExportData() throws InterruptedException {
		  
		 
		 adminfinancereport.AdminFinanceDailyReportExcel();
	  }

	 
	 @Test(priority=9,enabled=true)
	  public void TestCase_044_AdminFinanceReportDailyExportData() throws InterruptedException {
		  
		 
		 adminfinancereport.AdminFinanceDailyReportExportRawData();
	  }


	 
	 
	 
	 
	 
	 //################################################# Monthly Statement Report	 ###################################################################################################################
	 
	 
	 @Test(priority=10,enabled=true)
	  public void TestCase_045_MonthlyStatementReport() throws InterruptedException {
		  
		 adminfinancereport.MonthlyStatementReport();
		
	  }
	 
	 @Test(priority=11,enabled=true)
	  public void TestCase_046_MonthlyStatementReportSearch() throws InterruptedException {
		  
		 adminfinancereport.MonthlyStatementReportSearch();
		
	  }
	 
	 @Test(priority=12,enabled=true)
	  public void TestCase_047_MonthlyStatementReportDownloadPDF() throws InterruptedException {
		  
		 
		 adminfinancereport.MonthlyStatementReportDownloadPDF();
	  }
	 
	 @Test(priority=13,enabled=true)
	  public void TestCase_048_MonthlyStatementReportDownloadExcel() throws InterruptedException {
		  
		 adminfinancereport.MonthlyStatementReportDownloadExcel();
		
	  }
	 
	 @Test(priority=14,enabled=true)
	  public void TestCase_049_MonthlyStatementReportRawData() throws InterruptedException {
		  
		 adminfinancereport.MonthlyStatementReportRawData();
		
	  }

	 
	 
	 
	 
	 
}
