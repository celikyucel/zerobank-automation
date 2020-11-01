package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(1);
    }

    @When("the user enters the user information")
    public void the_user_enters_the_user_information() {
        String username = ConfigurationReader.get("user_username");
        String password = ConfigurationReader.get("user_password");

        new LoginPage().login(username,password);

    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Summary";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("Account summary page should	be displayed")
    public void account_summary_page_should_be_displayed() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.AccountSummaryPage.isDisplayed();
    }

    @When("the user enters the wrong user information")
    public void the_user_enters_the_wrong_user_information() {
        String username = "user";
        String password = "12345";

        new LoginPage().login(username,password);
    }

    @When("the user enters the blank username or password information")
    public void the_user_enters_the_blank_username_or_password_information() {
        String username = "";
        String password = "";

        new LoginPage().login(username,password);

    }

    @Then("the user should be not able to login")
    public void the_user_should_be_not_able_to_login() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Summary";
      //  Assert.assertFalse(expectedUrl.equals(actualUrl));
        Assert.assertNotEquals(expectedTitle,actualTitle);
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String errorMessage) {
        Assert.assertTrue(new LoginPage().errorMessage.getText().contains(errorMessage));
    }



}
