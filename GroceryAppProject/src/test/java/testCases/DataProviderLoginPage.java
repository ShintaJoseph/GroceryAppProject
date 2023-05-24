package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class DataProviderLoginPage extends BaseClass {

	LoginPage lp;

	@Test(dataProvider = "LoginValid", dataProviderClass = DataProviderLoginPage.class,priority = 1)
	public void verifyLogin(String type, String username, String password) throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.signIn();
		if (type.equals("valid")) {
			String actual = lp.text();
			String expected = ("7rmart supermarket");

			Assert.assertEquals(actual, expected, "not expected output");
		} else if (type.equals("invalid")) {

			String actual = lp.loginInvalid();
			String expected = ("7rmart supermarket");
			Assert.assertEquals(actual, expected, "not expected output");
		}
	}
}

