package DashBoard;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Util.Helper;
import Util.PropertyFileReader;
import VIPqabase.TestBase;

public class Transactions extends TestBase {
	Helper helper = new Helper();
	PropertyFileReader pfr = new PropertyFileReader();
	
	public Transactions(WebDriver driver) {}
	
	
	public void Advancedsearchtransactions() {
		try {
		System.out.println("Advanced Search for Transactions..");
		
		//click on Transactions button from dashboard
		driver.findElement(By.xpath("//a[contains(text(),'Transactions')]")).click();Helper.staticWait(5000);
		
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(3000);
		
		//message type 
		
		WebElement elementmessagetypetransactions = driver.findElement(By.id("advSearch_Select_message_type"));
		elementmessagetypetransactions.click();Helper.staticWait(3000);
		
     	Select select = new Select(elementmessagetypetransactions); 
     	
		 List<WebElement> dropdownmessagetypetransactions= select.getOptions();
		 for(int i=0;i<dropdownmessagetypetransactions.size();i++){
			 String drop_down_messagetypetransactions=dropdownmessagetypetransactions.get(i).getText();
			 System.out.println("dropdown values are " + drop_down_messagetypetransactions);  }
		         select.selectByVisibleText("Sales");Helper.staticWait(3000);
	
		
		       //Card Tier
		         
		         WebElement elementcardtier = driver.findElement(By.id("advSearch_Select_MEMBER_TIER"));
		         elementcardtier.click();Helper.staticWait(3000);
		 		
		      	Select cselect = new Select(elementcardtier); 
		      	
		 		 List<WebElement> dropdowncardtier = cselect.getOptions();
		 		 for(int i=0;i<dropdowncardtier.size();i++){
		 			 String drop_down_cardtier = dropdowncardtier.get(i).getText();
		 			 System.out.println("dropdown values are " + drop_down_cardtier);  }
		 		         cselect.selectByVisibleText("GOLD");Helper.staticWait(3000);
		 		         
		 		         
		 		        
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		         
		         
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
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}

	}
	
	
	public void selectDateto() {
		 SimpleDateFormat formatter = new SimpleDateFormat("d");
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
				break;
			}
		}
		
		 driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(15000);

	}
	
	
	public void TransactionSearch() {
		try {
		
		System.out.println(" Search for Transactions..");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement Trasearch =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		 
		  Trasearch.sendKeys(pfr.getTransID());Helper.staticWait(2000);
		  
		  
		  //Trasearch.sendKeys("200559");Helper.staticWait(2000);
		WebElement eleTransID = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[3]"));
		String mesTrans = eleTransID.getText();System.out.println(mesTrans);
		Assert.assertEquals("200559", mesTrans);Helper.staticWait(5000);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	

	
	
	
	
	
	
	
	public void TransactionDownloadPDF() {
		try {
		String name = "TRANSACTION RECORD.pdf";
		 String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Transaction menu
		//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[4]/a")).click();Helper.staticWait(3000);
		//Transaction 
		
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(3000);
		
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");

		System.out.println("PDF downloaded for Transactions..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public void TransactionDownloadExcel() {
		try {
		String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
		String name = "TRANSACTION RECORD.xlsx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Transaction menu
		//driver.findElement(By.xpath("//*[@id=\\\"panel-menu\\\"]/ul/li[4]/a")).click();Helper.staticWait(3000);
		//Transaction 
		
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(3000);
		File getLatestFile = Helper.getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    Assert.assertTrue(fileName.equalsIgnoreCase(name), "Downloaded file name is not matching with expected file name");
		
	    System.out.println("Excel downloaded for Transactions..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}

	
	
	
	
	

}
