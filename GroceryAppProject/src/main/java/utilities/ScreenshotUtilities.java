package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities {
	public void captureScreenshotFailures(WebDriver driver, String image) throws IOException{
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//screenshot will store in temporary path
		  String timeStamp= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// time stored
		  File finalDestination = new File (System.getProperty("user.dir")+"\\ScreenshotImages\\"+image+timeStamp+".png");
		  FileHandler.copy(screenShot, finalDestination);
}}
