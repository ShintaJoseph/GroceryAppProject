package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageCategory {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	HomePage Hp;
	LoginPage lp;
	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=207&page_ad=1']")
	WebElement Delete;
	public String getTheTextOfAllertOnDeletingOneTitleInsideCategoryOptionWithinManageCategoryTab() throws IOException {
		
		
		Hp.selectCategoryWithinManagecategory();
		gu.clickElement(Delete);
		driver.switchTo().alert().accept();//to click ok button in the alert
		String Text = driver.switchTo().alert().getText();//to utility
		return Text;
	}
}
