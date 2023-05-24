package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManagePaymentMethod {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/Methods?statusid=2&st=Disabled&page_ad=1']")
	WebElement ActiveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement Alert;
	public ManagePaymentMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String clickActiveButtonAndGetTheTextOfAllert() {
		gu.clickElement(ActiveButton);
		String Text =gu.getElementText(Alert);
	  return Text;
		
	}
}
