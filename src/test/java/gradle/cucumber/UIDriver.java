package gradle.cucumber;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.Scenario;


/**
 * 
 * @author IN00430
 * This library is to define all the Selenium WebDriver methods that can be used in the step definitions
 *
 */
public class UIDriver {
	
	public static WebDriver driver;
	public static Properties configprop=new Properties();
	public static Scenario mystep;
	
	/**
	 * Actions
	 */
	public static boolean click(By ele)
	{
		try
		{
			findElement(ele).click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean enter_text(By ele,String val)
	{
		try
		{
			
			findElement(ele).clear();
			findElement(ele).sendKeys(val);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean mouseOver(By ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(findElement(ele));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static WebElement findElement(By ele)
	{
		try
		{
			WebElement web = driver.findElement(ele);
			return web;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public static boolean waitforElementPresent(By ele,int secs) throws InterruptedException
	{
		int timecount=0;
		while(timecount<secs)
		{
			if(findElement(ele)!=null)
			{
				return true;
			}
			Thread.sleep(1000);
			timecount=timecount+1;
		}
		return false;
	}
	
	public static String getElementText(By ele)
	{
		if(findElement(ele)!=null)
		{
			return findElement(ele).getText();
		}
		else
		{
			return null;
		}
	}
	
	public static byte[] captureScreenshot()
	{
		try {  
            byte[] screenshot = ((TakesScreenshot) UIDriver.driver).getScreenshotAs(OutputType.BYTES);  
            return screenshot;
        } catch (WebDriverException wde) {  
            System.err.println(wde.getMessage()); 
            return null;
        } catch (ClassCastException cce) {  
            cce.printStackTrace(); 
            return null;
        } 
	}
	
}
