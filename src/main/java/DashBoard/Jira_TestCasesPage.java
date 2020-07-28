package DashBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Util.Helper;
import VIPqabase.TestBase;

public class Jira_TestCasesPage extends TestBase{
	
	public Jira_TestCasesPage(WebDriver driver) {}
	
	public void Test_VSM_218_Update_slip_header1negativevalues()  {
	
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("VSM_218 _Webportal -  Update slip Title, slip header1, slip header2 , slip footer detail on the shop creation/ shop detail updation form - negative values");
		 
		
		
	
	  }
	
	public void selectDatefrom(String date) {
		//transaction date from 
		driver.findElement(By.id("advSearch_Date_txn_date_from")).click();Helper.staticWait(2000);
		WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> noOfColumns = datePicker
				.findElements(By.tagName("td"));
		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();break;}}
	}
	
	public void selectDateto() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date today = new Date();
		String date = formatter.format(today);
		System.out.println(date);
		
		//transaction date to
		driver.findElement(By.id("advSearch_Date_txn_date_to")).click();Helper.staticWait(2000);
		WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> noOfColumns = datePicker
				.findElements(By.tagName("td"));
		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;}}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}