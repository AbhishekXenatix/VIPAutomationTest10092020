package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;


public class ExtentManager {
	
	public static ExtentReports extent;
    private static String reportFileName = "Test-Automation-Report"+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") + "/test-output";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    
	public static ExtentReports createInstance() {
        String fileName = reportFileLocation;
        Date curDate = new Date();
        System.out.println(curDate.toString());
        

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        //htmlReporter.config().setChartVisibilityOnOpen(true);
		 //htmlReporter.config().setAutoCreateRelativePathMedia(true);
		// Name of the report
	    htmlReporter.config().setReportName("AUOTMATION TEST REPORTS");
		htmlReporter.config().setDocumentTitle("VIPS System Extent Report ");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm aa '('zzz')'");
       

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
        extent.setSystemInfo("Host Name", "Selenium POM");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Application", "VIPS Dashboard");
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Organization", "Spectra System QA");
        extent.setSystemInfo("Run Started on", curDate.toString());
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
       
      
        


        return extent;
    }

    //Create the report path
    private static String getReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }

}
