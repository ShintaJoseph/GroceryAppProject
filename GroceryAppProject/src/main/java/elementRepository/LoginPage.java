package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}



	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInClick;
	@FindBy(xpath = "//input[@id='remember']")
	WebElement checkBox;
	@FindBy(xpath = "//i[@class='icon fas fa-ban']")
	WebElement allert;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberMe;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement findTextAfterLogin;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement unSuccessFullLogin;
	public String signInText() {
		return gu.getElementText(signInClick);
	}

	public String getBackGroundColorSignIn() {
		return gu.getElementStyleProperty(signInClick, "background-color");
	}

	public String getBorderColorSignIn() {
		return gu.getElementStyleProperty(signInClick, "border-color");
	}

	public void enterUserName(String userNameEnter) {
		userName.sendKeys(userNameEnter);
	}

	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
		
	}

	public void signIn() {
		signInClick.click();
	}

	public void clickCheckBox() {
		rememberMe.click();

	}

	public boolean isClickCheckBox() {
		boolean b = checkBox.isSelected();
		return b;
	}

	public String getTextOfAllert() {
		return gu.getElementText(allert);

	}

	public String getTooltipOfUsername() {

		return gu.tooltipOfElement(userName);
	}
	public void performLogin(String userNameEnter,String userPassword) {
		
		enterUserName( userNameEnter);
		enterPassword( userPassword);
		signIn();
	}

	public String text() {
		return gu.getElementText(findTextAfterLogin);
		}

		public String loginInvalid() {
		return gu.getElementText(unSuccessFullLogin);
		}}