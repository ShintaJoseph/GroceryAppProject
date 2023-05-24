package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestCase {
  @DataProvider (name="loginSuccess")
  public Object[][] successfull(){
	  return new Object[][] {{"admin","admin"},{"test","test"}};
  }
}
