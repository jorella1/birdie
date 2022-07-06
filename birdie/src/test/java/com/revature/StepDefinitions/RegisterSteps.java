package com.revature.StepDefinitions;

import org.testng.Assert;
import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {

    @Given("a user is on signup page")
    public void a_user_is_on_signup_page(){
        TestRunner.driver.get("http://localhost:9090/index.html");
    }

    @When("a user clicks on signup option")
    public void a_user_clicks_on_signup_option(){
        TestRunner.registerPageFactory.clickSignupForm();
    }

    @When("a user enters the correct username and correct password and confirm password")
    public void a_user_enters_the_correct_username_and_correct_password_and_confirm_password() throws InterruptedException{
        TestRunner.registerPageFactory.inputUsername("testss");
        TestRunner.registerPageFactory.inputPassword("Tester123@");
        TestRunner.registerPageFactory.inputConfirmPassword("Tester123@");
        Thread.sleep(2000);
    }


    @When("a user checks on are you admin option")
    public void a_user_checks_on_are_you_admin_option() throws InterruptedException{
        TestRunner.registerPageFactory.checksAdminOption();
        Thread.sleep(2000);
    }

    @When("clicks on signup button")
    public void clicks_on_signup_button(){
        TestRunner.registerPageFactory.clickSignupButton();
    }

    @Then("a user is navigated to index page")
    public void a_user_is_navigated_to_index_page() throws InterruptedException{
        Assert.assertEquals(TestRunner.driver.getCurrentUrl(), "http://localhost:9090/index.html");
        Thread.sleep(2000);
    }
     
}
