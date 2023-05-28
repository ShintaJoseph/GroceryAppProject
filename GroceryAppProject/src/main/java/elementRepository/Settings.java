package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Settings {
	GeneralUtilities gu = new GeneralUtilities();
WebDriver driver;
HomePage Hp;
Settings st;
	
	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	 public void select() {
		  Hp = new HomePage(driver);
		  st = new Settings(driver);
		  Hp.selectSettingsTab();
		  
	  }
	
	
}
