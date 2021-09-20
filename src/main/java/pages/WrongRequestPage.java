package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WrongRequestPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Try checking your spelling or use more general terms')]")
    private WebElement checkSpellingMessage;

    public WrongRequestPage(WebDriver driver) {
        super(driver);
    }

    public String getTextCheckSpellingMessage() {
        return checkSpellingMessage.getText();
    }
}
