package com.revature.StepDefinitions;

import org.testng.Assert;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostBirdieSteps {

 @Given("a user is on dashboard page")
 public void a_user_is_on_dashboard_page() throws InterruptedException{
  TestRunner.driver.get("http://localhost:9090/dashboard/54");
   Thread.sleep(2000);
 }
    
 @When("a user writes a post")
 public void a_user_writes_a_post() throws InterruptedException{
  TestRunner.postBirdiePageFactory.inputPost("Automation Testing");
    Thread.sleep(1000);
 }

 @When("a user clicks on post button")
 public void a_user_clicks_on_post_button() throws InterruptedException{
  TestRunner.postBirdiePageFactory.clickPostButton();
    Thread.sleep(1000);

 }

 @Then("the post is displayed below")
 public void the_post_is_displayed_below() throws InterruptedException{
        Assert.assertEquals(TestRunner.driver.getCurrentUrl(), "http://localhost:9090/dashboard/54");
        Thread.sleep(1000);
 }

 @When("a user enters text to search")
 public void a_user_enters_text_to_search() throws InterruptedException{
  TestRunner.postBirdiePageFactory.inputText("Automation");
   Thread.sleep(1000);
 }

 @When("a user clicks on search button")
 public void a_user_clicks_on_search_button() throws InterruptedException{
  TestRunner.postBirdiePageFactory.clickSearchButton();
   Thread.sleep(1000);
 }

 @Then("the expected text result page will display")
 public void the_expected_text_result_page_will_display() throws InterruptedException{
  Assert.assertEquals(TestRunner.driver.getCurrentUrl(),"http://localhost:9090/searchpage/54");
  Thread.sleep(1000);
 } 

 @When("a user clicks on like button")
 public void a_user_clicks_on_like_button() throws InterruptedException{
  TestRunner.postBirdiePageFactory.clickLikeButton();
  Thread.sleep(500);
 }

 @Then("the post gets likes")
 public void the_post_gets_likes() throws InterruptedException{
  Assert.assertEquals(TestRunner.driver.getCurrentUrl(), "http://localhost:9090/dashboard/54");
        Thread.sleep(1000);
 }

 @When("a user clicks on comment button")
 public void a_user_clicks_on_comment_button() throws InterruptedException{
  TestRunner.postBirdiePageFactory.clickCommentButton();
  Assert.assertEquals(TestRunner.driver.getCurrentUrl(),"http://localhost:9090/posting/54/487?");
  Thread.sleep(1000);
 }

 @When("a user writes a comment")
 public void a_user_writes_a_comment() throws InterruptedException{
  TestRunner.postBirdiePageFactory.commentInput("True");
  Thread.sleep(500);
 }

 @When("a user clicks on reply button")
 public void a_user_clicks_on_reply_button() throws InterruptedException{
  TestRunner.postBirdiePageFactory.clickReplyButton();
  Thread.sleep(500);
 }

 @Then("a comment gets posted")
 public void a_comment_gets_posted() throws InterruptedException{
 TestRunner.driver.get("http://localhost:9090/posting/54/487?");
 Thread.sleep(2000);
 }

}
