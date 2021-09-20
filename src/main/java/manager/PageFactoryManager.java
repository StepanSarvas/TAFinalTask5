package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage((driver));
    }

    public AddedNewItemPage getAddedNewItemPage() {
        return new AddedNewItemPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage(driver);
    }

    public ItemPage getItemPage() {
        return new ItemPage(driver);
    }

    public LanguageCurrencyPage getLanguageCurrencyPage() {
        return new LanguageCurrencyPage(driver);
    }

    public ListPage getListPage() {
        return new ListPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public WrongRequestPage getWrongRequestPage() {
        return new WrongRequestPage(driver);
    }
}
