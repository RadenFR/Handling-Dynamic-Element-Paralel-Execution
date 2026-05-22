package test;

import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;

public class CartTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CartTest.class);

    @Test(priority = 1, groups = {"smoke"}, description = "Test User Add Book and Direct to Cart Page", retryAnalyzer = core.RetryAnalyzer.class)
    public void testDirectCart() {

        logger.info("Memulai Test");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        CartPage checkoutPage = new CartPage(DriverManager.getDriver());

        logger.info("User memilih buku");
        homePage.addToCartBook();

        logger.info("User pergi ke halaman cart");
        checkoutPage.clickCart();

        logger.info("Verify user berhasil akses halaman keranjang");
        Assert.assertTrue(checkoutPage.isUserDispalyedCartPage(),
                "User seharusnya dapat mengakses halaman keranjang");

        logger.info("Test tambah buku ke dalam keranjang dan diarahkan pada halaman keranjang berhasil");

    }

    @Test(priority = 2, groups = {"smoke"}, description = "Test Update Quantity", retryAnalyzer = core.RetryAnalyzer.class)
    public void testUpdateQuantity() {

        logger.info("Memulai Test");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());

        logger.info("User memilih buku");
        homePage.addToCartBook();

        logger.info("User pergi ke halaman cart");
        cartPage.clickCart();

        logger.info("Verify user berhasil akses halaman keranjang");
        Assert.assertTrue(cartPage.isUserDispalyedCartPage(),
                "User seharusnya dapat mengakses halaman keranjang");

        logger.info("User menambah quantity");
        cartPage.updateQuantity();

        logger.info("Verify user berhasil update quantity");
        Assert.assertTrue(cartPage.isUserDispalyedUpdateQuantity(),
                "User seharusnya berhasil mengupdate quantity");

        logger.info("Test update quantity berhasil dijalankan");
    }

    @Test(priority = 3, groups = {"smoke"}, description = "Test Delete", retryAnalyzer = core.RetryAnalyzer.class)
    public void testDeleteBook() {

        logger.info("Memulai Test");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());

        logger.info("User memilih buku");
        homePage.addToCartBook();

        logger.info("User pergi ke halaman cart");
        cartPage.clickCart();

        logger.info("Verify user berhasil akses halaman keranjang");
        Assert.assertTrue(cartPage.isUserDispalyedCartPage(),
                "User seharusnya dapat mengakses halaman keranjang");

        logger.info("User klik button delete");
        cartPage.deleteBook();

        logger.info("Verify tidak ada item di keranjang");
        Assert.assertTrue(cartPage.isUserDispalyedDeleteBook(),
                "User seharusnya tidak memiliki item di keranjang");

        logger.info("Test delete book berhasil dijalankan");
    }
}
