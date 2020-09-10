package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	Properties prop = new Properties();
	
	File file = new File("C:\\Users\\abhishek.g\\eclipse-workspace\\VIPSystemSCLAutomation\\src\\main\\resources\\Dashboard.properties");
	
	public PropertyFileReader() {
		 FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}

}
	
	
	
	public String getTransID () {
		return prop.getProperty("TransactionID");
	}
	
	public String getMonthlyReportSearch () {
		return prop.getProperty("MonthlyReportSearch");
	}
	
	public String getMerchantID () {
		return prop.getProperty("MerchantID");
	}
	
	
	//#####################################Merchant Details############################################################################################################################
	
	public String getMID () {
		return prop.getProperty("MID");
	}
	
	public String getMerchantName () {
		return prop.getProperty("MerchantName");
	}
	
	public String getDescription() {
		return prop.getProperty("Description");
	}
	
	public String getADDRESS_1() {
		return prop.getProperty("ADDRESS_1");
	}
	
	public String getADDRESS_2() {
		return prop.getProperty("ADDRESS_2");
	}
	
	public String getADDRESS_3() {
		return prop.getProperty("ADDRESS_3");
	}
	
	public String getCONTACT () {
		return prop.getProperty("CONTACT");
	}
	
	public String getJOB_TITLE() {
		return prop.getProperty("JOB_TITLE");
	}
	
	public String getPHONE_NO() {
		return prop.getProperty("PHONE_NO");
	}
	
	public String getEMAIL_ADDRESS() {
		return prop.getProperty("EMAIL_ADDRESS");
	}
	
	public String getCOMMENTS() {
		return prop.getProperty("COMMENTS");
	}
	
	public String getREMARKS() {
		return prop.getProperty("REMARKS");
	}
	
	
}
