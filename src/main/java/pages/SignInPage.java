package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'ap_email')]")
    private WebElement signInBar;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement userPasswordBar;

    @FindBy(xpath = "//input[contains(@id, 'signInSubmit')]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@id, 'createAccountSubmit')]")
    private WebElement createAccountLinkButton;

    @FindBy(xpath = "//h4[contains(text(), 'There was a problem')]")
    private WebElement problemMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSignInBar(final String parameterText) {
        signInBar.click();
        signInBar.sendKeys(parameterText, Keys.ENTER);
    }

    public void enterTextToUserPasswordBar(final String parameterText) {
        userPasswordBar.click();
        userPasswordBar.sendKeys(parameterText, Keys.ENTER);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickCreateAccountLinkButton() {
        createAccountLinkButton.click();
    }

    public String getTextProblemMessage() {
        return problemMessage.getText();
    }

    public WebElement getUserPasswordBar() {
        return userPasswordBar;
    }

    public WebElement getProblemMessage() {
        return problemMessage;
    }
}
