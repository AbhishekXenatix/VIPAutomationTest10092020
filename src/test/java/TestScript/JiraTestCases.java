package TestScript;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DashBoard.Jira_TestCasesPage;
import Util.ExtentTestListner;

import VIPqabase.TestBase;

@Listeners({ExtentTestListner.class})
public class JiraTestCases extends TestBase{
	
	Jira_TestCasesPage jiratestcasespage = new Jira_TestCasesPage((WebDriver) driver);
	
	
	@Test(priority=1,enabled=true ) 
	public void TestCase_001_VSM_218_Update_slip_header1negativevalues()  {
		
		jiratestcasespage.Test_VSM_218_Update_slip_header1negativevalues();
		
		
		
	  }
	

}
