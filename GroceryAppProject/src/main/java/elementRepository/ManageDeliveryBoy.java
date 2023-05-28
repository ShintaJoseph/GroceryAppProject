package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;


public class ManageDeliveryBoy {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	LoginPage Lp;
	HomePage Hp;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement allert;
	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory 
	}
	public String updateDetailsOfNewDeliveryBoy() throws IOException {
		Lp = new LoginPage(driver);
		Lp.performLogin(ExcelReadUtility.read("Sheet1",1, 0),ExcelReadUtility.read("Sheet1",1, 1));
		Hp = new HomePage(driver);
		Hp.selectManageDeliveryBoy();
		
		gu.clickElement(newButton);
		gu.clickElement(name);
		name.sendKeys("Arun");
		gu.clickElement(userName);
		userName.sendKeys("Arun");
		gu.clickElement(password);
		password.sendKeys("Arun");
		gu.clickElement(save);
		return gu.getElementText(allert);
	}
}

