package SupriyaReddy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SupriyaReddy.Resources.ExtentReporterNG;

public class Listeners extends BaseTest   implements ITestListener
{
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();        //THreadSafe
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());	
		extenttest.set(test);   //unique thread id(ErrorvalidationTest)->test
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "TEST PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());//to get /print error message
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName() );
	}

	
	
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
