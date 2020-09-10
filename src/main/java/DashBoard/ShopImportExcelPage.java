package DashBoard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Util.ExtentTestManager;
import Util.Helper;
import VIPqabase.TestBase;

public class ShopImportExcelPage extends TestBase {
	
	public ShopImportExcelPage(WebDriver driver) {}
	
	public void CreatShopImportfromExcel() {
		try {
			
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   System.out.println("Veirfy Create Shop Import from Excel..");
			
			  //click again on shop from dashboard for create mew Shop
			   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")));
			   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();
			   Helper.staticWait(2000);
			   //click on Shop List for open new 
			   driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();
			  
			   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='importExcelBtn']")));
			   driver.findElement(By.xpath("//div[@id='importExcelBtn']")).click(); Helper.staticWait(2000);
			  
			  driver.findElement(By.xpath("  //div[@class='input-group-btn input-group-append']"));
			  driver.findElement(By.xpath(" //div[@class='btn btn-primary btn-file']"));
			 
			   WebElement uploadElement =  driver.findElement(By.xpath(" //input[@id='input-b7']"));
			  
			    //uploadElement.sendKeys("C:\\Users\\abhishek.g\\Documents\\import_excel_rate.xls");//Failed Data
			   uploadElement.sendKeys("C:\\Users\\abhishek.g\\Documents\\import_rating_change_of_shops_demo.xls");//Pass Data
			  
			   driver.findElement(By.xpath("  //div[@class='input-group-btn input-group-append']"));
			   driver.findElement(By.xpath("  //a[@class='btn btn-default btn-secondary fileinput-upload fileinput-upload-button']")).click();;Helper.staticWait(5000);
			 
			    WebDriverWait wait = new WebDriverWait(driver,10);
			    
	             try { 
	            	 
				  wait.until(ExpectedConditions.alertIsPresent());
				  driver.switchTo().alert().accept();
				  driver.switchTo().alert().accept();
				  ExtentTestManager.getTest().log(Status.INFO, "alert is present");
				  System.out.println("alert is present");
				  ExtentTestManager.getTest().log(Status.INFO, "Excel file is Not Uploaded because the file data is not correct and it has failed");
				  System.out.println("Excel file is Not Uploaded because the file data is not correct and it has failed");
				  testresultforcolumns();
				  System.out.println("Now Verify the Failed status in Import Excel Audit Log");
				  ExtentTestManager.getTest().log(Status.INFO, "Now Verify the Failed status in Import Excel Audit Log");
				  auditlogverifytestforFailure();
				     }
				  catch(Exception e)  
				  { 
					  System.out.println("alert was not present");
					  ExtentTestManager.getTest().log(Status.INFO, "alert was not present");
					  System.out.println("excel file is uploaded successfully");
					  ExtentTestManager.getTest().log(Status.INFO, "excel file is uploaded successfully");
					  System.out.print(e);
					  testresultforcolumns();
					  System.out.println("Now Verify the Success status in Import Excel Audit Log");
					  ExtentTestManager.getTest().log(Status.INFO, "Now Verify the Success status in Import Excel Audit Log");
					  auditlogverifytestforSuccess(); 
					  
				  }
				  
	         }
			
			   catch(Exception e) { e.printStackTrace();	}
	}
	
	
	public void  verificationnofrows() {
		   System.out.println(" Veirfy import excel process no of passed and failure count Counting the no of rows result..");
		   String innerText = driver.findElement(By.xpath("//*[@id=\"example0\"]/thead/tr/th[5]")).getText(); 	
			        System.out.println(innerText); 
			        
			        List  rows = driver.findElements(By.xpath("//*[@id=\"example0\"]/tbody/tr/td[5]")); 
			        System.out.println("No of rows for Result Column are : " + rows.size());
		
	}
	
	
	public void  verificationresultpassfail() {
			      //To locate table.
			    	WebElement mytable = driver.findElement(By.xpath("//*[@id=\"example0\"]/tbody"));
			    	//To locate rows of table. 
			    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
			    	//To calculate no of rows In table.
			    	int rows_count = rows_table.size();
			    	//Loop will execute till the last row of table.
			    	for(int row =0; row<rows_count;row++) {
			    		//To locate columns(cells) of that specific row.
			    		List <WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			    		//To calculate no of columns (cells). In that specific row.
			    		int columns_count = Columns_row.size();
			    		System.out.println("Number of column  In Row " + row + " are " + columns_count);
			    		//Loop will execute till the last cell of that specific row.
			    		for (int column = 0; column < columns_count; column++) {
			    			// To retrieve text from that specific cell.
			    			 String celtext = Columns_row.get(column).getText();
			    			 System.out.println("column  Value of row number " + row + " and column number " + column + " Is " + celtext);
			    			 System.out.println("-------------------------------------------------- ");
			    	    }
			    		}
 			    	}
	public void verificationimportexcelprocessAllColumnsandrows()  {
		
		 // Grab the table 
		  WebElement table = driver.findElement(By.xpath("//*[@id=\"example0\"]/tbody"));
		  
		  //Get number of rows in table 
		  int numOfRow = table.findElements(By.tagName("tr")).size(); 
		  
		  //Get number of columns In table.
		  int numOfCol = driver.findElements(By.xpath("//*[@id=\"example0\"]/tbody/tr[1]/td")).size();
		  
		  //divided Xpath In three parts to pass Row_count and Col_count values.
		  String first_part = "//*[@id=\"example0\"]/tbody/tr[";
		  String second_part = "]/td[";
		  String third_part = "]";
		  
		//take the fifth column values
		  int j=5;
		  
		  //List to store the second column
		  List<String> fifthColumnList=new ArrayList<String>();
		  
		  //Loop through the rows and get the second column and put it in a list
		  for (int i=1; i<=numOfRow; i++){
			 
			  //Prepared final xpath of specific cell as per values of i and j.
			  
		       String final_xpath = first_part+i+second_part+j+third_part;
		       //Will retrieve value from located cell and print It.
		       String test_name = driver.findElement(By.xpath(final_xpath)).getText();
		       
		       fifthColumnList.add(test_name);  
		       System.out.println(test_name);
		       
		       if(test_name.contains("Failure")) {
		    	   
		   		   System.out.println("The total Failure row count is." + i);  
		   		
		    	} 
		  } 

	}
	
	
	public static void testresultforcolumns() {
		try {
	String result;
	int countFailure =0;
	int countSuccess = 0;
		  
		  //Get number of columns In table.
		List<WebElement>  col = driver.findElements(By.xpath("//*[@id=\"example0\"]/tbody/tr/td[5]"));
		System.out.println("Total no. of columns are :" +col.size());
		ExtentTestManager.getTest().log(Status.INFO, "Total no. of columns are :" + col.size());
		int columns_count = col.size();
		//No.of rows
		
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id=\"example0\"]/tbody/tr"));
		System.out.println("Total no. of rows are :" +rows.size());
		ExtentTestManager.getTest().log(Status.INFO, "Total no. of rows are :" + rows.size());
		
		for(int column  =0; column < columns_count; column++) {
			
			String textcell = col.get(column).getText();
		   System.out.println("column Value of row " + textcell );
			if(textcell.contains("Failure")) {
				countFailure++;
				textcell = textcell.substring(textcell.indexOf("Failure") + "Failure".length());
			}
			
			else if(textcell.contains("Success")) {
				countSuccess++;
				textcell = textcell.substring(textcell.indexOf("Success") + "Success".length());
			}
			 System.out.println("column Value Total Failure.. " +  countFailure);
			 ExtentTestManager.getTest().log(Status.INFO, "Total no. Failure.. :" +  countFailure);
			 System.out.println("column Value Total Success.. " + countSuccess);
			 ExtentTestManager.getTest().log(Status.INFO, "Total no. of Success.. " +  countSuccess);
	}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	
	public static void  auditlogverifytestforFailure() {
		
		SoftAssert softassert = new SoftAssert();
		
		System.out.println("import excel audit log - verify the testcase  file is added to the log = result status=Failure");
		 ExtentTestManager.getTest().log(Status.INFO, "import excel audit log - file is added to the log = result status=Failure");
		driver.findElement(By.xpath(" //a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Audit Log')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Import Excel Audit Log')]")).click();Helper.staticWait(3000);
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[contains(text(),'Date')]")));
		   driver.findElement(By.xpath("//th[contains(text(),'Date')]")).click();Helper.staticWait(3000);
		   driver.findElement(By.xpath("//th[contains(text(),'Date')]")).click();Helper.staticWait(3000);
		   
		  String mes =  driver.findElement(By.xpath("//tr[1]//td[3]")).getText();
		  String  actual ="Failure";System.out.println(mes); ExtentTestManager.getTest().log(Status.INFO, "import excel audit log - verify the =" + mes);
		  softassert.assertEquals(actual, mes);
		   
		
	}
	
	
public static void  auditlogverifytestforSuccess() {
		
		SoftAssert softassert = new SoftAssert();
		
		System.out.println("import excel audit log - verify the testcase file is added to the log = result status =Success");
		ExtentTestManager.getTest().log(Status.INFO, "import excel audit log - verify the testcase -1 xls file is added to the log = result  = testcase1  status =Success");
		driver.findElement(By.xpath(" //a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Audit Log')]")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Import Excel Audit Log')]")).click();Helper.staticWait(3000);
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[contains(text(),'Date')]")));
		   driver.findElement(By.xpath("//th[contains(text(),'Date')]")).click();Helper.staticWait(3000);
		   driver.findElement(By.xpath("//th[contains(text(),'Date')]")).click();Helper.staticWait(3000);
		   
		  String mes =  driver.findElement(By.xpath("//tr[1]//td[3]")).getText();
		  String  actual ="Success";System.out.println(mes);ExtentTestManager.getTest().log(Status.INFO, "import excel audit log - verify the =" + mes);
		  softassert.assertEquals(actual, mes);
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

		
	
	
	


