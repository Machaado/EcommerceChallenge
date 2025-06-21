package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductSearchPage;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void testAddToCart() throws InterruptedException {
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        CartPage cartPage = new CartPage(driver);

        driver.get("https://magento.softwaretestingboard.com/");
        searchPage.searchProduct("Breathe");
        searchPage.clickFirstProduct();
        cartPage.selectSize();
        cartPage.selectColor();
        cartPage.addToCart();

        Thread.sleep(3000);
        cartPage.openCart();
        String cartItem = cartPage.getProductInCartName();
        assertTrue(cartItem.toLowerCase().contains("breath"), "Item not found in cart.");

        cartPage.clickCheckoutBtn();
    }
}
