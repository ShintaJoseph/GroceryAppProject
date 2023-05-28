package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;

public class LoginTestCases extends BaseClass {

	LoginPage lp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(enabled = false, retryAnalyzer = RetryAnalyser.class)

	public void verifyLoginButtonText() throws IOException {
		lp = new LoginPage(driver);
		String expected = ExcelReadUtility.read("Sheet2", 2, 0);
		String actual = lp.signInText();
		Assert.assertEquals(actual, expected, Constants.errormessage);

	}

	@Test(enabled = true, priority = 1)

	public void verifyLoginBackgroundColor() throws IOException {
		lp = new LoginPage(driver);
		String expectedResult = ExcelReadUtility.read("Sheet2", 2, 2);
		String actualResult = lp.getBackGroundColorSignIn();
		Assert.assertEquals(actualResult, expectedResult, Constants.errormessage);
	}

	@Test(enabled = false, priority = 3)

	public void verifyLoginBorderColor() {
		lp = new LoginPage(driver);
		String expected1 = Constants.loginButtonBorderColor;
		String actual1 = lp.getBorderColorSignIn();
		Assert.assertEquals(actual1, expected1, Constants.errormessage);

	}

	@Test(enabled = false, priority = 4)

	public void verifyLoginUserLoginDetails() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtility.read("Sheet1", 1, 0), ExcelReadUtility.read("Sheet1", 1, 1));
		String actual = lp.getNameOfSuperMarket();
		String expected = ExcelReadUtility.read("Sheet2", 0, 0);
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

	@Test(enabled = false, priority = 5)

	public void verifyRememberMeCheckBoxSelected() {
		lp = new LoginPage(driver);
		lp.clickCheckBox();
		boolean expected = Constants.trueButton;
		boolean actual = lp.isClickCheckBox();
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

	@Test(enabled = false, priority = 6)

	public void verifyAllertTextenteringWrongPassword() {
		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelReadUtility.read("Sheet1", 2, 0), ExcelReadUtility.read("Sheet1", 2, 1));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String actual = lp.getTextOfAllert();

		String expected = Constants.Allert;
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

	@Test(enabled = false, dataProvider = "loginSuccess", dataProviderClass = DataProviderTestCase.class, priority = 7)

	public void verifySignIn(String name, String password) {
		lp = new LoginPage(driver);
		lp.performLogin(name, password);
		String actual = lp.getTextOfAllert();

		String expected = Constants.Allert;
		Assert.assertEquals(actual, expected, Constants.errormessage);

	}

}