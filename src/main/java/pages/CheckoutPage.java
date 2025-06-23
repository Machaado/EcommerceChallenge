package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage{

    private By fillStreetAddress = By.name("street[0]");
    private By fillCity = By.name("city");
    private By fillState = By.name("region_id");
    private By fillZip = By.name("postcode");
    private By fillCountry = By.name("country_id");
    private By fillPhoneNumber = By.name("telephone");
    private By nextBtn = By.cssSelector("button.continue");
    private By getPlaceOrderBtn = By.cssSelector(".action.primary.checkout");
    private By getTextConfirmPurchase = By.cssSelector("span[data-ui-id='page-title-wrapper']");

    private By chooseTablerate = By.name("ko_unique_1");
    private By chooseFlatrate = By.name("ko_unique_2");
    private By loadingMask = By.cssSelector(".loading-mask");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddressSaved() {
        return driver.findElements(By.cssSelector(".shipping-address-item")).size() > 0;
    }

    public void fillShippingInformation(String street, String city, String state, String zip, String country, String phone) {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(fillStreetAddress)).sendKeys(street);

        driver.findElement(fillCity).sendKeys(city);

        Select countryDropdown = new Select(driver.findElement(fillCountry));
        countryDropdown.selectByVisibleText(country);

        Select stateDropdown = new Select(driver.findElement(fillState));
        stateDropdown.selectByVisibleText(state);

        driver.findElement(fillZip).sendKeys(zip);


        driver.findElement(fillPhoneNumber).sendKeys(phone);
    }

    public void selectShippingMethod(String method) {
        if (method.equalsIgnoreCase("Table Rate")) {
            driver.findElement(chooseTablerate).click();
        } else if (method.equalsIgnoreCase("Fixed")) {
            driver.findElement(chooseFlatrate).click();
        }
    }

    public void clickNextButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }

    public String getTextButtonPlaceOrder() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(getPlaceOrderBtn)).getText();
    }

    public void clickPlaceOrder() {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(loadingMask));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(getPlaceOrderBtn)).click();
    }

    public String getConfirmPurschaseText() {
        getWait().until(ExpectedConditions.urlContains("/checkout/onepage/success/"));
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(getTextConfirmPurchase)).getText();
    }

}
