package com.revature.models.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory {
    WebDriver webdriver;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[2]/div[1]/label[2]")
    WebElement signupForm;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[2]/div[2]/form[2]/div[1]/input")
    WebElement nameInput;

    @FindBy(id="pass")
    WebElement passwordInput;

    @FindBy(id="confirmpass")
    WebElement confirmPasswordInput;

    @FindBy(id="admin")
    WebElement admin;

    @FindBy(id="signupbtn")
    WebElement signupButton;


    public RegisterPageFactory(WebDriver webDriver){
        this.webdriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public void register(String username, String password, String confirmpassword){
        this.clickSignupForm();
        this.inputUsername(username);
        this.inputPassword(password);
        this.inputConfirmPassword(confirmpassword);
        this.checksAdminOption();
        this.clickSignupButton();

    }

    

    public void clickSignupForm() {
        signupForm.click();
    }


    public void clickSignupButton() {
        signupButton.click();
    }


    public void checksAdminOption() {
        admin.click();
    }

    public void inputConfirmPassword(String confirmpassword) {
        confirmPasswordInput.sendKeys(confirmpassword);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void inputUsername(String username) {
        nameInput.sendKeys(username);
    }
}
