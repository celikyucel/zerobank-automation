package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.util.List;

public class AccountSummaryPageDefs {

    @Then("Account Summary Page title contains {string}")
    public void account_Summary_Page_title_contains(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user should see following account types")
    public void the_user_should_see_following_account_types(List<String> accountTypes) {
        BrowserUtils.waitFor(2);
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);

        Assert.assertEquals(accountTypes,actualAccountTypes);
        System.out.println("accountTypes = " + accountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);

    }
}
