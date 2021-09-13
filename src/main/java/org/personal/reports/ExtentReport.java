package org.personal.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import org.personal.constants.Constants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

	private static ExtentReports extent;


	private ExtentReport() {

	}

	public static void initReport() throws Exception {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(Constants.getReportPath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Reports");
			spark.config().setReportName("Extent Report demo");
		}

	}

	public static void flushReport() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(Constants.getReportPath()).toURI());
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	
		
	}
}
