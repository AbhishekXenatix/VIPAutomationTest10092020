package VIPqabase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Util.ExtentTestListner;

@Listeners({ExtentTestListner.class})
public class TestBase {
	
	public static WebDriver driver;
	private static  String URL = "https://vips.spectratech.com:9443/index.php";
	private static String TEST_DATA_SHEET_PATH = "./src/main/java/Util/VIPTestData.xlsx"; 
	
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters("BrowserName")
	public static WebDriver BaseCar(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhishek.g\\Downloads\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			
			
			
		}else if (BrowserName.equalsIgnoreCase("Edge")) {
		
            System.setProperty("webdriver.Edge.driver", "C:\\Users\\abhishek.g\\Downloads\\softwares\\edgedriver_win64\\msedgedriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.get(URL);
        	
            
		}else if (BrowserName.equalsIgnoreCase("IE")){
			
			   System.setProperty("webdriver.ie.driver", "C:\\Users\\abhishek.g\\Downloads\\softwares\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			   WebDriver driver = new InternetExplorerDriver();
			   driver.get(URL);
			   driver.findElement(By.xpath(""));
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.id("login")).sendKeys("Abhishek.g");
		driver.findElement(By.id("password")).sendKeys("Master@07");
		driver.findElement(By.id("submitLogin")).click();
		String i = driver.getCurrentUrl();
		System.out.println(i);
		String j = driver.getTitle();
		System.out.println(j);
		
		
		return driver;
		
		
		
		
		
	}
	
	
	
	
	/*
	 * @AfterClass public void close() { driver.quit(); driver.close(); }
	 */
	 
	
	


}
