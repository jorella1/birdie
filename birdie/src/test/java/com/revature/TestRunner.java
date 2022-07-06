package com.revature;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.revature.models.PageFactory.LoginPageFactory;
import com.revature.models.PageFactory.PostBirdiePageFactory;
import com.revature.models.PageFactory.RegisterPageFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber.html"},
    features = "src/test/resources/features",
    glue = {"com/revature/StepDefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static WebDriverWait explicitWait;

    //PageFactories

    public static LoginPageFactory loginPageFactory;
    public static RegisterPageFactory registerPageFactory;
    public static PostBirdiePageFactory postBirdiePageFactory;

    @BeforeClass
    public static void setup(){
       
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //pagefactories
        loginPageFactory = new LoginPageFactory(driver);
        registerPageFactory = new RegisterPageFactory(driver);
        postBirdiePageFactory = new PostBirdiePageFactory(driver);


        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Set up Complete!");

    }

    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("teardown complete");
    }

}
