package com.revature.models.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostBirdiePageFactory {
    WebDriver webdriver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/textarea")
    WebElement postInput;

    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/input[2]")
    WebElement postButton;

    @FindBy(name = "searchField")
    WebElement searchBox;

    @FindBy(name = "searchBtn")
    WebElement searchButton;

    public PostBirdiePageFactory(WebDriver webDriver){
        this.webdriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public void post(String post){
        this.inputPost(post);
        this.clickPostButton();

    }

    public void clickPostButton() {
        postButton.click();
    }

    public void inputPost(String post) {
        postInput.sendKeys(post);
    }

    public void search(String text){
        this.inputText(text);
        this.clickSearchButton();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void inputText(String text) {
        searchBox.sendKeys(text);
    }
}
