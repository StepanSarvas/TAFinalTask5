package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'ap_email')]")
    private WebElement emailBar;

    @FindBy(xpath = "//input[contains(@id, 'continue')]")
    private WebElement crateAccountButton;

    @FindBy(xpath = "//div[contains(text(), 'Wrong or Invalid email address or mobile phone number. Please correct and try again.')]")
    private WebElement wrongEmailMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToEmailBar(final String parameterText) {
        emailBar.click();
        emailBar.sendKeys(parameterText, Keys.ENTER);
    }

    public String getTextWrongEmailMassage() {
        return wrongEmailMessage.getText();
    }

    public void clickCreateAccountButton() {
        crateAccountButton.click();
    }

    public WebElement getWrongEmailMessage() {
        return wrongEmailMessage;
    }
}
