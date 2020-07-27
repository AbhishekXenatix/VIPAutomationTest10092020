package DashBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Util.ExtentTestManager;
import Util.Helper;
import VIPqabase.TestBase;

public class UserListForSetting extends TestBase{
	
	public UserListForSetting(WebDriver driver) {}
	
	
	public void CreateUserListforMerchant() {
		
		System.out.println("Create user list for Merchant..");
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[9]/a")).click();
		//click user list
		
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[3]/a")).click();
		//click on new item
		
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		
		//General Merchant (Terminal)
		driver.findElement(By.id("genDetail_USER_CODE")).sendKeys("ALL01M");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_PASSWORD")).sendKeys("Pass-word12");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_FIRSTNAME")).sendKeys("Testing QA");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_LASTNAME")).sendKeys("QA");Helper.staticWait(2000);
		
		
		driver.findElement(By.id("genDetail_ACTIVED")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_LOCKED")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_LOCKED\"]/option[3]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_USER_GROUP")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_USER_GROUP\"]/option[3]")).click();Helper.staticWait(2000);
		
		
		 WebElement tradingname = driver.findElement(By.id("genDetail_SHOP_ID"));
		 tradingname.click();Helper.staticWait(3000);
	     	Select select = new Select(tradingname); 
	     	
			 List<WebElement> dropdowntradingname = select.getOptions();
			 for(int i=0;i<dropdowntradingname.size();i++){
				 String drop_down_tradingname = dropdowntradingname.get(i).getText();
				 System.out.println("dropdown values are " + drop_down_tradingname);  }
			         select.selectByVisibleText("SPECTRA Sample Shop");Helper.staticWait(3000);
			         
			         driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(5000);
		
	}
	
	
	
public void CreateUserListforInternal() {
		
		System.out.println("Create user list for Internal..");
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[9]/a")).click();Helper.staticWait(2000);
		//click user list
		
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[3]/a")).click();Helper.staticWait(2000);
		//click on new item
		
		//select internal 
		driver.findElement(By.xpath("//*[@id=\"INT-tab\"]")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		
		//General Merchant (Terminal)
		driver.findElement(By.id("genDetail_USER_CODE")).sendKeys("ALL01I");Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_FIRSTNAME")).sendKeys("Testing QA");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_LASTNAME")).sendKeys("QA");Helper.staticWait(2000);
		
		
		driver.findElement(By.id("genDetail_ACTIVED")).click();
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		
	
		
		driver.findElement(By.id("genDetail_USER_GROUP")).click();
		driver.findElement(By.xpath("//*[@id=\"genDetail_USER_GROUP\"]/option[2]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(5000);
		
		
	
	}






	
	
	

}
