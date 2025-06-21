package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData", dataProviderClass = utils.TestDataProvider.class)
    public void testLogin(String email, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.clickLoginInHomePage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        if (expectedResult.equalsIgnoreCase("Invalid")) {
            String error = loginPage.getErrorMessage();
            assertTrue(error.contains("The account sign-in was incorrect"), "Expected login failure.");
        } else {
            assertTrue(loginPage.confirmLoggedIn().contains("Welcome"));
        }
    }
}
