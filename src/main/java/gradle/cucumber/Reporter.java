package gradle.cucumber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class Reporter{

	public static void main(String[] args) throws InterruptedException{
		Thread.sleep(3000);
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
		System.out.println("Completed!");
	}
}