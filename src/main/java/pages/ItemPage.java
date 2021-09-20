package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//input[contains(@value, 'Add to Cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[contains(@id, 'add-to-wishlist-button-submit')]")
    private WebElement addToListButton;

    @FindBy(xpath = "//span[contains(text(), 'View Your List')]")
    private WebElement viewListButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickAdToListButton() {
        addToListButton.click();
    }

    public void clickViewListButton() {
        viewListButton.click();
    }

    public WebElement getAddToListButton() {
        return addToListButton;
    }

    public WebElement getViewListButton() {
        return viewListButton;
    }
}
