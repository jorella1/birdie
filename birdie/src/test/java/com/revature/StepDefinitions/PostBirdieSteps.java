package com.revature.StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.revature.models.PageFactory.PostBirdiePageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostBirdieSteps {

    public WebDriver driver;
    public PostBirdiePageFactory postBirdiePageFactory;

 @Given("a user is on dashboard page")
 public void a_user_is_on_dashboard_page(){
   driver.navigate().to("http://localhost:9090/dashboard/21");
 }
    
 @When("a user writes a post")
 public void a_user_writes_a_post(){
    postBirdiePageFactory.inputPost("Testing BDD");
 }

 @When("a user clicks on post button")
 public void a_user_clicks_on_post_button(){
    postBirdiePageFactory.clickPostButton();

 }

 @Then("the post is displayed below")
 public void the_post_is_displayed_below(){
    driver.navigate().refresh();
 }

}
