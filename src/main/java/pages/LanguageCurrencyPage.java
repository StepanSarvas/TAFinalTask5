package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageCurrencyPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Deutsch - DE')]")
    private WebElement selectGermanLanguageRadioButton;

    @FindBy(xpath = "//span[contains(@class, 'a-button-text a-declarative')]")
    private WebElement openCurrencyMenuButton;

    @FindBy(xpath = "//a[contains(text(), 'BGN - Bulgaria Lev')]")
    private WebElement currencyPickButton;

    @FindBy(xpath = "//input[contains(@aria-labelledby, 'icp-btn-save-announce')]")
    private WebElement submitChangesButton;

    public LanguageCurrencyPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectGermanLanguageRadioButton() {
        selectGermanLanguageRadioButton.click();
    }

    public void clickOpenCurrencyMenuButton() {
        openCurrencyMenuButton.click();
    }

    public void clickCurrencyEuroButton() {
        currencyPickButton.click();
    }

    public void clickSubmitChangesButton() {
        submitChangesButton.click();
    }

    public WebElement getSelectGermanLanguageRadioButton() {
        return selectGermanLanguageRadioButton;
    }

    public WebElement getOpenCurrencyMenuButton() {
        return openCurrencyMenuButton;
    }
}
