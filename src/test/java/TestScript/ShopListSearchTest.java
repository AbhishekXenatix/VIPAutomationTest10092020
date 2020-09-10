package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DashBoard.ShopListSearch;
import Util.Helper;
import VIPqabase.TestBase;




public class ShopListSearchTest extends TestBase{
	
	ShopListSearch shoplistsearchtest = new ShopListSearch((WebDriver) driver);
	
	
	
	@DataProvider 
	public Object[][] getContactsTestData(){ 
		  Object data[][] = Helper.getTestData(Helper.CONTACT_SHEET_NAME_SEARCH_SHOPLIST);
		  return data;
	}
	
	 @Test(priority=1, enabled=true,dataProvider = "getContactsTestData")
	  public void TestCase_015_ShopListSearchSID(String SID, String ShopID , String PropertyID, String GrantID) {
	
		 shoplistsearchtest.SIDsearch(SID);
		 shoplistsearchtest.ShopIDsearch(ShopID);
		 shoplistsearchtest.PropertyIDsearch(PropertyID);
		 shoplistsearchtest.GrantIDsearch(GrantID);
	  }
	 
	 
		
		  
		

}
