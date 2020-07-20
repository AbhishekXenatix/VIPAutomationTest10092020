package DashBoard;

import java.util.concurrent.TimeUnit;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import Util.ExtentTestManager;

import Util.Helper;
import VIPqabase.TestBase;

public class ShopGroupManagement extends TestBase {
	static SoftAssert softAssertion= new SoftAssert();
	public static String downloadPath = "C:\\Users\\abhishek.g\\Downloads";
	 Helper helper = new Helper();
	 public static Logger log = LogManager.getLogger(ShopGroupManagement.class.getName());
	
	
	
	
	public ShopGroupManagement(WebDriver driver) {}
	
	
	public void Createshop() throws InterruptedException {

		
		log.info("Create Shop Group ..");
		//click on shop for open group management 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();
		 ExtentTestManager.getTest().log(Status.INFO, "Hellooo started Test Case 1");
		 
		  

	}

	public  void ShopGroupList() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on shop group management option 
		WebElement SGM = driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[2]/a"));
		SGM.click();
		 ExtentTestManager.getTest().log(Status.INFO, "Shop Group created"); 
		 ExtentTestManager.getTest().log(Status.INFO, "Shop menu clicked..");
		 Helper.staticWait(3000);
		
		
	}
	
	public static void ShopGroupListPositive() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebElement NewItem = driver.findElement(By.id("newItemMain"));
		NewItem.click(); ExtentTestManager.getTest().log(Status.INFO, "Clicked on New Item Button..");
		Helper.staticWait(3000);
		
		WebElement ShopGroupID = driver.findElement(By.id("genDetail_SHOP_GROUP_ID"));
		ShopGroupID.sendKeys("Auto");
		Helper.staticWait(3000);
		
		WebElement ShopGroupName = driver.findElement(By.id("genDetail_SHOP_GROUP_NAME"));
		ShopGroupName.sendKeys("MOKO");
		Helper.staticWait(3000);
		
		WebElement Active = driver.findElement(By.id("genDetail_ACTIVED"));
		Active.click();
		Helper.staticWait(3000);
		
		WebElement selectactive = driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]"));
		selectactive.click();
		Helper.staticWait(3000);
		
		WebElement Description = driver.findElement(By.id("genDetail_DESCRIPTION"));
		Description.sendKeys("This is created by Automation..");
		Helper.staticWait(3000);
		
		WebElement Comments = driver.findElement(By.id("genDetail_COMMENTS"));
		Comments.sendKeys("shop group id created..");
		Helper.staticWait(2000);
		
		WebElement save = driver.findElement(By.id("sliderBtnSaveNew"));
		save.click();
		Helper.staticWait(5000);
		
		
		/*
		 * WebElement errorMessage =
		 * driver.findElement(By.xpath("//*[@id=\"slider_1\"]/div/div[1]/div[2]/div"));
		 * String s2 = errorMessage.getText(); System.out.println(s2); String s3 =
		 * "Duplicate record: You have entered that already exists.";
		 * softAssertion.assertEquals(s2, s3);
		 * ExtentTestManager.getTest().log(Status.INFO,
		 * "Shop Group created with all positive valuess");
		 */
		
		System.out.println("Shop Group is created ..");
	
		
	
		
	}
	
	
	public void VerifyshopGroupName() throws InterruptedException  {
		
		String groupnamegiven="MOKO";
		String nodata ="No data available in table";

		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		try {
		
		//driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[2]/a")).click();
		
		
		  WebElement AdvSearch = driver.findElement(By.id("advSearchBtn"));
		  AdvSearch.click(); Helper.staticWait(3000);
		  
		  driver.findElement(By.id("advSearch_Select_active")).click();
		  driver.findElement(By.xpath("//*[@id=\"advSearch_Select_active\"]/option[2]") ).click();
		  
		  WebElement GroupNameSearch =
		  driver.findElement(By.id("advSearch_group_name"));
		  GroupNameSearch.sendKeys("MOKO"); Helper.staticWait(3000);
		  
		  WebElement GroupSearch =driver.findElement(By.id("advSearch_Search"));
		  GroupSearch.click(); Helper.staticWait(3000);
		
		WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td"));
			System.out.println((searchresult).getText());
			if(((searchresult).getText().equalsIgnoreCase(nodata))) {
				System.out.println("Create a new group");
				ShopGroupListPositive();
	
			} else {
				
				
				System.out.println("Already have MOKO group..");
			
			
		}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public void DeleteGroupname() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		//shop group management 
		driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		//click on Advance search 
		driver.findElement(By.id("advSearchBtn")).click();Helper.staticWait(3000);
		//enter value in group name search 
		
		WebElement result = driver.findElement(By.id("advSearch_group_name"));
		result.sendKeys("MOKO");
	
		driver.findElement(By.id("advSearch_Search")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@type='checkbox' and @name='id[]']")).click();Helper.staticWait(3000);
		driver.findElement(By.id("deleteBtn")).click();Helper.staticWait(3000);
		driver.findElement(By.id("YESDele")).click();Helper.staticWait(3000);
	}
	
	
	public void GroupDownloadPDF() {
		String name = "Shop Group List Record.pdf";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		//shop group management 
		driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[1]")).click();Helper.staticWait(3000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, name), "Failed to download Expected document");
		
		System.out.println("Group PDF downloaded..");
	}
	
	
	public void GroupDownloadExcel() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//shop menu
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		//shop group management 
		driver.findElement(By.xpath("//*[@id=\"mm-1\"]/ul/li[2]/a")).click();Helper.staticWait(3000);
		driver.findElement(By.xpath("//*[@id=\"table_main_wrapper\"]/div[2]/button[2]")).click();Helper.staticWait(3000);
	    Assert.assertTrue(helper.isFileDownloaded(downloadPath, "Shop Group List Record.xlsx"), "Failed to download Expected document");
	    
	    System.out.println("Group Excel downloaded..");
		
		
	}


	
	
	
	
	

}
