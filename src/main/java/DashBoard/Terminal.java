package DashBoard;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import Util.Helper;
import VIPqabase.TestBase;

public class Terminal extends TestBase{
	public static ExtentTest test;
	
	public Terminal(WebDriver driver) {}
	
	
	public void CreatTerminal() throws InterruptedException {

		System.out.println("Create a Terminal..");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[5]/a")).click();
		driver.findElement(By.id("newTerminal")).click();
		Helper.staticWait(2000);
		
		WebElement apollod = driver.findElement(By.id("newTerminalJBox"));
		apollod.click();Helper.staticWait(2000);
		
		WebElement sel = driver.findElement(By.id("newItemMain"));
		sel.click();Helper.staticWait(2000);
		
		
		 WebElement element = driver.findElement(By.id("genDetail_SHOP_ID"));
		 element.click();
		 
		 Select select = new Select(element); 
		 List<WebElement> dropdown=select.getOptions();
		 for(int i=0;i<dropdown.size();i++){
			 
			 String drop_down_values=dropdown.get(i).getText();
			 
			 System.out.println("dropdown values are "+drop_down_values);
			 
			 }
		 
		 select.selectByVisibleText("ert");Helper.staticWait(2000);
		
		WebElement activestatus = driver.findElement(By.id("genDetail_ACTIVED"));
		activestatus.click();Helper.staticWait(2000);
		
	    driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
	    
	    driver.findElement(By.id("genDetail_SERIAL_NUM")).sendKeys("S012222222");Helper.staticWait(2000);
	    
	    driver.findElement(By.id("sliderBtnSaveNew")).click();;Helper.staticWait(2000);
		
	}
	
	
	public void createterminalnotapollo() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Create if not Apollo terminal");
		Helper.staticWait(2000);
		driver.findElement(By.xpath("//*[@id=\"panel-menu\"]/ul/li[5]/a")).click();Helper.staticWait(2000);
		driver.findElement(By.id("newTerminal")).click();Helper.staticWait(2000);
		
		WebElement apollodno = driver.findElement(By.id("newTerminalJBox"));
		apollodno.click();Helper.staticWait(2000);
		
		driver.findElement(By.id("NOAPO")).click();Helper.staticWait(2000);
		
		WebElement Terminalid = driver.findElement(By.id("genDetail_TERMINAL_ID"));
		Terminalid.sendKeys("1011111111100");Helper.staticWait(2000);
		
		 WebElement ele01 = driver.findElement(By.id("genDetail_SHOP_ID"));
		 ele01.click(); 
		Select select = new Select(ele01); 
		 select.selectByVisibleText("ert");Helper.staticWait(2000);
		 
		 
		 WebElement activestatus = driver.findElement(By.id("genDetail_ACTIVED"));
			activestatus.click();Helper.staticWait(2000);
			
		driver.findElement(By.xpath("//*[@id=\"genDetail_ACTIVED\"]/option[2]")).click();Helper.staticWait(2000);
		
		driver.findElement(By.id("genDetail_DESCRIPTION")).sendKeys("Hey this is not for Apollo..");
		driver.findElement(By.id("genDetail_COMMENTS")).sendKeys("Hey Thanks..");
		driver.findElement(By.id("genDetail_REMARKS")).sendKeys("Thanks..");Helper.staticWait(2000);
		driver.findElement(By.id("sliderBtnSaveNew")).click();Helper.staticWait(2000);
		
	}
	
	
	
	
	
	
	

}
