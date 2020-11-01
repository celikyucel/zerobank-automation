package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){ PageFactory.initElements(Driver.get(),this); }

    @FindBy(linkText = "Zero Bank")
    public WebElement ZeroBankTitle;

    @FindBy(linkText = "Account Summary")
    public WebElement AccountSummaryPage;

    @FindBy(linkText = "Account Activity")
    public WebElement AccountActivityPage;

    @FindBy(linkText = "Transfer Funds")
    public WebElement TransferFundsPage;

    @FindBy(linkText = "Pay Bills")
    public WebElement PayBillsPage;

    @FindBy(linkText = "My Money Map")
    public WebElement MyMoneyMapPage;

    @FindBy(linkText = "Online Statements")
    public WebElement OnlineStatementsPage;

}
