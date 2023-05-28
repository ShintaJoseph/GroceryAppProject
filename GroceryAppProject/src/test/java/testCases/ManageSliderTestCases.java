package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSlider;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;

public class ManageSliderTestCases extends BaseClass {
	HomePage Hp;
	LoginPage lp;
	ManageSlider Ms;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(enabled = true)
	public void verifyTheAllertTextOnClickingSaveButtonByGivingLink() throws IOException {
		Hp = new HomePage(driver);
		lp = new LoginPage(driver);
		Ms = new ManageSlider(driver);
		lp.performLogin(ExcelReadUtility.read("Sheet1", 1, 0), ExcelReadUtility.read("Sheet1", 1, 1));

		String actual = Ms.clickNewButtonAndEnterLinkPressSaveButtonThenGetTextOfAllert();

		String expected = Constants.Allert;
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}
}
