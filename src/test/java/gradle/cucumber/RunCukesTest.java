package gradle.cucumber;

import cucumber.api.junit.Cucumber;

import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.core.config.Order;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json","junit:target/cucumber-results.xml"  })
public class RunCukesTest {

	public RunCukesTest(){
		
	}
}
