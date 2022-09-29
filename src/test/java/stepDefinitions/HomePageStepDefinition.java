package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    TestContextSetup tcs;

    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        this.homePage = tcs.pageObjectManager.getHomePage();
    }

    @Given("User is on MoneyControl home page")
    public void userIsOnMoneyControlHomePage() {
        Assert.assertTrue(homePage.getTitle().contains("Moneycontrol"));
    }

    @When("User hovers over login")
    public void userHoversOverLogin() {
        homePage.hoverOverLoginHeader();
        Assert.assertTrue(homePage.verifyLoginDropdown());
    }

    @And("clicks the Log-in button")
    public void clicksTheLogInButton() {
        homePage.clickLogin();
    }

    @And("Enters valid {string} and {string}")
    public void entersValidEmailAndPassword(String arg0, String arg1) throws InterruptedException {
        homePage.enterLoginInfo(arg0, arg0);
    }

    @And("clicks Login")
    public void clicksLogin() {
        homePage.submit();
    }

    @Then("validate user has successfully logged in with {string}")
    public void validateUserHasSuccessfullyLoggedIn(String arg0) {
        Assert.assertTrue(homePage.validateLogin(arg0));
    }

    @When("^User searches a company name (.+)$")
    public void userSearchesACompanyNameName(String arg0) {
        homePage.searchCompany(arg0);
    }

    @And("^Selects the first option that contains the company name (.+)$")
    public void selectsTheFirstOptionThatContainsTheCompanyName(String arg0) {
        for (WebElement e :
                homePage.getSearchResults()) {
            if (e.getText().contains(arg0)) {
                e.click();
                break;
            }
        }
    }
}
