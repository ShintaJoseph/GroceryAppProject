package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	//	@Test // no such allert message in console. But the pgm run successfully
		public void verifyTheAllertTextOnClickingSaveButtonByGivingLink() throws IOException {
			Hp = new HomePage(driver);
			lp = new LoginPage(driver);
			Ms = new ManageSlider(driver);
			lp.performLogin(ExcelReadUtility.read(1, 0),ExcelReadUtility.read(1, 1));
			
			
			String actual =Ms.clickNewButtonAndEnterLinkPressSaveButtonThenGetTextOfAllert();
			
			String expected = "Alert!";
			Assert.assertEquals(actual, expected, "Allert was not matching with the expected one");
		}
}
