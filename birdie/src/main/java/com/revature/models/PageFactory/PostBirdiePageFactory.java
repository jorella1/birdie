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

    @FindBy(xpath="/html/body/div/div/div[3]/div/div[1]/form/div/div[1]/input")
    WebElement searchBox;

    @FindBy(xpath="/html/body/div/div/div[3]/div/div[1]/form/div/div[2]/button")
    WebElement searchButton;

    @FindBy(xpath="/html/body/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/form/button[1]")
    WebElement likeButton;

    @FindBy(xpath="/html/body/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/form/button[2]")
    WebElement commentButton;

    @FindBy(xpath="/html/body/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/form/textarea")
    WebElement commentBox;

    @FindBy(xpath="/html/body/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/form/button")
    WebElement replyButton;



    public PostBirdiePageFactory(WebDriver webDriver){
        this.webdriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    //Post a birdie
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

    //search
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

    //like
    public void like(){
        this.clickLikeButton();
    }

    public void clickLikeButton(){
        likeButton.click();
    }

    //comment
    public void comment(String comment){
        this.clickCommentButton();
        this.commentInput(comment);
        this.clickReplyButton();
    }

    public void clickCommentButton(){
        commentButton.click();
    }

    public void commentInput(String comment){
        commentBox.sendKeys(comment);
    }

    public void clickReplyButton(){
        replyButton.click();
    }
}
