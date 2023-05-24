package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSlider {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	HomePage Hp;

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='link']")
	WebElement link;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement Alert;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-restore']")
	WebElement manageSlider;

	public String clickNewButtonAndEnterLinkPressSaveButtonThenGetTextOfAllert() {
		Hp = new HomePage(driver);
		Hp.selectManageSliderTab();
		// gu.clickElement(manageSlider);
		selectNewButton();
		clickLinkAndGiveInput();
		clickSaveButton();
		String Text = gu.getElementText(Alert);
		return Text;
	}

	public void clickManageSliderTab() {
		Hp.selectManageSliderTab();
	}

	public void selectNewButton() {
		gu.clickElement(newButton);
	}

	public void clickLinkAndGiveInput() {
		gu.clickElementAndGiveInput(link, "https://www.amazon.in/");
	}

	public void clickSaveButton() {
		gu.clickElement(saveButton);
	}


}
