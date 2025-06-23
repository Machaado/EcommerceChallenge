package tests;

import org.testng.annotations.Test;
import pages.ProductSearchPage;
import utils.TestDataProvider;

import static org.testng.Assert.assertTrue;

public class ProductSearchTest extends BaseTest{

    @Test(dataProvider = "productData", dataProviderClass = TestDataProvider.class)
    public void testProductSearch(String product) {
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        driver.get("https://magento.softwaretestingboard.com/");
        searchPage.searchProduct(product);

        String firstProduct = searchPage.getFirstProductName();
        assertTrue(firstProduct.toLowerCase().contains("breath"), "Search result mismatch.");

        searchPage.clickFirstProduct();

    }


}
