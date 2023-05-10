package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;



  public class Login extends Baseclass {

		LoginPage lp;

		 @Test

		public void verifyLoginButtonText() {
			lp = new LoginPage(driver);
			String expected = "Sign In";
			String actual = lp.signInText();
			Assert.assertEquals(actual, expected, "Not matching");

		}
}
