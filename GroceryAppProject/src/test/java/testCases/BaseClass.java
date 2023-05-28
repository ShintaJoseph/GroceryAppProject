package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import utilities.ScreenshotUtilities;

public class BaseClass {
	WebDriver driver;

	ScreenshotUtilities sc;

	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod

	public void beforeMethod() throws IOException {
		testBasic();
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeDriver\\chromedriver.exe");

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotUtilities();
			sc.captureScreenshotFailures(driver, itestResult.getName());// to get the name of failed test, we use
																		// listener by the method getName.
		}
//	driver.close();
		// Listener is used to monitor events.nearly 20+listeners present
		// Here ITestResult Listener used to find

	}
//	@BeforeMethod(alwaysRun = true)
//	@Parameters("browser")
//	public void beforeMethod(String browser) throws IOException {
//
//		if (browser.equals("chrome")) {
//			testBasic();
//			// driver = new ChromeDriver();
//
//			System.setProperty("webdriver.chrome.driver",
//					"G:\\ChromeDriver\\chromedriver.exe");
//			ChromeOptions co = new ChromeOptions();
//			co.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(co);
//		} else if (browser.equals("edge")) {
//			System.setProperty("webdriver.edge.driver",
//					"G:\\edgedriver_win64\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		}
//		driver.get(prop.getProperty("BaseURL"));// --> login page
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//
//	}
}
