package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);}

  //  @FindBy(xpath = "//*[@class='board-header']")
  //  @FindBy(css = "h2.board-header")
    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(linkText = "Savings")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;


}
