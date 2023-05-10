package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class HomePage {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//i[@class='fas fa-angle-left right']")
	WebElement manageExpenseDropdown;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotifications;
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	@FindBy(xpath = "//input[@id='description']")
	WebElement description;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButon;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement Allert;
	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']")
	WebElement manageCategory;
	@FindBy(xpath = "//p[text()='Category']")
	WebElement Category;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-restore']")
	WebElement manageSlider;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-credit-card']")
	WebElement managePaymentMethod;
	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement manageDeliveryBoy;

	public String selectManageExpenseDropdown() {
		return gu.dropdownSelection(manageExpenseDropdown, "Create Merchant");
	}

	public void selectCategoryWithinManagecategory() {
		gu.clickElement(manageCategory);
		gu.clickElement(Category);
	}

	public void clickpushNotifications() {

		pushNotifications.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Title")));

	}

	public String enteringTitleandDescription() {
		title.sendKeys("Notification");
		description.sendKeys("Add users details here");
		gu.clickElement(sendButon);
		return gu.getElementText(Allert);
	}

	public void selectManageSliderTab() {
		gu.clickElement(manageSlider);

	}

	public void selectManagePaymentMethod() {

		gu.clickElement(managePaymentMethod);
	}

	public void selectManageDeliveryBoy() {
		gu.clickElement(manageDeliveryBoy);
	}
}
