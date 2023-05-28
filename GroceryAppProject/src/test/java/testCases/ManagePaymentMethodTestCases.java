package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManagePages;
import elementRepository.ManagePaymentMethod;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;

public class ManagePaymentMethodTestCases extends BaseClass {
	HomePage Hp;
	LoginPage lp;
	ManagePaymentMethod Mp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(enabled=false)
	public void verifyTheTextOfAllertOnSelectingActiveButton() throws IOException {
		Hp = new HomePage(driver);
		lp = new LoginPage(driver);
		Mp = new ManagePaymentMethod(driver);
		lp.performLogin(ExcelReadUtility.read("Sheet1", 1, 0), ExcelReadUtility.read("Sheet1", 1, 1));
		Hp.selectManagePaymentMethod();
		String actual = Mp.clickActiveButtonAndGetTheTextOfAllert();

		String expected = Constants.Allert;
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

}
