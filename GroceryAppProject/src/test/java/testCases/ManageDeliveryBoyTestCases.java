package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;
import utilities.GeneralUtilities;




public class ManageDeliveryBoyTestCases extends BaseClass{
	
	HomePage hp;
	LoginPage lp;
	ManageDeliveryBoy md;
	
 // @Test
  public void verifyTheTextOfAllertOnAddingNewDeliveryBoy() throws IOException {
	  md = new ManageDeliveryBoy(driver);
	 String actual = md.updateDetailsOfNewDeliveryBoy();
	 String expected = "Alert!";
	 Assert.assertEquals(actual, expected, "Not Matching with the expected allert text");
  }
}

