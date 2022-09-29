package testCases;

import base.DriverInstance;
import dataGenerators.DataGenerator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.StockPage;
import utils.TestContextSetup;

public class TC_001_SearchStock extends DriverInstance {

    @Test(
            dataProvider = "Excel",
            dataProviderClass = DataGenerator.class
    )
    public void tc001_search_stock(String company) {
        HomePage homePage = new HomePage(driver);
        StockPage stockPage = new StockPage(driver);
        Assert.assertTrue(homePage.getTitle().contains("Moneycontrol"));
        homePage.searchCompany(company);
        for (WebElement e :
                homePage.getSearchResults()) {
            if (e.getText().contains(company)) {
                e.click();
                break;
            }
        }
        String value = stockPage.getValue();
        String change = stockPage.getChangeAndPercentage();

        System.out.println("Value: " + value + "\n" + "Change: " + change);
    }
}
