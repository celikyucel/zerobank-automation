package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPageDefs {

    @Then("the user is on the Account Activity Page")
    public void the_user_is_on_the_Account_Activity_Page() {
       DashboardPage dashboardPage = new DashboardPage();
       dashboardPage.AccountActivityPage.click();
       dashboardPage.AccountActivityPage.isDisplayed();
       BrowserUtils.waitFor(2);
    }

    @Then("Account Activity page title contains {string}")
    public void account_Activity_page_title_contains(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("In the Account drop	down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be(String defaultOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select accountDropdown = new Select(accountActivityPage.Account);
        String actualOption = accountDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(defaultOptions,actualOption);
    }

    @Then("In the Account dropdown should be following options")
    public void in_the_Account_drop_down_should_be_following_options(List<String> dropdownOption) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountDropdown = new Select(accountActivityPage.Account);

        List<String> actualOption = BrowserUtils.getElementsText(accountDropdown.getOptions());

        Assert.assertEquals(dropdownOption,actualOption);
        System.out.println("dropdownOption = " + dropdownOption);
        System.out.println("actualOption = " + actualOption);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> columns) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.transactionsColumns);

        Assert.assertEquals(columns,actualColumns);
        System.out.println("columns = " + columns);
        System.out.println("actualColumns = " + actualColumns);
    }
}
