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
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	//@Test
	public void verifyThePageValueCorrespondingToBushTomato() throws IOException {
		lp = new LoginPage(driver);
		Mp = new ManagePages(driver);
		lp.performLogin(ExcelReadUtility.read(1, 0),ExcelReadUtility.read(1, 1));
		
		
		String actual =Mp.clickOnManageContentAndSelectManagePage();
		
		String expected = "Guava";
		Assert.assertEquals(actual, expected, "Page value of Bush Tomato was not matching with the expected one");
	}
@Test //not working
public void verifyTheFileUploadedInTheEditButtonInsideActionOfTitlejm() throws Exception  {
	    
		lp = new LoginPage(driver);
		Mp = new ManagePages(driver);
		lp.performLogin(ExcelReadUtility.read(1, 0),ExcelReadUtility.read(1, 1));
		String actual =	Mp.fileUploadOnEditButtonInsideActionOfTitlejm();
	String expected="Page Updated Successfully";
	Assert.assertEquals(actual, expected, "File not updated");
}
}

