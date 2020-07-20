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
		SoftAssert softAssert = new SoftAssert();
		 String from = "1";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("VSM_218 _Webportal -  Update slip Title, slip header1, slip header2 , slip footer detail on the shop creation/ shop detail updation form - negative values");
		 
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[4]/a")).click();Helper.staticWait(10000);
		
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		
		//transaction id 
		WebElement  transid = driver.findElement(By.id("advSearch_txn_id"));
		transid.sendKeys("!!!!!@@@@@");;Helper.staticWait(2000);
		selectDatefrom(from);
		selectDateto();
		WebElement search  =  driver.findElement(By.id("advSearch_Search"));search.click();Helper.staticWait(5000);
		
		WebElement ames = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td"));
		ames.getText();
		String emes = "No data available in table";
		softAssert.assertEquals(emes, ames);
		
		
		//Card no.
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		transid.clear();
		WebElement cardno = driver.findElement(By.id("advSearch_card_no"));
		cardno.sendKeys("!!!!!!!!");search.click();Helper.staticWait(5000);
		softAssert.assertEquals(emes, ames);
		
		//Batch no.
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		transid.clear();cardno.clear();
		WebElement batchno = driver.findElement(By.id("advSearch_batch_no"));
		batchno.sendKeys("!!!!!!!!");search.click();Helper.staticWait(5000);
		softAssert.assertEquals(emes, ames);
		
		
		//trace no.
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		transid.clear();cardno.clear();batchno.clear();
		WebElement traceno = driver.findElement(By.id("advSearch_trace_no"));
		traceno.sendKeys("!!!!!!!!");search.click();Helper.staticWait(5000);
		softAssert.assertEquals(emes, ames);
		
		
		//refer trace
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(2000);
		transid.clear();cardno.clear();batchno.clear();traceno.clear();
		WebElement refertrace = driver.findElement(By.id("advSearch_refer_trace_no"));
		refertrace.sendKeys("!!!!!!!!");search.click();Helper.staticWait(5000);
		softAssert.assertEquals(emes, ames);
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