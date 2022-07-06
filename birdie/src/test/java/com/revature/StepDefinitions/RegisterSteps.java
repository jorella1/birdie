package com.revature.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.revature.models.PageFactory.RegisterPageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
    public WebDriver driver;
    public RegisterPageFactory registerPageFactory;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://localhost:9090/index.html");
        
        registerPageFactory = new RegisterPageFactory(driver);
        
    }


    @Given("a user is on signup page")
    public void a_user_is_on_signup_page(){
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/index.html");
    }

    @When("a user clicks on signup option")
    public void a_user_clicks_on_signup_option(){
        registerPageFactory.clickSignupForm();
    }

    @When("a user enters the correct username and correct password and confirm password")
    public void a_user_enters_the_correct_username_and_correct_password_and_confirm_password() throws InterruptedException{
        registerPageFactory.inputUsername("tester");
        registerPageFactory.inputPassword("Tester123@");
        registerPageFactory.inputConfirmPassword("Tester123@");
        Thread.sleep(2000);
    }


    @When("a user checks on are you admin option")
    public void a_user_checks_on_are_you_admin_option() throws InterruptedException{
        registerPageFactory.checksAdminOption();
        Thread.sleep(2000);
    }

    @When("clicks on signup button")
    public void clicks_on_signup_button(){
        registerPageFactory.clickSignupButton();
    }

    @Then("a user is navigated to index page")
    public void a_user_is_navigated_to_index_page() throws InterruptedException{
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/index.html");
        Thread.sleep(2000);
    }
    
    @After
    public void teardown(){
        this.driver.quit();
    } 
}
