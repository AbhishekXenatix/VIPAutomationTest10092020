package Util;

import org.testng.ITestListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import VIPqabase.TestBase;

public class ExtentTestListner extends TestBase implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().info(result.getMethod().getMethodName()+" test executions started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));

	}

	/*
	 * @Override public void onTestFailure(ITestResult result) {
	 * ExtentTestManager.getTest().log(Status.FAIL,MarkupHelper.createLabel(result.
	 * getName() + " - Test Case Failed", ExtentColor.RED)); String screenshotPath =
	 * getScreenShotas(driver, result.getName());
	 * 
	 * 
	 * try { ExtentTestManager.getTest().fail("Test Case Failed Snapshot is below "
	 * ,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); }
	 * catch (IOException e) { e.printStackTrace(); }
	 * 
	 * 
	 * ExtentTestManager.getTest().log(Status.INFO, "ScreenShot Link : " +
	 * "<a href=" + screenshotPath+ " target=\"_blank\">ScreenShot_" +
	 * result.getMethod().getMethodName() + "</a>"); }
	 */

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	/*
	 * public static String getScreenShot(WebDriver driver, String screenshotName) {
	 * String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 * TakesScreenshot ts = (TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName
	 * + dateName + ".png"; //String destination = System.
	 * getProperty("C:\\Users\\abhishek.g\\.jenkins\\workspace\\VIP Automation\\test-output\\Screenshots"
	 * ) + screenshotName + dateName + ".png"; System.out.println("Destination is" +
	 * destination); File finalDestination = new File(destination); try {
	 * FileUtils.copyFile(source, finalDestination); } catch (IOException e) {
	 * e.printStackTrace(); } return destination; }
	 */
	
	
	


	public static String getScreenShotas(WebDriver driver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String sourceBase64 = ts.getScreenshotAs(OutputType.BASE64);
		
		File fileDesti = OutputType.FILE.convertFromBase64Png(sourceBase64);
		
		String destination = System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName + dateName + ".png";
	
		System.out.println("Destination is" + destination);
		
		try {
			FileUtils.copyFile(fileDesti, new File("data:image/png;base64", (System.getProperty("user.dir") + "/test-output/Screenshots/" + screenshotName+ dateName + ".png" )), true);
			//FileUtils.copyFile(fileDesti, new File(" data:image/png;base64,C:/Users/abhishek.g/eclipse-workspace/VIPSystemSCLAutomation/test-output/Screenshots/ " + screenshotName+ dateName + ".png" ), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sourceBase64;
		
		
	}
	
	
	
	  @Override public void onTestFailure(ITestResult result) {
	  ExtentTestManager.getTest().log(Status.FAIL,MarkupHelper.createLabel(result. getName() + " - Test Case Failed", ExtentColor.RED)); 
	  String screenshotPath = getScreenShotas(driver, result.getName());
	  
	  
	  try {
		ExtentTestManager.getTest().fail("Test Case Failed..screenshot attched"
				  ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  //ExtentTestManager.getTest().log(Status.INFO, "ScreenShot Link : " + "<a href=" + screenshotPath+ " target=\"_blank\">ScreenShot_" + result.getMethod().getMethodName() + "</a>"); 
	  }
	 

	


}
