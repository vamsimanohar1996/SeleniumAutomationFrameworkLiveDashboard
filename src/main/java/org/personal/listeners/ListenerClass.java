package org.personal.listeners;

import java.io.IOException;

import org.personal.reports.ExtentLogger;
import org.personal.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {
	
	
	@Override
	public void onStart(ISuite suite)
	{
	     try {
			ExtentReport.initReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		try {
			ExtentReport.flushReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getDescription());
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		ExtentLogger.pass(result.getMethod().getMethodName() + " PASSED ");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		try {
			ExtentLogger.fail(result.getMethod().getMethodName(), true);
			
			// Adding error log to the report
			ExtentLogger.fail(result.getThrowable().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		ExtentLogger.skip(result.getMethod().getMethodName() + " SKIPPED ");
	}
	

}
