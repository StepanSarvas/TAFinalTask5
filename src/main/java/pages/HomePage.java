package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'twotabsearchtextbox')]")
    private WebElement searchBar;

    @FindBy(xpath = "//div[contains(@class, 'nav-search-facade')]")
    private WebElement departmentMenuButton;

    @FindBy(xpath = "//a[contains(@id, 'icp-nav-flyout')]")
    private WebElement changeLanguageButton;

    @FindBy(xpath = "//a[contains(@id, 'nav-link-accountList')]")
    private WebElement accountListsLinkButton;

    @FindBy(xpath = "//a[contains(@id, 'nav-orders')]")
    private WebElement ordersLinkButton;

    @FindBy(xpath = "//a[contains(@id, 'nav-cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//a[contains(@id, 'nav-hamburger-menu')]")
    private WebElement allSiteMenuButton;

    @FindBy(xpath = "//div[contains(@id, 'hmenu-content')]")
    private WebElement mainMenuList;

    @FindBy(xpath = "//div[contains(@id, 'nav-main')]")
    private WebElement header;

    @FindBy(xpath = "//div[contains(@class, 'navLeftFooter nav-sprite-v1')]")
    private WebElement footer;

    @FindBy(xpath = "//span[contains(text(), 'Hello, FinalTask5')]")
    private WebElement greetingsMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void displayedSearchBar() {
        searchBar.isDisplayed();
    }

    public void enterTextSearchBar(final String parameterText) {
        searchBar.click();
        searchBar.sendKeys(parameterText, Keys.ENTER);
    }

    public void isDepartmentMenuButtonDisplayed() {
        departmentMenuButton.isDisplayed();
    }

    public boolean isChangeLanguageButtonDisplayed() {
        return changeLanguageButton.isDisplayed();
    }

    public void clickChangeLanguageButton() {
        changeLanguageButton.click();
    }

    public boolean isAccountListsLinkButtonDisplayed() {
        return accountListsLinkButton.isDisplayed();
    }

    public void clickAccountListsLinkButton() {
        accountListsLinkButton.click();
    }

    public boolean isReturnsOrdersLinkButtonDisplayed() {
        return ordersLinkButton.isDisplayed();
    }

    public boolean isCartButtonDisplayed() {
        return cartButton.isDisplayed();
    }

    public boolean isAllSiteMenuButtonDisplayed() {
        return allSiteMenuButton.isDisplayed();
    }

    public void clickAllSiteMenuButton() {
        allSiteMenuButton.click();
    }

    public boolean isMainMenuListDisplayed() {
        return mainMenuList.isDisplayed();
    }

    public boolean isHeaderDisplayed() {
        return header.isDisplayed();
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    public String getTextGreetingsMessage() {
        return greetingsMessage.getText();
    }

    public WebElement getMainMenuList() {
        return mainMenuList;
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

}
