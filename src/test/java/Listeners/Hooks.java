package Listeners;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	@Before
	public void beforeScenario(Scenario scenario) {
		
		System.out.println("Execution started for "+ scenario.getName());
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("Execution completed for "+ scenario.getName());
	}
	
}
