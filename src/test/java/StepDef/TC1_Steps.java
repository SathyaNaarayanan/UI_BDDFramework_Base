package StepDef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListeners;
import PageObject.CalculatorPage;
import Utility.Helper;
import Utility.LaunchBrowser;
import Utility.PropertyFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TC1_Steps extends ExtentReportListeners{

	PropertyFileReader fileReader = new PropertyFileReader();
	//private WebDriver driver;
	private CalculatorPage CalculatorPage;

	@Given("^I launch browser and base URL$")
	public void launchBrowserAndLaunchBaseURL() throws Exception {
		System.out.println("Given run");
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class, "Featur name");
			test = test.createNode(Scenario.class, "TC name");
			logInfo = test.createNode(new GherkinKeyword("Given"), "Launch browser");
			Properties prop = fileReader.getProperty();
			Helper.driver = LaunchBrowser.OpenBrowser(Helper.driver, prop.getProperty("browser"), prop.getProperty("url"));
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
			logInfo.pass("Open chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}
	
	@When("^I enter start data$")
	public void i_enter_start_data() throws Throwable {
		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "I enter start date");
			System.out.println("I enter start date");
			CalculatorPage = new CalculatorPage(Helper.driver);
			CalculatorPage.input_StartYear();
			logInfo.pass("Start Date entered");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}

	@When("^I enter end date$")
	public void i_enter_end_date() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "I enter end date");
			System.out.println("I enter end date");
			CalculatorPage.input_EndYear();
			logInfo.pass("End Date entered");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}

	@When("^Click calculate button$")
	public void click_calculate_button() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"), "I click calculate button");
			System.out.println("I click Calculate button");
			CalculatorPage.click_CalculateButton();
			logInfo.pass("Clicked calculate button");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}

	@Then("^I see the desired result$")
	public void i_see_the_desired_result() throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"), "I see results");
			System.out.println("I see results");
			CalculatorPage = new CalculatorPage(Helper.driver);
			CalculatorPage.verifyResultDisplayed();
			logInfo.pass("Results displayed");
			logInfo.addScreenCaptureFromPath(captureScreenShot(Helper.driver));
			Helper.driver.quit();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL", Helper.driver, logInfo, e);
		}
	}


}
