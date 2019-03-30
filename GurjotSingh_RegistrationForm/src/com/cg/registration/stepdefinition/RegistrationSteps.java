package com.cg.registration.stepdefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.registration.pagebean.RegistrationBean;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {
	private WebDriver driver;  //setting up the webdriver class

	private RegistrationBean pageBean;
	
	@Before
	public void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", 
				"driver/chromedriver.exe");    //setting up the webdriver class
			driver=new ChromeDriver();
	}
	
	@Given("^User is accessing the RegistrationPage on browser$")
	public void user_is_accessing_the_RegistrationPage_on_browser() throws Throwable {
//		C:\M3Example\GurjotSingh_RegistrationForm\HtmlPages\RegistrationForm.html
		driver.get("C:\\M3Example\\GurjotSingh_RegistrationForm\\HtmlPages\\RegistrationForm.html");   //to get the registration form 
		pageBean=PageFactory.initElements(driver, RegistrationBean.class);
	}

	@Given("^Verify the title of the page \"(.*?)\"$")
	public void verify_the_title_of_the_page(String expectedTitle) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(expectedTitle,driver.getTitle().toLowerCase());
	}

	@When("^user is trying to submit data without entering 'userId'$")
	public void user_is_trying_to_submit_data_without_entering_userId() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.clickSignUp();
	}

	@Then("^\"(.*?)\" alert message should be displayed$")
	public void alert_message_should_be_displayed(String expectedMessage) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(expectedMessage, driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@When("^user is trying to submit request without entering 'password'$")
	public void user_is_trying_to_submit_request_without_entering_password() throws Throwable {
	
		pageBean.setUserId("123456");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering 'name'$")
	public void user_is_trying_to_submit_request_without_entering_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setPassword("password");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering 'address'$")
	public void user_is_trying_to_submit_request_without_entering_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setName("myname");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering 'country'$")
	public void user_is_trying_to_submit_request_without_entering_country() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setAddress("h13342");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering 'zipCode'$")
	public void user_is_trying_to_submit_request_without_entering_zipCode() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setCountry("Canada");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering valid 'emailId'$")
	public void user_is_trying_to_submit_request_without_entering_valid_emailId() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setZip("123456");
		pageBean.clickSignUp();
	}

	@When("^user is trying to submit request without entering the 'sex'$")
	public void user_is_trying_to_submit_request_without_entering_the_sex() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setEmail("z@gmail.com");
		pageBean.clickSignUp();
	}

	@When("^User is trying to submit request after entering valid set of information$")
	public void user_is_trying_to_submit_request_after_entering_valid_set_of_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageBean.setEmail("z@gmail.com");
		pageBean.setAddress("h13342");
		pageBean.setUserId("123456");
		pageBean.setCountry("Canada");
		pageBean.setZip("123456");
		pageBean.setName("myname");
		pageBean.setPassword("password");
		pageBean.setSex("Male");
		pageBean.clickSignUp();
	}
	
	@After
	public void tearDownStepEnv() {
		driver.close();
	}
}
