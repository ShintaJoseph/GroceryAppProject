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
	HomePage hp;
	LoginPage lp;
	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=207&page_ad=1']")
	WebElement delete;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryInput;
	@FindBy(xpath = "//span[text()='Category']")
	WebElement selectGroups;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	
	public String getTheTextOfAllertOnDeletingOneTitleInsideCategoryOptionWithinManageCategoryTab() throws IOException {
		
		
		hp.selectCategoryWithinManagecategory();
		gu.clickElement(delete);
		driver.switchTo().alert().accept();
		String Text = driver.switchTo().alert().getText();
		return Text;}
	
	public String getTheTextOfAllertOnAddingANewCategory() {
		hp = new HomePage(driver);
		hp.selectCategoryWithinManagecategory();
		gu.clickElement(newButton);
		gu.clickElementAndGiveInput(categoryInput,"Fruits");
		gu.clickElement(selectGroups);
		gu.clickElement(saveButton);
	    return gu.getElementText(alert);
	}
}
