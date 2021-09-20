package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//input[contains(@value,'Delete')]")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//h1[contains(text(),'Your Amazon Cart is empty.')]")
    private WebElement cartIsEmptyMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteItemButton() {
        deleteItemButton.click();
    }

    public String getTextCartIsEmptyMessage() {
        return cartIsEmptyMessage.getText();
    }

    public WebElement getCartIsEmptyMessage() {
        return cartIsEmptyMessage;
    }
}
