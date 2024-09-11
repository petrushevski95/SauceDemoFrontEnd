package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SliderMenuPage {

    private final WebDriver driver;

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

    public SliderMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickSauceLabsBackpack() {
        driver.findElement(sauceLabsBackpack).click();
    }

    public void clickAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(elementToBeClickable(allItems)).click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(elementToBeClickable(logout)).click();
    }

    public boolean isOnTheSauceLabsBackpackPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory-item.html?id=4");
    }

    public boolean isOnTheProductsPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean isOnAboutPage() {
        return driver.getCurrentUrl().equals("https://saucelabs.com/");
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }

    public void clickAbout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(elementToBeClickable(about)).click();
    }

    public void clickResetAppState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(elementToBeClickable(resetAppState)).click();
    }

    public boolean isMenuDisplayed() {
        return driver.findElement(menu).isDisplayed();
    }

    public void addToCartSauceLabsBackpack() {
        driver.findElement(addToCartSauceLabsBackpack).click();
    }

    public void addToCartSauceLabsBikeLight() {
        driver.findElement(addToCartSauceLabsBikeLight).click();
    }

    public void addToCartSauceLabsOnesie() {
        driver.findElement(addToCartSauceLabsOnesie).click();
    }

    public void addToCartSauceLabsFleeceJacket() {
        driver.findElement(addToCartSauceLabsFleeceJacket).click();
    }

    public String getCartItemCounter() {
        return driver.findElement(cartSignCounter).getText();
    }

    public boolean isCartItemCounterDisplayed() {
        {try {return driver.findElement(cartSignCounter).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }
    }

    public String getAddToCartSauceLabsBikeLightText(){
        return driver.findElement(addToCartSauceLabsBikeLight).getText();
    }

    public String getAddToCartSauceLabsBackpackText(){
        return driver.findElement(addToCartSauceLabsBackpack).getText();
    }

    public String getAddToCartSauceLabsOnesie(){
        return driver.findElement(addToCartSauceLabsOnesie).getText();
    }

    public String getAddToCartSauceLabsFleeceJacketText(){
        return driver.findElement(addToCartSauceLabsFleeceJacket).getText();
    }

    public String getRemoveSauceLabsBikeLightText(){
        return driver.findElement(removeSauceLabsBikeLight).getText();
    }

    public String getRemoveSauceLabsBackpackText(){
        return driver.findElement(removeSauceLabsBackpack).getText();
    }

    public String getRemoveSauceLabsFleeceJacketText(){
        return driver.findElement(removeSauceLabsFleeceJacket).getText();
    }

    public String getRemoveSauceLabsOnesieText(){
        return driver.findElement(removeSauceLabsOnesie).getText();
    }



}
