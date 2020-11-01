package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage {

    public FindTransactionsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Find Transactions")
    public WebElement FindTransactions;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(tagName = "button")
    public WebElement search;

    @FindBy(xpath = "//div[2]/div[2]/table[1]/tbody[1]/tr/td[1]")
    public List<WebElement> dateList;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> searchDescriptionList;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> searchDepositList;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> searchWithdrawalList;



    public static Date convertStringToDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = null;
        try{
            dateFormat = sdf.parse(date);
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return dateFormat;
    }
}
