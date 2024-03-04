package SupriyaReddy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
 public static ExtentReports getReportObject() {
	 
	 String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("AUTOMATION RESULTS");
		reporter.config().setDocumentTitle("TEST RESULTS");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Reddy");
		return extent;
		 
	 
	 
 }
}
