package com.salesforce.automation.stepDef;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.salesforce.automation.pages.home.HomePage;
import com.salesforce.automation.pages.login.ForgotPasswordPage;
import com.salesforce.automation.pages.login.LoginPage;
import com.salesforce.automation.utilities.CommonUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class salesforceStepDef extends CommonUtilities{
	
	@Before(order=0)
	public void setUp1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	@Before(order=1) // we can have multiple befores and afters using order parameter mention order sequence
	public void setUp2() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().window().maximize();
	}
	
	public void untilPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}
	
	@Given("User open salesforce application")
	public void user_open_firebase_application() {
		driver.get("https://login.salesforce.com/");
	}
	WebDriver driver=null;
	LoginPage login;
	HomePage home;
	ForgotPasswordPage fgpw;

	@When("user is on {string}")
	public void user_is_on(String page) {
	   if(page.equalsIgnoreCase("loginpage"))
		   login=new LoginPage(driver);
	   else if(page.equalsIgnoreCase("homepage"))
		   home= new HomePage(driver);
	   else if(page.equalsIgnoreCase("ForgotPasswordPage"))
		   fgpw= new ForgotPasswordPage(driver);
		   
	}

	
	@When("user enter value of username {string} and emptypassword {string}")
	public void user_enter_value_of_username_and_emptypassword(String usname, String passwd) { 
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		usname = getApplicationProperty("valid-username",userPropertyFile);
		passwd = getApplicationProperty("empty-password",userPropertyFile);
		
		try {
			login.login(usname,passwd);
			System.out.println("Value of username and password got entered");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	@When("user enter value of validUsername {string} and validPassword {string}")
	public void user_enter_value_of_valid_username_and_valid_password(String usname, String passwd) {
		
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		usname = getApplicationProperty("valid-username",userPropertyFile);
		passwd = getApplicationProperty("valid-password",userPropertyFile);
		
		try {
			login.login(usname,passwd);
			System.out.println("Value of username and password got entered");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	@When("user enter value of username {string} and password {string}")
	public void user_enter_value_of_username_and_password(String usname, String passwd) {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		usname = getApplicationProperty("valid-username",userPropertyFile);
		passwd = getApplicationProperty("valid-password",userPropertyFile);
		
		try {
			login.login(usname,passwd);
			System.out.println("Value of username and password got entered");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		try {
			login.clickLoginButton();
			untilPageLoad();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	@Then("Verify the error message {string}")
	public void verify_the_error_message(String errorExpected) {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		errorExpected=getApplicationProperty("empty-password-error",userPropertyFile);
		String actual = login.getErrorMessage();
		Assert.assertEquals(actual,errorExpected);
	}


	@Then("Verify page title {string}")
	public void verify_page_title(String actualTitle) {
		actualTitle=home.getPageTitle();
		System.out.println("actual Title"+actualTitle);
	    CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
	    String expectedTitle=getApplicationProperty("home-page-title",userPropertyFile);
	    Assert.assertEquals(actualTitle,expectedTitle);
	    
	}

	@When("user click remember check box")
	public void user_click_remember_check_box() {
	    try {
			login.clickRememberMe();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("click on the username")
	public void click_on_the_username() {
		home.clickUserName();
	    
	}
	
	@Then("click on logout button from user drop down menu")
	public void click_on_logout_button_from_user_drop_down_menu() {
	   home.clickLogout();
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	
	}

	@Then("Validate username field as {string}")
	public void validate_username_field_as(String actualUserName) {
		actualUserName=login.getUserName();
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		String expectedUsername = getApplicationProperty("valid-username",userPropertyFile);
		Assert.assertEquals(actualUserName, expectedUsername);
		
	}


	@When("user click on forgot password button")
	public void user_click_on_forgot_password_button() {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
	    try {
			login.clickForgotPasswordButton();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("enter username as {string}")
	public void enter_username_as(String username) {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		username = getApplicationProperty("valid-username",userPropertyFile);
		try {
			fgpw.enterForgotPasswordUserName(username);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Then("click on continue button")
	public void click_on_continue_button() {
	   try {
		fgpw.clickContinueForgotPassword();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Then("verify the message sent in email as {string}")
	public void verify_the_message_sent_in_email_as(String emailConfirmationMessage) {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		emailConfirmationMessage=getApplicationProperty("email-sent-confirmation", userPropertyFile);
		String actualConfirmationMessage=fgpw.getConfirmationMessage();
		Assert.assertEquals(actualConfirmationMessage, emailConfirmationMessage);
	}
	
	
	
	@When("user enter value of invalidusername {string} and invalidpassword {string}")
	public void user_enter_value_of_invalidusername_and_invalidpassword(String usname, String passwd) {
	    
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		System.out.println("enetring property value");
		usname = getApplicationProperty("invalid-usernm",userPropertyFile);
		passwd = getApplicationProperty("invalid-pw",userPropertyFile);
		
		try {
			login.login(usname,passwd);
			System.out.println("Value of username and password got entered");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Then("error message should be displayed {string}")
	public void error_message_should_be_displayed(String invalidLoginErrorMessage) {
		CommonUtilities cu = new CommonUtilities();
		Properties userPropertyFile=cu.loadFile("user");
		invalidLoginErrorMessage= getApplicationProperty("invalid-login-error-message", userPropertyFile);
		String actualErrorMessage=login.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, invalidLoginErrorMessage, "Test Case passed");  
	}
	
	@After
	public void tearDown() {
		driver.close();
	}	
}

