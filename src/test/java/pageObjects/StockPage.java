package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StockPage {

    private WebDriver driver;

    private By stockTickerNumbers = By.className("rolling_number-placeholder__U-b20");

    private By priceChange = By.id("sp_ch_prch");

    public StockPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getValue() {
        List<WebElement> numbers = driver.findElements(stockTickerNumbers);
        StringBuilder numberString = new StringBuilder();
        for (WebElement e :
                numbers) {
            numberString.append(e.getAttribute("innerHTML"));
        }
        numberString.insert(2, ".");
        return numberString.reverse().toString();
    }

    public String getChangeAndPercentage() {
        return driver.findElement(priceChange).getText();
    }
}
