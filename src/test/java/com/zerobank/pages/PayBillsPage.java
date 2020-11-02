package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div/span")
    public WebElement submitMessage;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id ="pay_saved_payees")
    public WebElement payButton;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayeeTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement payee_name;

    @FindBy(id = "np_new_payee_address")
    public WebElement payee_address;

    @FindBy(id = "np_new_payee_account")
    public WebElement payee_account;

    @FindBy(id = "np_new_payee_details")
    public WebElement payee_details;

    @FindBy(xpath = "//input[@value='Add']")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public  WebElement message;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCosts;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseCash;
}
