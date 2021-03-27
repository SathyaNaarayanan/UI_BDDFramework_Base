package Listeners;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

public class ExtentReportListeners {

	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	public static ExtentReports setUp() {
		String report_loc = System.getProperty("user.dir")+"\\Reports\\MyOwnReport.html";
		report = new ExtentHtmlReporter(report_loc);
		report.config().setDocumentTitle("UI Automation Test report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		report.start();
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Calculator");
		extent.setSystemInfo("Operation System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		return extent;
	}
	
	public static void testStepHandle(String testStatus, WebDriver driver, ExtentTest extentTest, Throwable throwable) {
	
		switch(testStatus) {
		case "FAIL":
			extentTest.fail(MarkupHelper.createLabel("Test case is Failed", ExtentColor.RED));
			extentTest.error(throwable.fillInStackTrace());
			try {
				test.addScreenCaptureFromPath(captureScreenShot(driver));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			if(driver !=null) {
				driver.quit();
			}
			break;
			
		case "PASS":
			extentTest.fail(MarkupHelper.createLabel("Test case is Passed", ExtentColor.GREEN));
			extentTest.error(throwable.fillInStackTrace());
			break;
		default:
			break;
		}
		
	}
	
	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\Reports\\"+ "scnshot_"+getCurrentDateandTime()+".png";
		File target = new File(dest);
		FileHandler.copy(src, target);
		return dest;
	}
	
	public static String getCurrentDateandTime() {
		String s = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			s = dateFormat.format(date);
			s = s.replace(" ", "").replaceAll("/","").replaceAll(":", "");
		}
		catch(Exception e) {
			throw e;
		}
		return s;
	}
}
