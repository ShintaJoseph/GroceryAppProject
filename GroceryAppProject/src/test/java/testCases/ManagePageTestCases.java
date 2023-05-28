package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManagePages;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;

public class ManagePageTestCases extends BaseClass {
	HomePage Hp;
	LoginPage lp;
	ManagePages Mp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test(enabled = true)
	public void verifyThePageValueCorrespondingToMango() throws IOException {
		lp = new LoginPage(driver);
		Mp = new ManagePages(driver);
		lp.performLogin(ExcelReadUtility.read("Sheet1",1, 0), ExcelReadUtility.read("Sheet1",1, 1));

		String actual = Mp.clickOnManageContentAndSelectManagePage();

		String expected = ExcelReadUtility.read("Sheet2",1, 0);
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}

	@Test(enabled = false)
	public void verifyTheFileUploadedInTheEditButtonInsideActionOfTitlejm() throws Exception {

		lp = new LoginPage(driver);
		Mp = new ManagePages(driver);
		lp.performLogin(ExcelReadUtility.read("Sheet1",1, 0), ExcelReadUtility.read("Sheet1",1, 1));
		String actual = Mp.fileUploadOnEditButtonInsideActionOfTitlejm();
		System.out.println(actual);
		String expected = Constants.Allert;
		Assert.assertEquals(actual, expected, Constants.errormessage);
	}
}
