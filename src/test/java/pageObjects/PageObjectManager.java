package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;

    public HomePage homePage;

    private StockPage stockPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        this.homePage = new HomePage(driver);
        return this.homePage;
    }

    public StockPage getStockPage() {
        this.stockPage = new StockPage(driver);
        return this.stockPage;
    }
}
