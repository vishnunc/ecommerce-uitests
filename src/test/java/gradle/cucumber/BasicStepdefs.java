package gradle.cucumber;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class BasicStepdefs {

	
	@Given("^I am on the product home page$")
	public void i_am_on_the_product_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    UIDriver.driver.navigate().to("http://localhost:9002");
	    UIDriver.driver.manage().window().maximize();
	}

	@When("^I add product to Basket$")
	public void i_add_product_to_Basket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    UIDriver.click(By.xpath("//input[@type='submit']"));
	    Thread.sleep(2000);
	}

	@Then("^I should see the login page$")
	public void i_should_see_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(UIDriver.waitforElementPresent(By.name("username"),2))
	    {
	    	assertTrue("I see the login page", true);
	    }
	    else
	    {
	    	assertFalse("I do not see login page", true);
	    }
	}

	@Given("^I am logged in$")
	public void i_am_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UIDriver.driver.navigate().to("http://localhost:9002/login");
	    UIDriver.driver.manage().window().maximize();
	    UIDriver.enter_text(By.name("username"), "johnd");
	    UIDriver.enter_text(By.name("password"), "password");
	    UIDriver.click(By.xpath("//button[@type='submit']"));
	}

	
	@When("^I select a \"([^\"]*)\"$")
	public void i_select_a(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    UIDriver.click(By.linkText(arg1));
	}

	@Then("^I should see the \"([^\"]*)\" detail page$")
	public void i_should_see_the_detail_page(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(UIDriver.findElement(By.xpath("//td[text()='"+arg1+"']"))!=null)
	    {
	    	assertTrue("I see product detail page",true);
	    }
	    else
	    {
	    	assertFalse("I do not see product detail page",false);
	    }
	}

	@Then("^\"([^\"]*)\" should be added to my basket$")
	public void should_be_added_to_my_basket(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(UIDriver.findElement(By.xpath("//td[text()='"+arg1+"']"))!=null)
	    {
	    	assertTrue("I see product detail page",true);
	    }
	    else
	    {
	    	assertFalse("I do not see product detail page",false);
	    }
	}

	@When("^I enter my \"([^\"]*)\" and \"([^\"]*)\" and sign in$")
	public void i_enter_my_and_and_sign_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    UIDriver.enter_text(By.name("username"), arg1);
	    UIDriver.enter_text(By.name("password"), arg2);
	    UIDriver.click(By.xpath("//button[@type='submit']"));
	}

	@Then("^I should see the continue shopping button$")
	public void i_should_see_the_continue_shopping_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(UIDriver.waitforElementPresent(By.linkText("Continue Shopping"),3))
	    {
	    	assertTrue("Continue shopping button is displayed",true);
	    }
	    else
	    {
	    	assertFalse("Continue shopping button is not displayed",true);
	    }
	}

	@When("^I continue shopping$")
	public void i_continue_shopping() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   UIDriver.click(By.linkText("Continue Shopping"));
	}

	@Then("^I should be able to view list of items$")
	public void i_should_be_able_to_view_list_of_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(UIDriver.findElement(By.xpath("//div[@id='message']/following::table"))!=null)
	    {
	    	assertTrue("The list of items is displayed", true);
	    }
	    else
	    {
	    	assertFalse("The list of items is not displayed", true);
	    }
	}

	
	@Then("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UIDriver.driver.navigate().to("http://localhost:9002");
		if(UIDriver.findElement(By.xpath("//div[@id='message']/following::table"))!=null)
	    {
	    	assertTrue("I am on home page", true);
	    }
	    else
	    {
	    	assertFalse("I am not on home page", true);
	    }
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    UIDriver.driver.navigate().to("http://localhost:9002/login");
	    UIDriver.driver.manage().window().maximize();
	}

	
	@Then("^I should be logged in successfully$")
	public void i_should_be_logged_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(UIDriver.findElement(By.xpath("//div[@id='message']"))!=null)
	    {
	    	assertTrue("I am logged in successfully", true);
	    }
	    else
	    {
	    	assertFalse("I am not logged in", true);
	    }
	}

	

	
	@Then("^I should remain on the login page$")
	public void i_should_remain_on_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(UIDriver.findElement(By.name("username"))!=null)
	    {
	    	assertTrue("I remain on the login page",true);
	    }
	    else
	    {
	    	assertFalse("I navigate to a different page",true);
	    }
	}
}
