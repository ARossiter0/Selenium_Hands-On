package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    private By loginHeader = By.linkText("Hello, Login");

    private By dropLogBox = By.className("droplogbox");

    private By loginButton = By.linkText("Log-in");

    private By emailField = By.id("email");

    private By passwordField = By.id("pwd");

    private By loginSubmit = By.id("ACCT_LOGIN_SUBMIT");

    private By usernameHeader = By.cssSelector("span.usr_nm");

    private By cancelBtn = By.id("wzrk-cancel");

    private By loginFrame = By.id("myframe");

    private By searchBar = By.id("search_str");

    private By searchResults = By.cssSelector("#autosuggestlist ul li a");

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void hoverOverLoginHeader() {
        Actions action = new Actions(driver);
        WebElement loginHeaderElement = driver.findElement(loginHeader);
        action.moveToElement(loginHeaderElement).perform();
    }

    public boolean verifyLoginDropdown() {
        WebElement element = driver.findElement(dropLogBox);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }

    public void enterLoginInfo(String email, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        wait.until(ExpectedConditions.presenceOfElementLocated(loginFrame));

        driver.switchTo().frame(driver.findElement(loginFrame));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailField)));

        Actions action = new Actions(driver);
        action.click(driver.findElement(emailField));
        action.sendKeys(email);

        action.click(driver.findElement(passwordField));
        action.sendKeys(password);
    }

    public void submit() {
        driver.findElement(loginSubmit).click();
        driver.switchTo().defaultContent();
    }

    public boolean validateLogin(String email) {
        return driver.findElement(usernameHeader).getText().contains(email);
    }

    public void searchCompany(String name) {
        driver.findElement(searchBar).sendKeys(name);
        driver.findElement(searchBar).click();
    }

    public List<WebElement> getSearchResults() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("autosugg_mc1"))));
        return driver.findElements(searchResults);
    }
}
