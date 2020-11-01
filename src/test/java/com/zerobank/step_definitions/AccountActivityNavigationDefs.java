package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        String username = ConfigurationReader.get("user_username");
        String password = ConfigurationReader.get("user_password");

        new LoginPage().login(username,password);
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().savings.click();
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().brokerage.click();
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().checking.click();
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().creditCard.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().loan.click();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedPage) {
        DashboardPage dashboardPage = new DashboardPage();
        String actualPage = dashboardPage.AccountActivityPage.getText();
        Assert.assertEquals(expectedPage,actualPage);
        BrowserUtils.waitFor(2);
    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String defaultOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountDropdown = new Select(accountActivityPage.Account);
        String actualOption = accountDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(defaultOptions,actualOption);
    }


}
