package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	static WebDriver driver;
	@FindBy(id = "email_create")
	static WebElement emailAddress;
	
	@FindBy(id = "SubmitCreate")
	static WebElement Submit;
	@FindBy(id = "id_gender1")
	static WebElement Mr;
	@FindBy(id = "id_gender2")
	static WebElement Mrs;
	@FindBy(id = "days")
	static WebElement Days;
	@FindBy(id = "months")
	static WebElement Months;
	@FindBy(id = "years")
	static WebElement Year;
	@FindBy(id = "id_state")
	static WebElement State;
	
	
	public RegistrationPage(WebDriver _driver) {
		driver = _driver;
	}
	public static void enterEmailAddress(String _emailAddress)
	{
		emailAddress.sendKeys(_emailAddress);
	}
	public static void clickSubmitButton()	{
		Submit.click();
	}
	public static void clickMrRadioButton()	{
		Mr.click();
	}
	public static void clickMrsRadioButton()	{
		Mrs.click();
	}
	public static void selectDayofBirth(String day)	{
		//Select daySelect = new Select(Days);
		//daySelect.selectByValue(day);
		((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].value == arguments[1]){ select.options[i].selected = true; } }", "days", day);
		
	}
	public static void selectMonthofBirth(String month)	{
		Select monthSelect = new Select(Months);
		monthSelect.selectByValue(month);
		
	}
	public static void selectYearofBirth(String year)	{
		Select yearSelect = new Select(Year);
		yearSelect.selectByValue(year);
		
	}
	public static void selectState(String state)	{
		Select stateElement = new Select(State);
		stateElement.selectByVisibleText(state);;
		
	}
}
