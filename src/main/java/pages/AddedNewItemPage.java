package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedNewItemPage extends BasePage {

    @FindBy(xpath = "//span[contains(@id, 'nav-cart-count')]")
    private WebElement quantityOfItemsInCart;

    @FindBy(xpath = "//a[contains(@id,'nav-cart')]")
    private WebElement cartButton;

    public AddedNewItemPage(WebDriver driver) {
        super(driver);
    }

    public String getTextQuantityOfItemsInCart() {
        return quantityOfItemsInCart.getText();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public WebElement getQuantityOfItemsInCart() {
        return quantityOfItemsInCart;
    }
}
