package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new PayBillsPage().purchaseForeignCurrencyTab.click();
        BrowserUtils.waitFor(2);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyOptions) {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select currencyOption = new Select(payBillsPage.currencyDropdown);

        List<String> actualcurrencyOptions = BrowserUtils.getElementsText(currencyOption.getOptions());
        actualcurrencyOptions.remove(0);

        Assert.assertEquals(expectedCurrencyOptions,actualcurrencyOptions);
        System.out.println("expectedCurrencyOptions = " + expectedCurrencyOptions);
        System.out.println("actualcurrencyOptions = " + actualcurrencyOptions);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.purchaseCash.sendKeys("50");
        new PayBillsPage().calculateCosts.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        System.out.println("Error message displayed= " + alert.getText());
        Assert.assertNotNull(alert.getText());
      //Assert.assertFalse(alert.getText().isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select select = new Select(payBillsPage.currencyDropdown);
        select.selectByValue("EUR");
        BrowserUtils.waitFor(2);
        new PayBillsPage().calculateCosts.click();
    }
}
