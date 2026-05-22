package test;

import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.CheckoutPage;
import page.HomePage;
import page.LoginPage;

public class CheckoutTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CheckoutTest.class);

    @Test(priority = 1, groups = {"smoke"}, description = "Test Checkout", retryAnalyzer = core.RetryAnalyzer.class)
    public void testCheckout() {

        logger.info("Mulai Test");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        HomePage homePage = new HomePage(DriverManager.getDriver());
        CartPage cartPage = new CartPage(DriverManager.getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

        logger.info("User login dengan credential standardUser");
        loginPage.login(config.getProperty("standardUser"), config.getProperty("password"));

        logger.info("User melihat daftar buku");
        loginPage.clickAllBooks();

        logger.info("User mencari buku");
        homePage.searchBookDevOps();

        logger.info("User menambahkan buku ke keranjang");
        homePage.seleckBook();

        logger.info("User pergi ke halaman cart");
        cartPage.clickCart();

        logger.info("User klik procced to checkout");
        cartPage.clickButtonProcced();

        logger.info("Verify user diarahkan pada form page");
        Assert.assertTrue(cartPage.isUserDispalyedFormPage(),
                "User seharusnya ada pada halaman pengisian form");

        logger.info("User mengisi data diri dan melakukan checkout item");
        checkoutPage.inputData();

        logger.info("Verify user berhasil checkout item");
        Assert.assertTrue(checkoutPage.isUserDispalyedOrders(),
                "User seharusnya memiliki riwayat order");

        logger.info("Test checkout berhasil dijalankan");

    }
}
