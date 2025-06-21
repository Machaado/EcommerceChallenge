package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriverWait getWait() {
        int timeout = driver.toString().toLowerCase().contains("firefox") ? 20 : 10;
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
