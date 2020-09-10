package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.DailyReport;
import DashBoard.MonthlyReport;
import VIPqabase.TestBase;

public class Reports extends TestBase{
	
	MonthlyReport monthlyreport = new MonthlyReport((WebDriver) driver);
	DailyReport dailyreport = new DailyReport((WebDriver) driver);
	
	
	  
	  @Test(priority=1,enabled=true)
	  public void TestCase_025_MonthlyReport() {
		  
		  monthlyreport.ReportMonthly();
		 
		    
	  }
	  
	  
	  @Test(priority=2,enabled=true)
	  public void TestCase_026_MonthlyReportSearch() {
		  
		  monthlyreport.MonthlyReportSearch();
		    
	  }
	  
	  
	  @Test(priority=3,enabled=true)
	  public void TestCase_027_MonthlyReportPDF() {
		  
		
		  monthlyreport.ReportDownloadPDF();
		 
		    
	  }
	  
	  
	  
	  @Test(priority=4,enabled=true)
	  public void TestCase_028_MonthlyReportExcel() {
		  
		  monthlyreport.ReportDownloadExcel();
		    
	  }
	  
	  @Test(priority=5,enabled=true)
	  public void TestCase_029_MonthlyReportExportData() {
		  
		  monthlyreport.MonthlyReportExportRawData();
		    
	  }
	  
	  
	  
	  
	  
	 
	  
	  //########################################################################Daily Report###############################################################################
	  
	  
	  
	  
	  
	  @Test(priority=6,enabled=true)
	  public void TestCase_030_DailyReport() throws InterruptedException {
		  
		  dailyreport.ReportDaily();
		  dailyreport.DailyReportShopGroupFilter();
		  dailyreport.DailyReportCardTierFilter();
		 
	  }
	  
	  @Test(priority=7,enabled=true)
	  public void TestCase_031_DailyReportsearch() throws InterruptedException {
		  
		  
		
		  dailyreport.DailyReportSearch();
	  }
	  
	  @Test(priority=8,enabled=true)
	  public void TestCase_032_DailyReportPDF() throws InterruptedException {
		  
		
		  dailyreport.DailyReportpDownloadPDF();
		 
	  }
	  
	  
	  
	  @Test(priority=9,enabled=true)
	  public void TestCase_033_DailyReportExcel() throws InterruptedException {
		  
		  
		
		  dailyreport.DailyReportDownloadExcel();
	  }
	  
	  
	  @Test(priority=10,enabled=true)
	  public void TestCase_034_DailyReportExportRawData() throws InterruptedException {
		  
		  
		
		  dailyreport.DailyReportExportRawData();
	  }
	  

}
