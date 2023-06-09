package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManagePages {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	WaitUtility wu = new WaitUtility();

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement managePage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=832&page_ad=1']")
	WebElement actionButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='update']")
	WebElement update;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement Allert;


	public String clickOnManageContentAndSelectManagePage() {
		gu.clickElement(manageContent);
		gu.clickElement(managePage);
		wu.waitExplicit(driver);

	int rowvalue = gu.clickDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Mango") + 1;

		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowvalue
				+ "]//td[4]";

		WebElement pageValue = driver.findElement(By.xpath(locator));
		String text = pageValue.getText();
		return text;
	}

	public String fileUploadOnEditButtonInsideActionOfTitlejm() throws Exception {
	
		gu.clickElement(manageContent);
		gu.clickElement(managePage);
		gu.clickElement(actionButton);
		wu.waitExplicit(driver);
		gu.uploadFile(driver, chooseFileButton, "C:\\Users\\gods\\selenium screenshot\\screenshot.jpeg");
		gu.clickElement(update);
		return gu.getElementText(Allert);

	}
	
}
