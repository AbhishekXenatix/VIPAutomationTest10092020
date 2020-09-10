package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.MerchantProfile;
import VIPqabase.TestBase;

public class MerchantTest extends TestBase{
	
	MerchantProfile merchantprofile = new MerchantProfile((WebDriver) driver);
	

		
		 @Test(priority=1,enabled=true)
		  public void TestCase_50_CreateMerchantProfile() throws InterruptedException {
			  
			 merchantprofile.CreateMerchant();
			
		  }
		 
		 @Test(priority=2,enabled=true)
		  public void TestCase_51_CreateMerchantProfileDownloadExcel() throws InterruptedException {
			  
			 merchantprofile.MerchantDownloadExcel();
			
		  }
		 
		 
		 @Test(priority=3,enabled=true)
		  public void TestCase_52_CreateMerchantProfileDownloadPDF() throws InterruptedException {
			  
			 merchantprofile.MerchantDownloadPDF();
			
		  }
		 
		
		
		
		 
		 @Test(priority=4,enabled=true)
		  public void TestCase_53_CreateMerchantProfileMerchantSearch() throws InterruptedException {
			  
			 merchantprofile.MerchantSearch();
			
		  }
		 
		 @Test(priority=5,enabled=true)
		  public void TestCase_54_CreateMerchantProfileAdvancedSearch() throws InterruptedException {
			  
			 merchantprofile.MerchantAdvancedSearch();
			
		  }
		 
	

}
