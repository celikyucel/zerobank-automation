package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@*='signin_button']")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    public WebElement errorMessage;

    public void login(String userNameStr, String passwordStr) {
        signinButton.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }

}
