package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductSearchPage extends BasePage {
    private By searchBox = By.id("search");
    private By searchResult = By.cssSelector(".product-item-link");

    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(productName);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchBox)).submit();
    }

    public String getFirstProductName() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(searchResult)).getText();
    }

    public void clickFirstProduct() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchResult)).click();
    }
}
