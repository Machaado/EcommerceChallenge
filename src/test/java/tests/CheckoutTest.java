package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductSearchPage;
import utils.TestDataProvider;

import static org.testng.AssertJUnit.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test(dataProvider = "checkoutData", dataProviderClass = TestDataProvider.class)
    public void testCheckout(String street, String city, String state, String zip, String country, String phone, String shipping) throws InterruptedException {
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://magento.softwaretestingboard.com/");

        loginPage.clickLoginInHomePage();
        loginPage.enterEmail("marcelo@email.com");
        loginPage.enterPassword("marcelo123@");
        loginPage.clickLogin();

        searchPage.searchProduct("Breathe");
        searchPage.clickFirstProduct();
        cartPage.selectSize();
        cartPage.selectColor();
        cartPage.addToCart();

        Thread.sleep(3000); // I INSERTED ".SLEEP" BECAUSE WHEN WE INSERT AN ITEM IN THE CART, ITS NOT IMMEDIATE THE ITEM GET INSERTED IN THE CART, HAS A DELAY WHEN WE TRY TO INSERT A ITEM IN THE CART.
        cartPage.openCart();
        cartPage.clickCheckoutBtn();
        Thread.sleep(3000); // I INSERTED .SLEEP BECAUSE NEED TO WAIT THE IF CHECKS

        if (!checkoutPage.isAddressSaved()) {
            //checkoutPage.clickAddNewAddress();
            checkoutPage.fillShippingInformation(street, city, state, zip, country, phone);
        }

        //checkoutPage.fillShippingInformation(street, city, state, zip, country, phone);
        checkoutPage.selectShippingMethod(shipping);
        checkoutPage.clickNextButton();

        String btnText = checkoutPage.getTextButtonPlaceOrder();
        assertTrue(btnText.contains("Place Order"));

        checkoutPage.clickPlaceOrder();

        String msgPurchased = checkoutPage.getConfirmPurschaseText();
        Assert.assertTrue(msgPurchased.contains("Thank you for your purchase!"));
    }

}
