package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

	WebDriver driver;
	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="(//input[@title='Year'])[1]")
	private WebElement input_AgeCal_StartDate_Year;

	@FindBy(how=How.XPATH,using="(//input[@title='Year'])[2]")
	private WebElement input_AgeCal_EndDate_Year;

	@FindBy(how=How.XPATH,using="(//input[@value='Calculate'])[1]")
	private WebElement button_AgeCal_Calculate;
	
	@FindBy(how=How.XPATH,using="//h2[text()='Result']")
	private WebElement text_AgeCal_Result;
	
	@FindBy(how=How.XPATH,using="(//input[@title='Year'])[3]")
	private WebElement input_AddYear_StartDate_Year;
	
	@FindBy(how=How.ID,using="c2year")
	private WebElement input_Calc2_Year;
	
	@FindBy(how=How.XPATH,using="(//input[@value='Calculate'])[2]")
	private WebElement button_Calc2_Calculate;
	
	public void click_Calc2_CalculateButton() throws InterruptedException {
		button_Calc2_Calculate.click();
		Thread.sleep(5000);
	}
	
	public void input_YearsToBeAdded(String value) {
		input_Calc2_Year.click();
		input_Calc2_Year.sendKeys(value);
	}
	
	public void input_StartYear() throws InterruptedException{
		input_AgeCal_StartDate_Year.click();
		input_AgeCal_StartDate_Year.clear();
		String x = input_AgeCal_StartDate_Year.getAttribute("value");
		for(int i=0; i<x.length(); i++) {
			input_AgeCal_StartDate_Year.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		input_AgeCal_StartDate_Year.sendKeys("1992");
		Thread.sleep(2000);
	}
	
	public void input_StartYear_AddYear() throws InterruptedException{
		input_AddYear_StartDate_Year.click();
		input_AddYear_StartDate_Year.clear();
		String x = input_AddYear_StartDate_Year.getAttribute("value");
		for(int i=0; i<x.length(); i++) {
			input_AddYear_StartDate_Year.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		input_AddYear_StartDate_Year.sendKeys("2000");
		Thread.sleep(2000);
	}
	
	public void input_EndYear() throws InterruptedException{
		input_AgeCal_EndDate_Year.click();
		input_AgeCal_EndDate_Year.clear();
		String x = input_AgeCal_EndDate_Year.getAttribute("value");
		for(int i=0; i<x.length(); i++) {
			input_AgeCal_EndDate_Year.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		input_AgeCal_EndDate_Year.sendKeys("2021");
		Thread.sleep(2000);
	}
	
	public void click_CalculateButton() throws InterruptedException {
		button_AgeCal_Calculate.click();
		Thread.sleep(5000);
	}

	public Boolean verifyResultDisplayed() {
		return text_AgeCal_Result.isDisplayed();
	}


}
