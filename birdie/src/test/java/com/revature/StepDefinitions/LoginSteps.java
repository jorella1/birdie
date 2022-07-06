package com.revature.StepDefinitions;

import org.testng.Assert;
import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    

    @Given("a user is on login page")
    public void a_user_is_on_login_page(){
        TestRunner.driver.get("http://localhost:9090/index.html");
        //Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/index.html");
    }


    @When("a user enters the correct username and correct password")
    public void a_user_enters_the_correct_username_and_correct_password() throws InterruptedException{
        TestRunner.loginPageFactory.inputUsername("Sophia");
        TestRunner.loginPageFactory.inputPassword("Password123@");

        Thread.sleep(2000);
        
    }

    @When("clicks on login button")
    public void clicks_on_login_button(){
        TestRunner.loginPageFactory.clickLoginButton();
    }

    @Then("a user is navigated to dashboard page")
    public void a_user_is_navigated_to_dashboard_page() throws InterruptedException{
       Assert.assertEquals(TestRunner.driver.getCurrentUrl(), "http://localhost:9090/dashboard/54");
       Thread.sleep(2000);
    }

}
