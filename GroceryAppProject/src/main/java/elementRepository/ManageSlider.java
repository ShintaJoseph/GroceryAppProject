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
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement Allert;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-restore']")
	WebElement manageSlider;
	 public String clickNewButtonAndEnterLinkPressSaveButtonThenGetTextOfAllert() {
		 gu.clickElement(manageSlider);//to single methods
		  gu.clickElement(newButton);
		  gu.clickElement(link);
		  link.sendKeys("https://www.amazon.in/");
		  gu.clickElement(saveButton);
		  String Text = driver.switchTo().alert().getText();//not javascript allert
		  return Text;
	  }
	
}
