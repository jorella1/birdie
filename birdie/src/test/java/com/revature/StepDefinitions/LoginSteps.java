package com.revature.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://www.google.com/");
    }

    @Given("a user is on login page")
    public void a_user_is_on_login_page(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    @When("a user enters the correct username and correct password")
    public void a_user_enters_the_correct_username_and_correct_password(){
        System.out.println("Input correct username and password");
        
    }

    @When("clicks on login button")
    public void clicks_on_login_button(){
        System.out.println("Clicks on button");
    }

    @Then("a user is navigated to next page")
    public void a_user_is_navigated_to_next_page(){
        System.out.println("User is navigated");
    }

    @After
    public void teardown(){
        this.driver.quit();
    }
}
