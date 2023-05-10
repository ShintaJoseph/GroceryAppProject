package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

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

  @Test
  public void verifyTheTextOfAllertOnSelectingActiveButton() throws IOException {
	  
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtility.read(1, 0),ExcelReadUtility.read(1, 1));
	  Hp.selectManagePaymentMethod();
	  String actual =Mp.clickActiveButtonAndGetTheTextOfAllert();
		
		String expected = "Product Status Changed Successfully";
		Assert.assertEquals(actual, expected, "not matching with the expected one");
	}
  }

