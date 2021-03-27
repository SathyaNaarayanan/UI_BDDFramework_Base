package TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "features",
		glue = {"StepDef"},
		tags = {"@demoTest"},
		/*
		 * logical AND in tags -> Scenario which contains both the tags then it will execute
		 * tags = {"@test1","@test2"}
		 * logical OR in tags -> Scenario if any of the tags name is available then it will execute
		 * tags = {"@test1,@test2"}
		 * logical to ignore specific scenario with tags @test2 use tilt sign
		 * tags = {"@test1","~@test2"}
		 */
		//plugin = {"pretty"}, -> Auto generated report from cucumber
		monochrome = true,
		dryRun = false
		)

public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider = "feature")
	public void feature(PickleEventWrapper eventWrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature()); *info.cukes*
		//use below code when package io.cucumber* is used
		testNGCucumberRunner.runScenario(eventWrapper.getPickleEvent());
	}
	
	//@DataProvider(parallel=true) -> *for parallel execution*
	@DataProvider
	public Object[][] feature(){
		//return testNGCucumberRunner.provideFeatures(); *info.cukes*
		//use below code when package io.cucumber* is used
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		testNGCucumberRunner.finish();
	}
}
