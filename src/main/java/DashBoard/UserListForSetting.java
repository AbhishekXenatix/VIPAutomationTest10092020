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
		 driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]")).click();Helper.staticWait(3000);
		//click user list
		
		driver.findElement(By.xpath("//a[contains(text(),'User List')]")).click();Helper.staticWait(3000);
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
		
		
		/*
		 * WebElement tradingname = driver.findElement(By.id("genDetail_SHOP_ID"));
		 * tradingname.click();Helper.staticWait(3000); Select select = new
		 * Select(tradingname);
		 * 
		 * List<WebElement> dropdowntradingname = select.getOptions(); for(int
		 * i=0;i<dropdowntradingname.size();i++){ String drop_down_tradingname =
		 * dropdowntradingname.get(i).getText();
		 * System.out.println("dropdown values are " + drop_down_tradingname); }
		 * select.selectByVisibleText("Welcome");Helper.staticWait(3000);
		 */
			         
			         Select tradingname =  new Select (driver.findElement(By.id("genDetail_SHOP_ID")));
			         tradingname.selectByVisibleText("Mannings");
			         Helper.staticWait(3000);
			         
			         driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(5000);
		
	}
	
	
	
public void CreateUserListforInternal() {
		
		System.out.println("Create user list for Internal..");
		 driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]")).click();Helper.staticWait(3000);
		//click user list
		
		 driver.findElement(By.xpath("//a[contains(text(),'User List')]")).click();Helper.staticWait(3000);
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



public void DeleteuserListMerchant() {
	System.out.println("Delete  User List for Merchant..");
	
	WebElement panelmenuform = driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]"));Helper.staticWait(3000);
	panelmenuform.click();Helper.staticWait(3000);
	//click on user group permission 
	System.out.println("click on setting menu..");
	driver.findElement(By.xpath("//a[contains(text(),'User List')]")).click();Helper.staticWait(3000);
	
	driver.findElement(By.xpath("//div[@id='table_main_filter']//input")).sendKeys("ALL01M");Helper.staticWait(3000);
	driver.findElement(By.xpath("//*[@type='checkbox' and @name='id[]']")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//div[@id='deleteBtn']")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//button[@id='YESDele']")).click();Helper.staticWait(5000);
	
}




public void DeleteuserListInternal() {
	System.out.println("Delete  User List for Internal..");
	
	WebElement panelmenuform = driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]"));Helper.staticWait(3000);
	panelmenuform.click();Helper.staticWait(3000);
	//click on user group permission 
	System.out.println("click on setting menu..");
	driver.findElement(By.xpath("//a[contains(text(),'User List')]")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//*[@id=\"INT-tab\"]")).click();Helper.staticWait(2000);
	
	driver.findElement(By.xpath("//div[@id='table_internal_filter']//input")).sendKeys("ALL01I");Helper.staticWait(3000);
	driver.findElement(By.xpath("//*[@id=\"table_internal\"]/tbody/tr/td[1]/input")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//div[@id='deleteBtn']")).click();Helper.staticWait(3000);
	driver.findElement(By.xpath("//button[@id='YESDele']")).click();Helper.staticWait(5000);
	
}
	
	









	
	
	

}
