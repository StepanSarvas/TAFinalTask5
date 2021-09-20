package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//img[contains(@alt, 'SAMSUNG Galaxy Z Fold 3 5G Factory Unlocked Android Cell Phone')]")
    private WebElement linkToItemPage;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkToItemPage() {
        linkToItemPage.click();
    }
}