package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.Transactions;
import VIPqabase.TestBase;

public class Transaction extends TestBase{
	
	Transactions trns = new Transactions((WebDriver) driver);
	
	  @Test(priority=1, enabled=true)
	  public void TestCase_022_Transactions() {
	  String from = "1";
	  
	  trns.Advancedsearchtransactions(); 
	  trns.selectDatefrom(from);
	  trns.selectDateto();
	  
	  }
	  
	  @Test(priority=2, enabled=true)
	  public void TestCase_023_TransactionsSearch() {
	  
		  trns.TransactionSearch();
	  }
	  
	  @Test(priority=3, enabled=true)
	  public void TestCase_024_TransactionsDownloadPDF() {
	  
	  trns.TransactionDownloadPDF();
	  
	  }
	  
	  
	  @Test(priority=4, enabled=true) 
	  public void TestCase_025_TransactionsDownloadExcel() {
	  
	  
	  trns.TransactionDownloadExcel(); }
	 

}
