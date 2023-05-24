package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getElementStyleProperty(WebElement element, String propertyType) {
		String value = element.getCssValue(propertyType);
		return value;
	}

	public boolean isCheckboxSelected(WebElement element) {
		element.click();
		boolean result = element.isSelected();
		return result;
	}

	public String dropdownSelection(WebElement element, String value) {

		Select Obj = new Select(element);
		Obj.selectByValue(value);
		WebElement Selectedvalue = Obj.getFirstSelectedOption();
		return Selectedvalue.getText();
	}

	public String tooltipOfElement(WebElement element) {

		String tooltipMessage = element.getAttribute("title");
		return tooltipMessage;
	}

	public int clickDynamicTable(WebDriver driver, String columnValue, String compareName) {
		List<WebElement> firstColumnElement = driver.findElements(By.xpath(columnValue));
		int value = 0;
		for (int i = 0; i < firstColumnElement.size(); i++) {
			if (firstColumnElement.get(i).getText().equals(compareName)) {
				value = i;
				break;
			}
		}

		return value;
	}

	public void toScrollDownThePage(WebDriver driver, int valuehorizontal, int scrollValueVertical) {

		JavascriptExecutor js = (JavascriptExecutor) driver;// interface to trigger javascript
		js.executeScript("window.scrollBy(" + valuehorizontal + "," + scrollValueVertical + ")", "");// for scrolling
																										// page
		WebElement dummy = driver.findElement(By.id("aaa"));
		js.executeScript("arguments[0].click();", dummy);
	}

	public void fileUpload(WebDriver driver, WebElement value, String type) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);// for mouse hovering
		action.moveToElement(value).click().perform();

		StringSelection ss = new StringSelection(type);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void clickElementAndGiveInput(WebElement element, String text) {
		element.click();
		element.sendKeys(text);

	}
	public void uploadFile(WebDriver driver, WebElement string, String location) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);
		action.moveToElement(string).click().perform();
		// copy path to your system clipboard
		StringSelection ss = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
