package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DashBoard.Terminal;
import VIPqabase.TestBase;

public class TerminalTest extends TestBase {
	
	
	Terminal terminal = new Terminal((WebDriver) driver);
	
	
	  @Test(priority=1,enabled=true ) 
	  
	  public void TestCase_016_PortallogonAuditLog() throws InterruptedException  {
	 
	   
	   terminal.PortalLoginAudit();

	  }

	
	  
@Test(priority=2,enabled=true ) 
	  
	  public void TestCase_017_CreateTerminal() throws InterruptedException  {
	  
		  terminal.CreatTerminal();

	  }
	  
	  
     @Test(priority=3,enabled=true ) 
	   public void TestCase_018_TerminalAdvancedSearch() throws InterruptedException  {
	  
	   terminal.TerminalAdvancedSearch();
	  
	   }


     @Test(priority=4,enabled=true ) 

     public void TestCase_019_TerminalDownloadPDF() throws InterruptedException  {
    
      terminal.TerminalDownloadPDF();

     }
     
     @Test(priority=5,enabled=true ) 
     
     public void TestCase_020_TerminalDownloadExcel() throws InterruptedException  {
    
      
      terminal.TerminalDownloadExcel();

     }
     
     
  @Test(priority=6,enabled=true ) 
     
     public void TestCase_021_TerminalSearch() throws InterruptedException  {
    
      
      terminal.Terminalsearch();

     }
   
	  
	 

	 
	  

}
