package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void waitExplicit(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait( driver, Duration.ofMillis(5000));// explicit wait
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Manage Pages")));
	}
}
