package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class SliderMenuPage extends BasePage {

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By menu = By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]");
    private final By allItems = By.id("inventory_sidebar_link");
    private final By about = By.id("about_sidebar_link");
    private final By logout = By.id("logout_sidebar_link");
    private final By resetAppState = By.id("reset_sidebar_link");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By addToCartSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addToCartSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCartSauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By addToCartSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By cartSignCounter = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
    private final By removeSauceLabsBikeLight = By.id("remove-sauce-labs-bike-light");
    private final By removeSauceLabsFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");
    private final By removeSauceLabsOnesie = By.id("remove-sauce-labs-onesie");
    private final By closeMenuButton = By.id("react-burger-cross-btn");

    public SliderMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButton() {
        clickOnElement(menuButton);
    }

    public void clickSauceLabsBackpack() {
        clickOnElement(sauceLabsBackpack);
    }

    public void clickAllItems() {
        waitForElementToBeClickable(allItems, 5);
        clickOnElement(allItems);
    }

    public void clickLogout() {
        waitForElementToBeClickable(logout, 5);
        clickOnElement(logout);
    }

    public boolean isOnTheSauceLabsBackpackPage() {
        return isOnThePage("https://www.saucedemo.com/inventory-item.html?id=4");
    }

    public boolean isOnTheProductsPage() {
        return isOnThePage("https://www.saucedemo.com/inventory.html");
    }

    public boolean isOnAboutPage() {
        return isOnThePage("https://saucelabs.com/");
    }

    public boolean isOnLoginPage() {
        return isOnThePage("https://www.saucedemo.com/");
    }

    public void clickAbout() {
        waitForElementToBeClickable(about, 5);
        clickOnElement(about);
    }

    public void clickResetAppState() {
        waitForElementToBeClickable(resetAppState, 5);
        clickOnElement(resetAppState);
    }

    public boolean isMenuDisplayed() {
        return isDisplayed(menu);
    }

    public boolean isMenuClosed() {
        try {waitForElementToBeInvisible(menu, 5);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void addToCartSauceLabsBackpack() {
        clickOnElement(addToCartSauceLabsBackpack);
    }

    public void addToCartSauceLabsBikeLight() {
        clickOnElement(addToCartSauceLabsBikeLight);
    }

    public void addToCartSauceLabsOnesie() {
        clickOnElement(addToCartSauceLabsOnesie);
    }

    public void addToCartSauceLabsFleeceJacket() {
        clickOnElement(addToCartSauceLabsFleeceJacket);
    }

    public String getCartItemCounter() {
        return getText(cartSignCounter);
    }

    public boolean isCartItemCounterDisplayed() {
        return isDisplayed(cartSignCounter);
    }

    public String getRemoveSauceLabsBikeLightText() {
        return getText(removeSauceLabsBikeLight);
    }

    public String getRemoveSauceLabsBackpackText() {
        return getText(removeSauceLabsBackpack);
    }

    public String getRemoveSauceLabsFleeceJacketText() {
        return getText(removeSauceLabsFleeceJacket);
    }

    public String getRemoveSauceLabsOnesieText() {
        return getText(removeSauceLabsOnesie);
    }

    public void clickCloseMenu() {
        waitForElementToBeClickable(closeMenuButton,5);
        clickOnElement(closeMenuButton);
    }

}
