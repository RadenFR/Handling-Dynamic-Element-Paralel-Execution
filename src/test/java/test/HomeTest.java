package test;

import com.beust.ah.A;
import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class HomeTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HomeTest.class);

    @Test(priority = 1, groups = {"smoke"}, description = "Test Search Books DevOps Successfully")
    public void testSearchBooks() {

        logger.info("Memulai test");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        logger.info("User mencari buku pada search bar");
        homePage.searchBookDevOps();

        logger.info("Verify menampilkan buku yang dicari");
        Assert.assertTrue(homePage.isUserDispalyedBookDevOps(),
                "User seharusnya melihat buku DevOps");

        logger.info("Test serach books berhasil dijalankan");
    }

    @Test(priority = 2, groups = {"smoke"}, description = "Test Sort Book By Price ASC")
    public void testSortByASC() {

        logger.info("Memulai test");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        logger.info("User mengurutkan buku secara Ascending");
        homePage.sortBookByPriceASC();

        logger.info("Verify urutan buku diurutkan by price ASC");
        Assert.assertTrue(homePage.isUserDispalyedBookASC(),
                "User seharusnya melihat urutan buku ASC");

        logger.info("Test sort by price ASC telah berhasil dijalankan");
    }

    @Test(priority = 3, groups = {"smoke"}, description = "Test Sort Book By Price DSC")
    public void testSortByDSC() {

        logger.info("Memulai test");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        logger.info("User mengurutkan buku secara Ascending");
        homePage.sortBookByPriceASC();

        logger.info("Verify urutan buku diurutkan by price ASC");
        Assert.assertTrue(homePage.isUserDispalyedBookASC(),
                "User seharusnya melihat urutan buku ASC");

        logger.info("Test sort by price ASC telah berhasil dijalankan");
    }

    @Test(priority = 4, groups = {"smoke"}, description = "Test Add To Cart Book Successfully")
    public void testAddToCartBook() {

        logger.info("Memulai test");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        logger.info("User menenkan button add to cart");
        homePage.addToCartBook();

        logger.info("Test add to cart book telah berhasil dijalankan");
    }
}
