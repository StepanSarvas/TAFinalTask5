package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 40;
    WebDriver driver;
    AddedNewItemPage addedNewItemPage;
    CartPage cartPage;
    CreateAccountPage createAccountPage;
    ItemPage itemPage;
    LanguageCurrencyPage languageCurrencyPage;
    ListPage listPage;
    SearchPage searchPage;
    SignInPage signInPage;
    HomePage homePage;
    WrongRequestPage wrongRequestPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.loadPageWaiter(DEFAULT_TIMEOUT);
        assertTrue("Header is not visible", homePage.isHeaderDisplayed());
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        assertTrue("Footer is not visible", homePage.isFooterDisplayed());
    }

    @And("User checks search bar visibility")
    public void userChecksSearchBarVisibility() {
        homePage.displayedSearchBar();
    }

    @And("User checks department menu button visibility")
    public void userChecksDepartmentMenuButtonVisibility() {
        homePage.isDepartmentMenuButtonDisplayed();
    }

    @And("User checks change language button visibility")
    public void userChecksChangeLanguageButtonVisibility() {

        assertTrue("Change language button is not visible", homePage.isChangeLanguageButtonDisplayed());
    }

    @And("User checks account button visibility")
    public void userChecksAccountButtonVisibility() {

        assertTrue("Account list link button is not visible", homePage.isAccountListsLinkButtonDisplayed());
    }

    @And("User checks returns orders button visibility")
    public void userChecksReturnsOrdersButtonVisibility() {

        assertTrue("Returns & Orders button is not visible", homePage.isReturnsOrdersLinkButtonDisplayed());
    }

    @And("User checks cart button visibility")
    public void userChecksCartButtonVisibility() {

        assertTrue("Cart button ois not displayed", homePage.isCartButtonDisplayed());
    }

    @And("User checks all button visibility")
    public void userChecksAllButtonVisibility() {
        assertTrue("All button is not visible",homePage.isAllSiteMenuButtonDisplayed());
    }

    @When("User clicks all button")
    public void userClicksAllButton() {
        homePage.clickAllSiteMenuButton();
    }

    @Then("User checks that main menu list appears")
    public void userChecksThatMainMenuListAppears() {
        homePage.loadElementWaiter(DEFAULT_TIMEOUT, homePage.getMainMenuList());
        assertTrue("Main menu list not visible",homePage.isMainMenuListDisplayed());
    }

    @And("User clicks change language button")
    public void userClicksChangeLanguageButton() {
        homePage.clickChangeLanguageButton();
    }

    @And("User clicks language radio button button")
    public void userClicksLanguageRadioButtonButton() {
        languageCurrencyPage = pageFactoryManager.getLanguageCurrencyPage();
        languageCurrencyPage.loadElementWaiter(DEFAULT_TIMEOUT, languageCurrencyPage.getSelectGermanLanguageRadioButton());
        languageCurrencyPage.clickSelectGermanLanguageRadioButton();
    }

    @When("User clicks submit changes button")
    public void userClicksSubmitChangesButton() {
        languageCurrencyPage = pageFactoryManager.getLanguageCurrencyPage();
        languageCurrencyPage.clickSubmitChangesButton();

    }

    @Then("User checks that current url contains {string} language")
    public void userChecksThatCurrentUrlContainsDeLanguage(final String language) {
        homePage = pageFactoryManager.getHomePage();
        assertTrue("No language in url", driver.getCurrentUrl().contains(language));
    }

    @And("User clicks currency menu button")
    public void userClicksCurrencyMenuButton() {
        languageCurrencyPage = pageFactoryManager.getLanguageCurrencyPage();
        languageCurrencyPage.loadElementWaiter(DEFAULT_TIMEOUT, languageCurrencyPage.getOpenCurrencyMenuButton());
        languageCurrencyPage.clickOpenCurrencyMenuButton();
    }

    @And("User clicks currency switch")
    public void userClicksCurrencySwitch() {
        languageCurrencyPage = pageFactoryManager.getLanguageCurrencyPage();
        languageCurrencyPage.clickCurrencyEuroButton();
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage = pageFactoryManager.getHomePage();
        homePage.enterTextSearchBar(keyword);
    }

    @Then("User checks that current url contains {string} symbol")
    public void userChecksThatCurrentUrlContainsBGNSymbol(final String symbol) {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue("Currency symbol not found", driver.getCurrentUrl().contains(symbol));
    }

    @And("User clicks on item page link")
    public void userClicksOnItemPageLink() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickLinkToItemPage();
    }

    @And("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.clickAddToCartButton();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void userChecksThatAmountOfProductsInCartAreQuantityOfProducts(final String quantityOfProducts) {
        addedNewItemPage = pageFactoryManager.getAddedNewItemPage();
        addedNewItemPage.loadElementWaiter(DEFAULT_TIMEOUT, addedNewItemPage.getQuantityOfItemsInCart());
        assertEquals(addedNewItemPage.getTextQuantityOfItemsInCart(), quantityOfProducts);
    }

    @And("User clicks cart button")
    public void userClicksCartButton() {
        addedNewItemPage = pageFactoryManager.getAddedNewItemPage();
        addedNewItemPage.clickCartButton();
    }

    @And("User clicks delete item button")
    public void userClicksDeleteItemButton() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.clickDeleteItemButton();
    }

    @Then("User checks that empty cart {string} is visible")
    public void userChecksThatEmptyCartMessageIsVisible(final String message) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.loadElementWaiter(DEFAULT_TIMEOUT, cartPage.getCartIsEmptyMessage());
        assertTrue("Empty cart message not found", cartPage.getTextCartIsEmptyMessage().contains(message));
    }

    @Then("User check that wrong request {string} message is visible")
    public void userCheckThatWrongRequestMessageMessageIsVisible(final String message) {
        wrongRequestPage = pageFactoryManager.getWrongRequestPage();
        assertEquals(wrongRequestPage.getTextCheckSpellingMessage(), message);
    }

    @And("User click account button")
    public void userClickAccountButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickAccountListsLinkButton();
    }

    @When("User type email {string} to sign in bar")
    public void userTypeEmailEmailToSignInBar(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterTextToSignInBar(email);
    }

    @And("User clicks sign in button")
    public void userClicksSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickSignInButton();
    }

    @Then("User check that problem {string} message is visible")
    public void userCheckThatProblemMessageMessageIsVisible(final String message) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.loadElementWaiter(DEFAULT_TIMEOUT, signInPage.getProblemMessage());
        assertEquals(signInPage.getTextProblemMessage(), message);
    }

    @And("User click create account button")
    public void userClickCreateAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickCreateAccountLinkButton();
    }

    @When("User type email {string} to email bar")
    public void userTypeEmailEmailToEmailBar(final String email) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.enterTextToEmailBar(email);
    }

    @And("User click create new account confirmation button")
    public void userClickCreateNewAccountConfirmationButton() {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.clickCreateAccountButton();
    }

    @Then("User check that {string} message is visible")
    public void userCheckThatMessageMessageIsVisible(final String message) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.loadElementWaiter(DEFAULT_TIMEOUT, createAccountPage.getWrongEmailMessage());
        assertEquals(createAccountPage.getTextWrongEmailMassage(), message);
    }

    @And("User type password {string} to the password bar")
    public void userTypePasswordPasswordToThePasswordBar(final String password) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.loadElementWaiter(DEFAULT_TIMEOUT, signInPage.getUserPasswordBar());
        signInPage.enterTextToUserPasswordBar(password);
    }

    @Then("User check that greeting {string} message is visible")
    public void userCheckThatGreetingMessageMessageIsVisible(final String message) {
        homePage = pageFactoryManager.getHomePage();
        assertEquals(homePage.getTextGreetingsMessage(), message);
    }

    @And("User clicks on add to list button")
    public void userClicksOnAddToListButton() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.loadElementWaiter(DEFAULT_TIMEOUT, itemPage.getAddToListButton());
        itemPage.clickAdToListButton();
    }

    @And("User clicks on view list button")
    public void userClicksOnViewListButton() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.loadElementWaiter(DEFAULT_TIMEOUT, itemPage.getViewListButton());
        itemPage.clickViewListButton();
    }

    @Then("User check that item {string} is visible in the list")
    public void userCheckThatItemNameIsVisibleInTheList(final String name) {
        listPage = pageFactoryManager.getListPage();
        assertTrue("Item in the list is not visible", listPage.getTextDisplayedItemInList().contains(name));
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
