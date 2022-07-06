package com.revature.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.revature.models.PageFactory.PostBirdiePageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostBirdieSteps {

    public WebDriver driver;
    public PostBirdiePageFactory postBirdiePageFactory;


    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://localhost:9090/dashboard/21");
        
        postBirdiePageFactory = new PostBirdiePageFactory(driver);
        
    }
    

 @Given("a user is on dashboard page")
 public void a_user_is_on_dashboard_page() throws InterruptedException{
  Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:9090/dashboard/21");
   Thread.sleep(2000);
 }
    
 @When("a user writes a post")
 public void a_user_writes_a_post() throws InterruptedException{
    postBirdiePageFactory.inputPost("Automation Testing");
    Thread.sleep(10000);
 }

 @When("a user clicks on post button")
 public void a_user_clicks_on_post_button() throws InterruptedException{
    postBirdiePageFactory.clickPostButton();
    Thread.sleep(10000);

 }

 @Then("the post is displayed below")
 public void the_post_is_displayed_below() throws InterruptedException{
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:9090/dashboard/21");
        Thread.sleep(2000);
    //driver.navigate().refresh();
 }

/*  @When("a user enters text to search")
 public void a_user_enters_text_to_search() throws InterruptedException{
   postBirdiePageFactory.inputText("Testing BDD");
   Thread.sleep(10000);
 }

 @When("a user clicks on search button")
 public void a_user_clicks_on_search_button() throws InterruptedException{
   postBirdiePageFactory.clickSearchButton();
   Thread.sleep(10000);
 }

 @Then("the expected text result page will display")
 public void the_expected_text_result_page_will_display(){
  driver.navigate().to("http://localhost:9090/searchpage/21");
 } */

  @After
    public void teardown(){
        this.driver.quit();
    } 

}
