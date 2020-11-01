package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Account Activity")
    public WebElement AccountActivityPage;

    @FindBy(linkText = "Show Transactions")
    public WebElement ShowTransactions;

    @FindBy(linkText = "Find Transactions")
    public WebElement FindTransactions;

    @FindBy(tagName = "select")
    public WebElement Account;

    @FindBy(xpath = "//tr/th")
    public List<WebElement> transactionsColumns;

}
