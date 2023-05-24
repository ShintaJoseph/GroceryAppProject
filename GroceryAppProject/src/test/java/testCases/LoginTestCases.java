package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

public class LoginTestCases extends BaseClass {

	LoginPage lp;

	// @Test(retryAnalyzer=RetryAnalyser.class)

	public void verifyLoginButtonText() {
		lp = new LoginPage(driver);
		String expected = "Sign Inn";//string changed to Inn to try retryanalyzer
		String actual = lp.signInText();
		// assertion
		Assert.assertEquals(actual, expected, Constants.errormessage);

	}

	//@Test

	public void verifyLoginBackgroundColor() {
		lp = new LoginPage(driver);
		String expectedResult = "rgba(52, 58, 64, 1)";
		String actualResult = lp.getBackGroundColorSignIn();
		Assert.assertEquals(actualResult, expectedResult, "not expected output");
	}

	 @Test

	public void verifyLoginBorderColor() {
		lp = new LoginPage(driver);
		String expected1 = Constants.loginButtonBorderColor;
		String actual1 = lp.getBorderColorSignIn();
		Assert.assertEquals(actual1, expected1, Constants.errormessage);

	}

//	@Test

	public void verifyLoginUserLoginDetails() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelReadUtility.read(1, 0)); // changing the code to read it from the excel file directly
		lp.enterPassword(ExcelReadUtility.read(1, 1));
		lp.signIn();

	}

//@Test

	public void verifyRememberMeCheckBoxSelected() {
		lp = new LoginPage(driver);
		lp.clickCheckBox();
		boolean expected = true;
		boolean actual = lp.isClickCheckBox();
		Assert.assertEquals(actual, expected, "Check box of rememberme is not selected");
	}

	// @Test

	public void verifyAllertTextenteringWrongPassword() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admmmin");
		lp.signIn();

		String actual = lp.getTextOfAllert();

		// String expected = "";
		// Assert.assertEquals(actual, expected, "The expected text of Allert not
		// matching with the expected one");
	}
//@Test
//tooltip not in the html 

	public void getTooltipOfUsername() {
		lp = new LoginPage(driver);
		String actual = lp.getTooltipOfUsername();
		String expected = "Please fill out this field.";
		Assert.assertEquals(actual, expected, "tool tip is not matching with the expected one");
	}

	// @Test

	public void verifyLogin() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		lp.signIn();

	}
	//@Test(dataProvider = "loginSuccess",dataProviderClass=DataProviderTestCase.class)

	public void verifySignIn(String name, String password) {
		lp = new LoginPage(driver);
		lp.performLogin(name, password);

	}

}