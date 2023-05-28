package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadUtility;

public class DataProviderTestCase {
  @DataProvider (name="loginSuccess")
  public Object[][] successfull() throws IOException{
	  return new Object[][] {{ExcelReadUtility.read("Sheet1",2, 0), ExcelReadUtility.read("Sheet1",2, 1)},{ExcelReadUtility.read("Sheet1",3, 0), ExcelReadUtility.read("Sheet1",3, 1)}};
  }
}
