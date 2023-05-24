package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageCategory;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class CategoryTestcases extends BaseClass {
	HomePage hp;
	ManageCategory mc;
	LoginPage lp;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

  @Test
	public void verifyTheAllerttextOnRemovingTitle() throws IOException {
		lp = new LoginPage(driver);

		mc = new ManageCategory(driver);
		lp.performLogin(ExcelReadUtility.read(1, 0), ExcelReadUtility.read(1, 1));
		
		String actual = mc.getTheTextOfAllertOnDeletingOneTitleInsideCategoryOptionWithinManageCategoryTab();
		String expected = ExcelReadUtility.read(1, 3);
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

	//@Test // scrolling left side not possible
	public void verifyAllertOnAddingOneCategory() throws IOException {
		lp = new LoginPage(driver);
		mc = new ManageCategory(driver);
		hp = new HomePage(driver);
		lp.performLogin(ExcelReadUtility.read(1, 0), ExcelReadUtility.read(1, 1));
		// wu.waitExplicit(driver);
		String actual = mc.getTheTextOfAllertOnAddingANewCategory();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Text not matching with the expected one");
	}
}