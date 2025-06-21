package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    private By signInLink = By.linkText("Sign In");
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.id("send2");
    private By errorMessage = By.cssSelector(".message-error");

    private By confirmLoggedInMsg = By.className("logged-in");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void clickLoginInHomePage() {
        getWait().until(ExpectedConditions.elementToBeClickable(signInLink)).click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(signInLink));
        //loginBtn.click();

        //driver.findElement(signInLink).click();
    }

    public void enterEmail(String email) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        //waitingEmail.sendKeys(email);

        //driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingPass = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        //waitingPass.sendKeys(password);

        //driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        getWait().until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingSignInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        //waitingSignInButton.click();

        //driver.findElement(signInButton).click();
    }

    public String getErrorMessage() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement waitingErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        //return waitingErrorMessage.getText();

        //return driver.findElement(errorMessage).getText();
    }

    public String confirmLoggedIn() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(confirmLoggedInMsg)).getText();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmLoggedInMsg));
        //return element.getText();
    }
}
