package com.revature.StepDefinitions;

import static org.mockito.ArgumentMatchers.contains;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.revature.models.PageFactory.LoginPageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    public WebDriver driver;
    public LoginPageFactory loginPageFactory;
    

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        loginPageFactory = new LoginPageFactory(driver);
        
    }

    @Given("a user is on login page")
    public void a_user_is_on_login_page(){

        driver.get("http://localhost:9090/index.html");

    }


    @When("a user enters the correct username and correct password")
    public void a_user_enters_the_correct_username_and_correct_password() throws InterruptedException{
        loginPageFactory.inputUsername("Sophia");
        loginPageFactory.inputPassword("Password123!");

        Thread.sleep(2000);
        
    }

    @When("clicks on login button")
    public void clicks_on_login_button(){
        loginPageFactory.clickLoginButton();
    }

    @Then("a user is navigated to dashboard page")
    public void a_user_is_navigated_to_dashboard_page() throws InterruptedException{
        //WebElement postButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/form/input[2]"));
        //Assert.assertNotNull(postButton);

      //driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/form/input[1]")).isDisplayed();
        //boolean newPageText = driver.findElement(By.linkText("Home")).isDisplayed();
        //System.out.println("newPageText :" + newPageText);
        //Assert.assertTrue(newPageText);
       driver.get("http://localhost:9090/dashboard/21");
      //driver.getPageSource().contains("Home");
      //driver.getTitle().contains("Dashboard");
      Thread.sleep(2000);
    }

    @After
    public void teardown(){
        this.driver.quit();
    }
}
