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
		WebElement panelmenu = driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]"));Helper.staticWait(3000);
		panelmenu.click();Helper.staticWait(2000);
		//click on user group permission 
		driver.findElement(By.xpath("//a[contains(text(),'User Group Permission')]")).click();Helper.staticWait(2000);
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
		WebElement panelmenuform = driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Setting')]"));Helper.staticWait(3000);
		panelmenuform.click();Helper.staticWait(3000);
		//click on user group permission 
		System.out.println("click on setting menu..");
		driver.findElement(By.xpath("//a[contains(text(),'User Group Permission')]")).click();Helper.staticWait(2000);
		//click on internal group for user group permission 
		driver.findElement(By.id("Merchant-tab")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newItemMain")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_GROUP_NAME")).sendKeys("All Select Merchant");Helper.staticWait(2000);
		driver.findElement(By.id("genDetail_ACTIVED")).click();Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(6000);
		
	}
	
	
	
	

}
