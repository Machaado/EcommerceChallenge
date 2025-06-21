package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    private By colorSelector = By.id("option-label-color-93-item-59");
    private By sizeSelector = By.id("option-label-size-143-item-167");
    private By addToCartButton = By.id("product-addtocart-button");
    private By cartIcon = By.cssSelector(".showcart");
    private By productInCart = By.cssSelector(".minicart-items-wrapper .product-item-name a");

    private By goToCheckout = By.id("top-cart-btn-checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void selectColor(){
        getWait().until(ExpectedConditions.elementToBeClickable(colorSelector)).click();
    }
    public void selectSize() {
        getWait().until(ExpectedConditions.elementToBeClickable(sizeSelector)).click();
    }

    public void addToCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void openCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public String getProductInCartName() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(productInCart)).getText();
    }

    public void clickCheckoutBtn() {
        getWait().until(ExpectedConditions.elementToBeClickable(goToCheckout)).click();
    }
}
