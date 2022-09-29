package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.StockPage;
import utils.TestContextSetup;

public class StockPageStepDefinition {

    TestContextSetup tcs;

    StockPage stockPage;

    public StockPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        this.stockPage = tcs.pageObjectManager.getStockPage();
    }
    @Then("record company value, change, and percentage")
    public void recordCompanyValueChangeAndPercentage() {
        String value = stockPage.getValue();
        String change = stockPage.getChangeAndPercentage();

        System.out.println("Value: " + value + "\n" + "Change: " + change);
    }
}
