package tests;

import org.testng.annotations.Test;
import pages.ProductSearchPage;

import static org.testng.Assert.assertTrue;

public class ProductSearchTest extends BaseTest{

    @Test
    public void testProductSearch() {
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        driver.get("https://magento.softwaretestingboard.com/");
        searchPage.searchProduct("Breathe");

        String firstProduct = searchPage.getFirstProductName();
        assertTrue(firstProduct.toLowerCase().contains("breath"), "Search result mismatch.");

        searchPage.clickFirstProduct();

    }


}
