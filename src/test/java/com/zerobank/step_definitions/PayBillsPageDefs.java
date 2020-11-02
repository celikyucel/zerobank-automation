package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class PayBillsPageDefs {

    @Then("the user is on the Pay Bills Page")
    public void the_user_is_on_the_Pay_Bills_Page() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.PayBillsPage.click();
        dashboardPage.PayBillsPage.isDisplayed();
        BrowserUtils.waitFor(2);
    }

    @Then("Pay Bills page title contains {string}")
    public void pay_Bills_page_title_contains(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user enters the amount and date")
    public void the_user_enters_the_amount_and_date() {
        PayBillsPage payBillsPage = new PayBillsPage();

        payBillsPage.amount.sendKeys("50");
        payBillsPage.date.sendKeys("2020-11-30");

        BrowserUtils.waitFor(2);
        payBillsPage.payButton.click();


    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedMessage) {
        String actualMessage = new PayBillsPage().submitMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("the user doesn't enter the amount field")
    public void the_user_doesn_t_enter_the_amount_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.date.sendKeys("2020-10-30");

        BrowserUtils.waitForClickablility(payBillsPage.payButton,3);
        payBillsPage.payButton.click();

    }

    @When("the user doesn't enter the date field")
    public void the_user_doesn_t_enter_the_date_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("50");

        BrowserUtils.waitForClickablility(payBillsPage.payButton,3);
        payBillsPage.payButton.click();

    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedText) {
        String actualText = new PayBillsPage().amount.getAttribute("validationMessage");
        if (actualText.equals("")){
            actualText = new PayBillsPage().date.getAttribute("validationMessage");
        }
        Assert.assertEquals(expectedText,actualText);
        System.out.println("actualText = " + actualText);
    }

    @When("the user enters alphabetical characters in the amount field and valid characters in the date field")
    public void the_user_enters_alphabetical_characters_in_the_amount_field_and_valid_characters_in_the_date_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("abc@");

        payBillsPage.date.sendKeys("2020-10-30");

        BrowserUtils.waitForClickablility(payBillsPage.payButton,3);
        payBillsPage.payButton.click();

    }

    @When("the user enters valid characters in the amount field and alphabetical characters in the date field")
    public void the_user_enters_valid_characters_in_the_amount_field_and_alphabetical_characters_in_the_date_field() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.amount.sendKeys("50");
        payBillsPage.date.sendKeys("abcdef");

        BrowserUtils.waitForClickablility(payBillsPage.payButton,3);
        payBillsPage.payButton.click();

    }

    @Then("{string} should be not displayed")
    public void should_be_not_displayed(String expectedMessage) {
      Assert.assertNotEquals(expectedMessage,new PayBillsPage().submitMessage.getText());
    }

}
