package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {

    @FindBy(xpath = "//h3/a[contains(@title, 'SAMSUNG Galaxy Z Fold 3 5G Factory Unlocked Android Cell Phone')]")
    private WebElement itemInList;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public String getTextDisplayedItemInList() {
        return itemInList.getText();
    }
}
