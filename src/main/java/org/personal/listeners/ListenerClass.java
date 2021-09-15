package org.personal.listeners;

import java.util.Arrays;

import org.personal.annotations.FrameworkAnnotation;
import org.personal.reports.ExtentLogger;
import org.personal.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

			ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		
			ExtentReport.flushReport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " PASSED ");
	}

	@Override
	public void onTestFailure(ITestResult result) {

	
			ExtentLogger.fail(result.getMethod().getMethodName(), true);

			// Adding error log to the report
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " SKIPPED ");
	}

}
