package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.AccountActivityPage.click();
        accountActivityPage.FindTransactions.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromData, String toDate) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.fromDate.clear();
        findTransactionsPage.fromDate.sendKeys(fromData);

        findTransactionsPage.toDate.clear();
        findTransactionsPage.toDate.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() {
        new FindTransactionsPage().search.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromData, String toDate) {
        Date startDate = FindTransactionsPage.convertStringToDate(fromData);
        Date endDate = FindTransactionsPage.convertStringToDate(toDate);

        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> dateList = BrowserUtils.getElementsText(findTransactionsPage.dateList);
        System.out.println("dateList = " + dateList);

        for (String list : dateList) {
            Date actualDate = FindTransactionsPage.convertStringToDate(list);

            Assert.assertTrue(actualDate.compareTo(startDate) >= 0);
         // System.out.println("actualDate " + actualDate + " startDate " + startDate + " actualDate.compareTo(startDate) = " + actualDate.compareTo(startDate));

            Assert.assertTrue(actualDate.compareTo(endDate) <= 0);
         // System.out.println("actualDate " + actualDate + " endDate " + endDate + " actualDate.compareTo(endDate) = " + actualDate.compareTo(endDate));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> dateList = BrowserUtils.getElementsText(findTransactionsPage.dateList);
        System.out.println("dateList = " + dateList);

        for (int i = 0; i < dateList.size()-1; i++) {
            Date actualDate1 = FindTransactionsPage.convertStringToDate(dateList.get(i));
            Date actualDate2 = FindTransactionsPage.convertStringToDate(dateList.get(i+1));
            Assert.assertTrue(actualDate1.compareTo(actualDate2)>=0);

        }
    }


    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> dateList = BrowserUtils.getElementsText(findTransactionsPage.dateList);

        for (String list : dateList) {
            Assert.assertNotEquals(date, list);
        }
        System.out.println("dateList = " + dateList);
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.description.clear();
        findTransactionsPage.description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {

        List<String> actualList = BrowserUtils.getElementsText(new FindTransactionsPage().searchDescriptionList);

        for (String list : actualList) {
            Assert.assertTrue("table should include description", list.contains(description));
        }
        System.out.println("actualList = " + actualList);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {

        List<String> actualList = BrowserUtils.getElementsText(new FindTransactionsPage().searchDescriptionList);

        if (actualList.size() == 0) {
            Assert.assertEquals("No result", 0, actualList.size());
        } else {
            for (String list : actualList) {
                Assert.assertFalse("table should not include description", list.contains(description));
            }
        }

        System.out.println("actualList = " + actualList);
        System.out.println("actualList.size() = " + actualList.size());
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<String> actualDepositList = BrowserUtils.getElementsText(new FindTransactionsPage().searchDepositList);
        actualDepositList.removeIf(list -> list.equals(""));

        Assert.assertTrue("at least one result under Deposit", actualDepositList.size() >= 1);
        System.out.println("at least one result under Deposit = " + actualDepositList.size());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<String> actualWithdrawalList = BrowserUtils.getElementsText(new FindTransactionsPage().searchWithdrawalList);
        actualWithdrawalList.removeIf(list -> list.equals(""));

        Assert.assertTrue("at least one result under Withdrawal", actualWithdrawalList.size() >= 1);
        System.out.println("at least one result under Withdrawal = " + actualWithdrawalList.size());

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        Select typeDropdown = new Select(findTransactionsPage.type);

        typeDropdown.selectByValue(type);
        findTransactionsPage.search.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> actualWithdrawalList = BrowserUtils.getElementsText(new FindTransactionsPage().searchWithdrawalList);
        actualWithdrawalList.removeIf(list -> list.equals(""));

        Assert.assertEquals("no result under Withdrawal", 0, actualWithdrawalList.size());
        System.out.println("no result under Withdrawal = " + actualWithdrawalList.size());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> actualDepositList = BrowserUtils.getElementsText(new FindTransactionsPage().searchDepositList);
        actualDepositList.removeIf(list -> list.equals(""));

        Assert.assertEquals("no result under Deposit", 0, actualDepositList.size());
        System.out.println("no result under Deposit = " + actualDepositList.size());
    }

}
