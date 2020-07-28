package DashBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Util.Helper;
import VIPqabase.TestBase;

public class UserGroupPermission extends TestBase{
	
	public UserGroupPermission(WebDriver driver) {}
	
	
	public void CreateInternalUserGroup() {
		
		System.out.println("Create Internal User Group..");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on setting 
		WebElement panelmenu = driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[8]/a"));
		panelmenu.click();Helper.staticWait(2000);
		//click on user group permission 
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		//click on internal group for user group permission 
		driver.findElement(By.id("INT-tab")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);  
		
		driver.findElement(By.id("genDetail_GROUP_NAME")).sendKeys("All Select Int");Helper.staticWait(2000);  
		driver.findElement(By.id("genDetail_ACTIVED")).click();Helper.staticWait(2000);  
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(6000);  
		
		
	}
	
	
public void CreatMerchantUserGroup() {
		
		System.out.println("Create Merchant User Group..");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on setting 
		WebElement panelmenuform = driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[8]/a"));
		panelmenuform.click();Helper.staticWait(3000);
		//click on user group permission 
		System.out.println("click on setting menu..");
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		//click on internal group for user group permission 
		driver.findElement(By.id("Merchant-tab")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_GROUP_NAME")).sendKeys("All Select Merchant");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_ACTIVED")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(6000);
		
	}
	
	
	
	

}
