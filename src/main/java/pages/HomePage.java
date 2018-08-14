package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	@FindBy(linkText = "Sign in")
	static WebElement signIn;

	public HomePage(WebDriver _driver) {
		this.driver = _driver;
	}
	public static void clickSignIn()
	{
		signIn.click();
	}
	public static String SignInText()
	{
		return signIn.getText();
	}
}
