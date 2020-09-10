package DashBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Util.Helper;
import VIPqabase.TestBase;

public class ShopListSearch extends TestBase{
	
	public ShopListSearch(WebDriver driver) {}
	
	static SoftAssert softassert = new SoftAssert();
	
	
	
	public static void SIDsearch(String SID) {
		try {
		
		System.out.println("Verify the SID Search");
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")));
		   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(2000);
		   driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(3000);
		   
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement sid =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  sid.sendKeys(SID);Helper.staticWait(2000);
		  
		WebElement elesel =  driver.findElement(By.xpath("//*[@type='checkbox' and @name='id[]']"));elesel.click();Helper.staticWait(3000);
		 driver.findElement(By.xpath("//*[@id=\"table_main\"]")).click();Helper.staticWait(5000);
		 
		 driver.findElement(By.xpath("//*[@id=\"slider_1\"]/div/div[1]/div[1]")).click();
		
		 WebElement elesid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[2]"));
		String messid = elesid.getText();
		System.out.println(messid); 
		softassert.assertEquals(SID, messid);
		
		sid.clear();
		elesel.click();
      

     softassert.assertAll();
     System.out.println("Verify the SID Search finished..");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	
	public static void ShopIDsearch(String ShopID) {
		try {
		
		System.out.println("Verify the ShopID Search");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")));
		   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(2000);
		   driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(3000);
		   
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		  WebElement shopid =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  shopid.sendKeys(ShopID);Helper.staticWait(2000);
		  WebElement eleshopid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[3]"));
	           String messhopid =   eleshopid.getText();
	           System.out.println(messhopid);
		  softassert.assertEquals(ShopID, messhopid);
		  shopid.clear();Helper.staticWait(3000);
		  softassert.assertAll();
		  System.out.println("Verify the ShopID Search finished");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
	}
	
	public static void PropertyIDsearch(String PropertyID) {
		try {
		System.out.println("Verify the Property ID Search");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")));
		   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(2000);
		   driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(3000);
		   
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		   WebElement shopid =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  
		  shopid.sendKeys(PropertyID);Helper.staticWait(2000);
		  
		  WebElement propertyid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[4]"));
	           String mespropertyid =   propertyid.getText();
	           System.out.println(mespropertyid);
		  softassert.assertEquals(PropertyID, mespropertyid);
		  shopid.clear();Helper.staticWait(3000);
		  softassert.assertAll();
		  System.out.println("Verify the Property ID Search finished");
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(e); 
	}
	}
	
	
public static void GrantIDsearch(String GrantID) {
		try {
		System.out.println("Verify the Grant ID Search");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")));
		   driver.findElement(By.xpath("//a[@class='mm-btn mm-btn_next mm-listitem__btn mm-listitem__text'][contains(text(),'Shop')]")).click();Helper.staticWait(2000);
		   driver.findElement(By.xpath("//a[contains(text(),'Shop List')]")).click();Helper.staticWait(3000);
		   
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Search:')]//input")));
		   WebElement elegrantid =  driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		  
		   elegrantid.sendKeys(GrantID);Helper.staticWait(2000);
		   
		   WebElement grantid = driver.findElement(By.xpath("//*[@id=\"table_main\"]/tbody/tr/td[5]"));
           String mesgrantid =   grantid.getText();
           System.out.println(mesgrantid);
	  softassert.assertEquals(GrantID, mesgrantid);
	  elegrantid.clear();Helper.staticWait(3000);
	  softassert.assertAll();
		   
	  System.out.println("Verify the Grant ID Search finished");
		  
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e); 
		}
		 
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	

}
