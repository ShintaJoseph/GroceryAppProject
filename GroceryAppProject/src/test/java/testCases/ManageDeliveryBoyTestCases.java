package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;

import utilities.GeneralUtilities;

public class ManageDeliveryBoyTestCases extends BaseClass{
	
	HomePage Hp;
	LoginPage lp;
	ManageDeliveryBoy Md;
	GeneralUtilities gu = new GeneralUtilities();
  @Test
  public void verifyTheTextOfAllertOnAddingNewDeliveryBoy() throws IOException {
	  Md = new ManageDeliveryBoy(driver);
	 String actual = Md.updateDetailsOfNewDeliveryBoy();
	 String expected = "Delivery Boy Details Created Successfully";
	 Assert.assertEquals(actual, expected, "Not Matching with the expected allert text");
  }
}
