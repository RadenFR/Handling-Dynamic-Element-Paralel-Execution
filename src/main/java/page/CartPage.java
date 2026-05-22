package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //CART
    @FindBy(xpath = "//img[@alt='Cart']")
    private WebElement buttonCart;

    @FindBy(xpath = "//h1[text()='Shopping Cart']")
    private WebElement titleShoppingCart;

    @FindBy(xpath = "//h2[text()='No items in carts']")
    private WebElement titleNoItem;

    @FindBy(id = "cartQty")
    private WebElement textfieldQuantity;

    @FindBy(xpath = "//*[@id='core']/div/div/div/div[1]/table/tbody/tr/td[4]/form/div/button")
    private WebElement buttonUpdate;

    @FindBy(xpath = "//*[@id='core']/div/div/div/div[1]/table/tbody/tr/td[6]/a")
    private WebElement buttonDelete;

    @FindBy(xpath = "//*[@id='core']/div/div/div/div[2]/div/a")
    private WebElement buttonProccedToCo;

    //FORM PAGE
    @FindBy(xpath = "//h1[text()='Checkout']")
    private WebElement titleCheckout;

    //CART PAGE
    public void clickCart() {
        waitForElementToBeVisible(buttonCart);
        buttonCart.click();
    }

    //VERIFY CART PAGE
    public boolean isUserDispalyedCartPage() {
        try {
            waitForElementToBeVisible(buttonProccedToCo);
            return buttonProccedToCo.isDisplayed() && buttonProccedToCo.getText().equals("Proceed To Checkout");
        } catch (Exception e) {
            return false;
        }
    }

    //UPDATE QUANTITY
    public void updateQuantity() {
        waitForElementToBeVisible(textfieldQuantity);
        textfieldQuantity.clear();
        textfieldQuantity.sendKeys("4");
        waitForElementToBeVisible(buttonUpdate);
        buttonUpdate.click();
    }

    //VERIFY UPDATE QUANTITY
    public boolean isUserDispalyedUpdateQuantity() {
        try {
            waitForElementToBeVisible(titleShoppingCart);
            return titleShoppingCart.isDisplayed() && titleShoppingCart.getText().equals("Shopping Cart");
        } catch (Exception e) {
            return false;
        }
    }

    //DELETE BOOK
    public void deleteBook() {
        waitForElementToBeVisible(buttonDelete);
        buttonDelete.click();
    }

    //VERIFY DELETE BOOK
    public boolean isUserDispalyedDeleteBook() {
        try {
            waitForElementToBeVisible(titleNoItem);
            return titleNoItem.isDisplayed() && titleNoItem.getText().equals("No items in carts");
        } catch (Exception e) {
            return false;
        }
    }

    //DIRECT TO FORM PAGE
    public void clickButtonProcced() {
        waitForElementToBeVisible(buttonProccedToCo);
        buttonProccedToCo.click();
    }

    //VERIFY DELETE BOOK
    public boolean isUserDispalyedFormPage() {
        try {
            waitForElementToBeVisible(titleCheckout);
            return titleCheckout.isDisplayed() && titleCheckout.getText().equals("Checkout");
        } catch (Exception e) {
            return false;
        }
    }
}
