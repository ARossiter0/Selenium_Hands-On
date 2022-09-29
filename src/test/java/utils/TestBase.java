package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.moneycontrol.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            //driver.findElement(By.linkText("moneycontrol.com")).click();
        }
        return driver;
    }
}
