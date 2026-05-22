package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //LIST BOOKS
    @FindBy(xpath = "//a[normalize-space()='All Books']")
    private WebElement buttonAllBooks;

    @FindBy(xpath = "//a[normalize-space()='The DevOps Handbook']")
    private WebElement booksDevOps;

    @FindBy(xpath = "//a[normalize-space()='SIMPLE_TITLE']")
    private WebElement booksSimpleTittle;

    @FindBy(xpath = "//a[normalize-space()='Agile Testing']")
    private WebElement booksAgileTesting;

    //FILTER
    @FindBy(css = ".filter_sort-select--label")
    private WebElement filterSortPrice;

    @FindBy(xpath = "//a[normalize-space()='Sort By ASC']")
    private WebElement sortByASC;

    @FindBy(xpath = "//a[normalize-space()='Sort By DESC']")
    private WebElement sortByDESC;

    //SEARCH BAR
    @FindBy(id = "search-input")
    private WebElement searchInput;

    @FindBy(id = "search-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    private WebElement dropdownUser;

    @FindBy(xpath = "//a[@id='profile']")
    private WebElement profileCta;

    @FindBy(xpath = "//a[@id='logout']")
    private WebElement logoutCta;

    @FindBy(xpath = "//a[contains(text(),'E-commerce Bookstore')]")
    private WebElement homepageEntryPoint;

    //BOOKS
    @FindBy(xpath = "//*[@id='books']/div/div/div/a[2]")
    private WebElement buttonAddToCartBook;

    @FindBy(css = ".information")
    private WebElement informationMessageDevOps;

    //SEARCH BOOK
    public void searchBookDevOps() {
        waitForElementToBeVisible(searchInput);
        searchInput.sendKeys("The DevOps Handbook");
        searchButton.click();
        scrollToElement(booksDevOps);
    }

    //KLIK ADD TO CART AFTER SEARCH
    public void seleckBook() {
        waitForElementToBeVisible(buttonAddToCartBook);
        buttonAddToCartBook.click();
    }

    //VERIFY SEARCH BAR
    public boolean isUserDispalyedBookDevOps() {
        try {
            waitForElementToBeVisible(booksDevOps);
            return booksDevOps.isDisplayed() && booksDevOps.getText().equals("The DevOps Handbook");
        } catch (Exception e) {
            return false;
        }
    }

    //SORT BOOK BY PRICE ASC
    public void sortBookByPriceASC() {
        waitForElementToBeVisible(filterSortPrice);
        filterSortPrice.click();
        waitForElementToBeVisible(sortByASC);
        sortByASC.click();
        scrollToElement(booksSimpleTittle);
    }

    //VERIFY SORT BOOK ASC
    public boolean isUserDispalyedBookASC() {
        try {
            waitForElementToBeVisible(booksSimpleTittle);
            return booksSimpleTittle.isDisplayed() && booksSimpleTittle.getText().equals("SIMPLE_TITLE");
        } catch (Exception e) {
            return false;
        }
    }

    //SORT BOOK BY PRICE DESC
    public void sortBookByPriceDSC() {
        waitForElementToBeVisible(filterSortPrice);
        filterSortPrice.click();
        waitForElementToBeVisible(sortByDESC);
        sortByDESC.click();
        scrollToElement(booksAgileTesting);
    }

    //VERIFY SORT BOOK DESC
    public boolean isUserDispalyedBookDESC() {
        try {
            waitForElementToBeVisible(booksAgileTesting);
            return booksAgileTesting.isDisplayed() && booksAgileTesting.getText().equals("Agile Testing");
        } catch (Exception e) {
            return false;
        }
    }

    //ADD TO CART
    public void addToCartBook() {
        scrollToElement(buttonAddToCartBook);
        waitForElementToBeVisible(buttonAddToCartBook);
        buttonAddToCartBook.click();
    }

    //VERIFY BOOK ADD TO CART
    public boolean isUserAddToCartBook() {
        try {
            waitForElementToBeVisible(informationMessageDevOps);
            return informationMessageDevOps.isDisplayed() && informationMessageDevOps.getText().equals("The DevOps Handbook");
        } catch (Exception e) {
            return false;
        }
    }
}



