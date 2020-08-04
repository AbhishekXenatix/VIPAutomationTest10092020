package DashBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Util.Helper;
import VIPqabase.TestBase;

public class Merchant extends TestBase  {
	
	public Merchant(WebDriver driver) {}
	
	
	public void CreateMerchant() {
		
		System.out.println("Create Merchant List..");
		
		//click on the Merchant from menu 
		 driver.findElement(By.xpath("//a[contains(text(),'Merchant')]")).click(); Helper.staticWait(3000);
		//click on new item for merchant 
		 driver.findElement(By.xpath("//div[@id='newItemMain']")).click(); Helper.staticWait(3000);
		 
		 //MID
		 
		 driver.findElement(By.xpath("//input[@id='genDetail_MERCHANT_ID']")).sendKeys("0071"); Helper.staticWait(3000);
		 
		 //Merchant name
		 driver.findElement(By.xpath("//input[@id='genDetail_MERCHANT_NAME']")).sendKeys("VOLVIC"); Helper.staticWait(3000);
		 
		 driver.findElement(By.xpath("//div[@id='slider_1']")).click(); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//select[@id='genDetail_ACTIVED']")).click(); Helper.staticWait(3000);
		 
		 
		 driver.findElement(By.xpath("//input[@id='genDetail_DESCRIPTION']")).sendKeys("Testing"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_1']")).sendKeys("Mong"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_2']")).sendKeys("Kok"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_ADDRESS_3']")).sendKeys("EAST"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_CONTACT']")).sendKeys("Kin"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_JOB_TITLE']")).sendKeys("Manager"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_PHONE_NO']")).sendKeys("54454554"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//input[@id='genDetail_EMAIL_ADDRESS']")).sendKeys("abhishek.g@spectratech.com"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//textarea[@id='genDetail_COMMENTS']")).sendKeys("Test"); Helper.staticWait(3000);
		 driver.findElement(By.xpath("//textarea[@id='genDetail_REMARKS']")).sendKeys("Thanks.."); Helper.staticWait(3000);
		 
		 
		 driver.findElement(By.xpath("//button[@id='sliderBtnSaveNew']")).click();Helper.staticWait(5000);
	}

}
