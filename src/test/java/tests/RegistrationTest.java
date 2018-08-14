package tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utility.Constant;
import Utility.excelUtility;
import pages.*;


public class RegistrationTest extends TestBase {
	
	
  @Test
  public void createAccount() {
	PageFactory.initElements(driver, HomePage.class);
	PageFactory.initElements(driver, RegistrationPage.class);
	
	try {
		excelUtility.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.File_SheetName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage.clickSignIn();	
		
		RegistrationPage.enterEmailAddress(excelUtility.getCellData(1, 1));
		RegistrationPage.clickSubmitButton();
		RegistrationPage.clickMrRadioButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		RegistrationPage.selectDayofBirth(excelUtility.getCellData(1, 2));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		RegistrationPage.selectMonthofBirth(excelUtility.getCellData(1, 3));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		RegistrationPage.selectYearofBirth(excelUtility.getCellData(1, 4));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		RegistrationPage.selectState(excelUtility.getCellData(1, 5));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
 

}
