package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement textfieldName;

    @FindBy(id = "address")
    private WebElement textfieldAddress;

    @FindBy(id = "card-name")
    private WebElement textfieldCardName;

    @FindBy(id = "card-number")
    private WebElement textfieldCardNumber;

    @FindBy(id = "card-expiry-month")
    private WebElement textfieldExMonth;

    @FindBy(id = "card-expiry-year")
    private WebElement textfieldYear;

    @FindBy(id = "card-cvc")
    private WebElement textfieldCVC;

    @FindBy(xpath = "//*[@id='checkout-form']/button")
    private WebElement buttonPurchase;

    @FindBy(xpath = "//h1[text()='Profile']")
    private WebElement titleProfile;


    //FORM DATA
    public void inputData() {
        waitForElementToBeVisible(textfieldName);
        scrollToElement(textfieldName);
        textfieldName.sendKeys("Fachrul");
        textfieldAddress.sendKeys("Jln Moch Toha");
        textfieldCardName.sendKeys("Bank Jago");
        textfieldCardNumber.sendKeys("4242424242424242");
        textfieldExMonth.sendKeys("10");
        textfieldYear.sendKeys("2027");
        textfieldCVC.sendKeys("123");
        buttonPurchase.click();
    }

    //VERIFY SUCCESS CHECKOUT
    public boolean isUserDispalyedOrders() {
        try {
            waitForElementToBeVisible(titleProfile);
            return titleProfile.isDisplayed() && titleProfile.getText().equals("Profile");
        } catch (Exception e) {
            return false;
        }
    }
}
