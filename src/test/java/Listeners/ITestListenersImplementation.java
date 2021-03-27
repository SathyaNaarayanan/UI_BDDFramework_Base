package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenersImplementation extends ExtentReportListeners implements ITestListener{

	private static ExtentReports extent;
	
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure");
	}


	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		System.out.println("On Start");
		extent = setUp();
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finish");
		extent.flush();
	}

}
