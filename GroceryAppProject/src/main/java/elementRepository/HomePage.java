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
	@FindBy(linkText = "//i[@class='nav-icon fas fa-list-alt']")
	WebElement manageCategory;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[1]")
	WebElement category;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-restore']")
	WebElement manageSlider;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-credit-card']")
	WebElement managePaymentMethod;
	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement manageDeliveryBoy;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement managePage;
	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement settingsTab;

	public String selectManageExpenseDropdown() {
		return gu.dropdownSelection(manageExpenseDropdown, "Create Merchant");
	}

	public void selectCategoryWithinManagecategory() {
		gu.clickElement(manageCategory);
		gu.clickElement(category);
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
	public void selectManagePages() {
		gu.clickElement(managePage);
	}
	public void selectmanageContent() {
		gu.clickElement(manageContent);
	}
	public void selectSettingsTab() {
		gu.clickElement(settingsTab);
	}
}
