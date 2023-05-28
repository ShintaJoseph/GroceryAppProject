package testCases;

import java.io.IOException;
import org.testng.Assert;

import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

public class DataProviderLoginPage extends BaseClass {

	LoginPage lp;

	@Test(enabled=false,dataProvider = "LoginValid", dataProviderClass = DataProviderLoginPage.class)
	public void verifyLogin(String type, String username, String password) throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin((ExcelReadUtility.read("Sheet1", 1, 0)), ((ExcelReadUtility.read("Sheet1", 1, 1))));
		if (type.equals(ExcelReadUtility.read("Sheet2", 0, 2))) {
			String actual = lp.text();
			String expected = (ExcelReadUtility.read("Sheet2", 0, 0));

			Assert.assertEquals(actual, expected, Constants.errormessage);
		} else if (type.equals(ExcelReadUtility.read("Sheet2", 1, 2))) {

			String actual = lp.loginInvalid();
			String expected = Constants.Allert;
			Assert.assertEquals(actual, expected, Constants.errormessage);
		}
	}
}
