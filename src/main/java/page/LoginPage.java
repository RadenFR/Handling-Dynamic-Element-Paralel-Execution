package page;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-testid='goto-signin']")
    private WebElement toFormSignIn;

    @FindBy(id = "email")
    private WebElement textFieldEmail;

    @FindBy(id = "password")
    private WebElement textFieldPassword;

    @FindBy(id = "submit")
    private WebElement buttonSignIn;

    @FindBy(id = "flash")
    private WebElement messageError;

    @FindBy(id = "welcome-message")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//a[text()='All Books']")
    private WebElement menuAllBooks;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitForElementToBeVisible(toFormSignIn);
        toFormSignIn.click();
        scrollToElement(textFieldEmail);
        waitForElementToBeVisible(textFieldEmail); //Menunggu hingga text field email terlihat
        textFieldEmail.sendKeys(email); //Masukan email
        textFieldPassword.sendKeys(password); //masukan password
        buttonSignIn.click(); //klik button sign in
    }

    public void clickAllBooks() {
        waitForElementToBeVisible(menuAllBooks);
        menuAllBooks.click();
    }

    public boolean verifySuccessLogin() {
        waitForElementToBeVisible(welcomeMessage);
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyFailedLogin() {
        waitForElementToBeVisible(messageError);
        return messageError.isDisplayed();
    }
}
