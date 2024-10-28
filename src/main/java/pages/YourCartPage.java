package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends BasePage {

    private final By cartButton = By.id("shopping_cart_container");
    private final By cartSign = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By cartList = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]");
    private final By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By sauceLabsBackpackTitle = By.id("item_4_title_link");
    private final By sauceLabsBackpackQuantity = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");
    private final By sauceLabsBackpackDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private final By sauceLabsBackpackPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");
    private final By checkoutButton = By.id("checkout");
    private final By continueShopping = By.id("continue-shopping");

    public YourCartPage (WebDriver driver) {
        super(driver);
    }

    public void addToCartSauceLabsBackpack() {
        clickOnElement(sauceLabsBackpack);
    }

    public void clickCartIcon() {
        clickOnElement(cartButton);
    }

    public boolean isCartSignDisplayed() {
        return isDisplayed(cartSign);
    }

    public String getCartSignCounter() {
        return getText(cartSign);
    }

    public boolean isCartListDisplayed() {
        return isDisplayed(cartList);
    }

    public String getSauceLabsBackpackTitle() {
        return getText(sauceLabsBackpackTitle);
    }

    public String getSauceLabsBackpackQuantity() {
        return getText(sauceLabsBackpackQuantity);
    }

    public String getSauceLabsBackpackDescription() {
        return getText(sauceLabsBackpackDescription);
    }

    public String getSauceLabsBackpackPrice() {
        return getText(sauceLabsBackpackPrice);
    }

    public void removeSauceLabsBackpack() {
        clickOnElement(removeSauceLabsBackpackButton);
    }

    public boolean isSauceLabsBackpackDisplayed() {
        return isDisplayed(sauceLabsBackpackTitle);
    }

    public void clickCheckoutButton() {
        clickOnElement(checkoutButton);
    }

    public boolean isRedirectedToTheCheckoutPage() {
        return isOnThePage("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void clickContinueShopping () {
        clickOnElement(continueShopping);
    }

    public boolean isRedirectedToTheProductsPage() {
        return isOnThePage("https://www.saucedemo.com/inventory.html");
    }

    public boolean isRedirectedToTheCartPage() {
        return isOnThePage("https://www.saucedemo.com/cart.html");

    }
}




