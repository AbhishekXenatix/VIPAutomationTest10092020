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
		//click on user group permission 
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		//click on internal group for user group permission 
		driver.findElement(By.id("INT-tab")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);  
	}
	
	
public void CreatMerchantUserGroup() {
		
		System.out.println("Create Merchant User Group..");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on setting 
		WebElement panelmenuform = driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[8]/a"));
		//click on user group permission 
		driver.findElement(By.xpath("//*[@id=\"mm-4\"]/ul/li[2]/a")).click();Helper.staticWait(2000);
		//click on internal group for user group permission 
		driver.findElement(By.id("Merchant-tab")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
	}
	
	
	
	

}
