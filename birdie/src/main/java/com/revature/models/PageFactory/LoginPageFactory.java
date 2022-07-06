package com.revature.models.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver webdriver;

    @FindBy(id="name")
    WebElement usernameInput;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div[2]/div[2]/form[1]/div[2]/input")
    WebElement passwordInput;

    @FindBy(id="loginbtn")
    WebElement loginButton;



    public LoginPageFactory(WebDriver webDriver){
        this.webdriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void login(String username, String password){
        this.inputUsername(username);
        this.inputPassword(password);
        this.clickLoginButton();

    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void inputUsername(String username) {
        usernameInput.sendKeys(username);
    }

}
