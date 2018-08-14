package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Verifier;

import org.testng.Assert;
import pages.HomePage;

public class HomeTest extends TestBase {
	
  @Test
  public void VerifyHomePage() {
	  PageFactory.initElements(driver, HomePage.class);
	  String actualValue = HomePage.SignInText();
	  //SoftAssert replaced with Verifier custom class to get the details of the error
	  Verifier softAssert = new Verifier();
	  softAssert.assertEquals(actualValue, "Sign");
	  softAssert.assertEquals(actualValue, "Sign in");
	  softAssert.assertEquals(actualValue, "Prakash");
	  softAssert.assertAll();
  }
}
