package StepDef;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListeners;
import PageObject.CalculatorPage;
import Utility.Helper;
import cucumber.api.java.en.When;

public class TC2_Steps extends ExtentReportListeners{

	private CalculatorPage CalculatorPage;
	
	@When("^I enter start data in module (\\d+)$")
	public void i_enter_start_data_in_module(int arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("When"), "I enter start date");
			System.out.println("Start date entered");
		    CalculatorPage = new CalculatorPage(Helper.driver);
			CalculatorPage.input_StartYear_AddYear();
			logInfo.pass("Start Date entered");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
		
	    
	}

	@When("^I enter value \"([^\"]*)\" to get added in years$")
	public void i_enter_value_to_get_added_in_years(String value) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("When"), "I enter start date");
			System.out.println("years added");
		    CalculatorPage.input_YearsToBeAdded(value);
			logInfo.pass("Added yeats");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
		
	}
	
	@When("^Click calculate button to \"([^\"]*)\"$")
	public void click_calculate_button_to(String arg1) throws Throwable {
		ExtentTest logInfo = null;
		try {
			
			logInfo = test.createNode(new GherkinKeyword("When"), "I enter start date");
			System.out.println("Clicked calculate button to "+arg1);
			CalculatorPage.click_Calc2_CalculateButton();
			logInfo.pass("Calculate button clicked");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}
}
