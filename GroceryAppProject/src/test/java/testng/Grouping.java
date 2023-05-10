package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Grouping {
	@Test(groups = { "Critical" })
	public void testCase01() {
		System.out.println("testCase01");
	}

	@Test(groups = { "High" })
	public void testCase02() {
		System.out.println("testCase02");
	}

	@Test(groups = { "Critical" })
	public void testCase03() {
		System.out.println("testCase03");
	}

	@Test
	public void testCase04() {
		System.out.println("testCase04");
	}

	@Test
	public void testCase05() {
		System.out.println("testCase05");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {

		System.out.println("afterMethod");
	}
	
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{2, 3}, {5, 7},{10,15},{11,12}};
	}
}
