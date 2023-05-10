package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageCategory;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class CategoryTestcases extends BaseClass {
	HomePage Hp;
	ManageCategory Mc;
	LoginPage lp;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();
@Test
public void verifyTheAllerttextOnRemovingSmallMarbleChairTitle() throws IOException {
	lp = new LoginPage(driver);
	Mc = new ManageCategory(driver);
	lp.performLogin(ExcelReadUtility.read(1, 0),ExcelReadUtility.read(1, 1));
	wu.waitExplicit(driver);
	String actual = Mc.getTheTextOfAllertOnDeletingOneTitleInsideCategoryOptionWithinManageCategoryTab();
	String expected = "Category Deleted Successfully";
	Assert.assertEquals(actual, expected, "Allert text not matching with the expected one");
}}