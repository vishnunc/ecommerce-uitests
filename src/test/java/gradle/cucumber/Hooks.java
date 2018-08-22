package gradle.cucumber;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import cucumber.api.Scenario;
public class Hooks {
	
	
	@Before
	public void launchBrowser(Scenario s)
	{
		UIDriver.mystep = s;
		try 
		{
			UIDriver.configprop.load(new FileInputStream("config/config.properties"));
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			if(UIDriver.configprop.getProperty("Browser").equalsIgnoreCase("firefox"))
			{
				UIDriver.driver = new FirefoxDriver();		
			}
			else if(UIDriver.configprop.getProperty("Browser").equalsIgnoreCase("chrome"))
			{
				
				UIDriver.driver = new ChromeDriver();
			}
		
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}		
		
		
	}
	
	
	
	@After
	public void killBrowser(Scenario scenario)
	{
		if(UIDriver.configprop.getProperty("Screenshot").equals("On Failure"))
		{
			if (scenario.isFailed()) {  
				scenario.embed(UIDriver.captureScreenshot(), "image/png"); 
	        }
		}
		else
		{
			scenario.embed(UIDriver.captureScreenshot(), "image/png"); 
		}
		UIDriver.driver.quit();
		
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber.json");
		
		String buildNumber = "1";
		String projectName = "ecommerce";
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration
		configuration.setParallelTesting(parallelTesting);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Mac");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		// and here validate 'result' to decide what to do
		// if report has failed features, undefined steps etc
	}
	
}
