package DashBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import Util.ExtentTestManager;

import Util.Helper;
import VIPqabase.TestBase;

public class ShopGroupManagement extends TestBase {
	SoftAssert softAssertion= new SoftAssert();
	
	public ShopGroupManagement(WebDriver driver) {}
	
	
	public void Createshop() throws InterruptedException {

		System.out.println("Create Shop Group ..");
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
		 Helper.staticWait(2000);
		
		
	}
	
	public void ShopGroupListPositive() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebElement NewItem = driver.findElement(By.id("newItemMain"));
		NewItem.click(); ExtentTestManager.getTest().log(Status.INFO, "Clicked on New Item Button..");
		Helper.staticWait(2000);
		
		WebElement ShopGroupID = driver.findElement(By.id("genDetail_SHOP_GROUP_ID"));
		ShopGroupID.sendKeys("Auto");
		Helper.staticWait(2000);
		
		WebElement ShopGroupName = driver.findElement(By.id("genDetail_SHOP_GROUP_NAME"));
		ShopGroupName.sendKeys("MOKO");
		Helper.staticWait(2000);
		
		WebElement Active = driver.findElement(By.id("genDetail_ACTIVED"));
		Active.click();
		Helper.staticWait(2000);
		
		WebElement selectactive = driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]"));
		selectactive.click();
		Helper.staticWait(2000);
		
		WebElement Description = driver.findElement(By.id("genDetail_DESCRIPTION"));
		Description.sendKeys("This is created by Automation..");
		Helper.staticWait(2000);
		
		WebElement Comments = driver.findElement(By.id("genDetail_COMMENTS"));
		Comments.sendKeys("shop group id created..");
		Helper.staticWait(2000);
		
		WebElement save = driver.findElement(By.id("sliderBtnSaveNew"));
		save.click();
		Helper.staticWait(5000);
		
		
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"slider_1\"]/div/div[1]/div[2]/div"));
		String s2 = errorMessage.getText();
		System.out.println(s2);
		String s3 = "Duplicate record: You have entered that already exists.";
		softAssertion.assertEquals(s2, s3);
		ExtentTestManager.getTest().log(Status.INFO, "Shop Group created with all positive valuess");
	
		
	
		
	}
	
	
	public void VerifyshopGroupName() throws InterruptedException  {
		
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement AdvSearch = driver.findElement(By.id("advSearchBtn"));
		AdvSearch.click();
		Helper.staticWait(2000);
		
		WebElement GroupNameSearch = driver.findElement(By.id("advSearch_group_name"));
		GroupNameSearch.sendKeys("MOKO");
		Helper.staticWait(2000);
		
		WebElement GroupSearch =driver.findElement(By.id("advSearch_Search"));
		GroupSearch.click();
		Helper.staticWait(2000);;
		
		WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[3]"));
		String s1 = searchresult.getText();
		System.out.println(s1);
		String s2 = "MOKO";
		softAssertion.assertEquals(s1, s2);

		
	}
	
	
	
	

}
