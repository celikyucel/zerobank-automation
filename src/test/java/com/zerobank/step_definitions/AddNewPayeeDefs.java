package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addNewPayeeTab.click();
        BrowserUtils.waitFor(2);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userInfo) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payee_name.sendKeys(userInfo.get("Payee Name"));
        payBillsPage.payee_address.sendKeys(userInfo.get("Payee Address"));
        payBillsPage.payee_account.sendKeys(userInfo.get("Account"));
        payBillsPage.payee_details.sendKeys(userInfo.get("Payee details"));
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.message.getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
