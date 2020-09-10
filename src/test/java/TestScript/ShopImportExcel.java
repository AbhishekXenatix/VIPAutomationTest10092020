package TestScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.ShopImportExcelPage;
import VIPqabase.TestBase;

public class ShopImportExcel  extends TestBase{
	ShopImportExcelPage shopimportexcelpage = new ShopImportExcelPage((WebDriver) driver);
	
	 @Test(priority=1, enabled=true)
	  public void TestCase_014_ShopImportExcel() {
	
		 shopimportexcelpage.CreatShopImportfromExcel();
		// shopimportexcelpage.verificationnofrows();
		// shopimportexcelpage.verificationresultpassfail();
		 //shopimportexcelpage.verificationimportexcelprocessAllColumnsandrows();
		//shopimportexcelpage.testresultforcolumns();
	  }

}
