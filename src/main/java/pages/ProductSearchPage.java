package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSearchPage extends BasePage {
    private By searchBox = By.id("search");
    private By searchResult = By.cssSelector(".product-item-link");

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(productName);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchBox)).submit();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingSearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        //waitingSearchBox.sendKeys(productName);
        //waitingSearchBox.submit();

        //driver.findElement(searchBox).sendKeys(productName);
        //driver.findElement(searchBox).submit();
    }

    public String getFirstProductName() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(searchResult)).getText();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        //return waitingSearchResult.getText();

        //WebElement product = driver.findElement(searchResult);
        //return product.getText();
    }

    public void clickFirstProduct() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchResult)).click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingSearchResult = wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        //waitingSearchResult.click();

        //driver.findElement(searchResult).click();
    }
}
