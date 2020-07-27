package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DashBoard.Terminal;
import Util.ExtentTestListner;
import VIPqabase.TestBase;

@Listeners({ExtentTestListner.class})
public class RegressionTestTwo extends TestBase{
	
	Terminal terminal = new Terminal((WebDriver) driver);
	
	
	
  @Test(priority=01,enabled=true ) 
	  
	  public void TestCase_012_CreateTerminal() throws InterruptedException  {
	  
		  terminal.CreatTerminal();

	  }
	  
	  
       @Test(priority=02,enabled=true ) 
	   public void TestCase_013_TerminalSearch() throws InterruptedException  {
	  
	   terminal.TerminalAdvancedSearch();
	  
	   }
 
 
       @Test(priority=03,enabled=true ) 
 
       public void TestCase_014_TerminalDownloadPDF() throws InterruptedException  {
      
        terminal.TerminalDownloadPDF();
 
       }
       
       @Test(priority=04,enabled=true ) 
       
       public void TestCase_015_TerminalDownloadExcel() throws InterruptedException  {
      
        
        terminal.TerminalDownloadExcel();
 
       }
       
       
       @Test(priority=05, enabled=false)
 	  public void TestCase_029_TerminalnotApollo() {
 		  
 		 terminal.createterminalnotapollo();
 		  
 		 
 	  }
 	  

}
