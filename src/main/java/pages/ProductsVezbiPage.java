package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsVezbiPage {

    WebDriver driver;

    private final By sauceSauceLabsBikeTitle = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private final By sauceLabsBikeLightDescription = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[1]/div");
    private final By sauceLabsBikeLightPrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div");
    private final By addToCartSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCarSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By addToCartSauceLabsTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By sauceLabsBikeLightInTheCartTitle = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private final By sauceLabsBikeLightInTheCartDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private final By sauceLabsBikeLightInTheCartPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By continueShopping = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By removeSauceLabsBikeLight = By.id("remove-sauce-labs-bike-light");
    private final By cartItemsList = By.className("cart_item");
    private final By cartSign = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public ProductsVezbiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSauceLabsBikeLightTitle() {
        return driver.findElement(sauceSauceLabsBikeTitle).getText();
    }

    public String getSauceLabsBikeLightDescription() {
        return driver.findElement(sauceLabsBikeLightDescription).getText();
    }

    public String getSauceLabsBikeLightPrice() {
        return driver.findElement(sauceLabsBikeLightPrice).getText();
    }

    public void addToCartSauceLabsBikeLight() {
        driver.findElement(addToCartSauceLabsBikeLight).click();
    }

    public void addToCartSauceLabsBackpack() {
        driver.findElement(addToCarSauceLabsBackpack).click();
    }

    public void addToCartSauceLabsTshirt() {
        driver.findElement(addToCartSauceLabsTshirt).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public String getSauceLabsBikeLightCartTitle() {
        return driver.findElement(sauceLabsBikeLightInTheCartTitle).getText();
    }

    public String getSauceLabsBikeLightTheCartDescription() {
        return driver.findElement(sauceLabsBikeLightInTheCartDescription).getText();
    }

    public String getSauceLabsBikeLightTheCartPrice() {
        return driver.findElement(sauceLabsBikeLightInTheCartPrice).getText();
    }

    public void clickContinueShopping() {
        driver.findElement(continueShopping).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void removeSauceLabsBikeLight() {
        driver.findElement(removeSauceLabsBikeLight).click();
    }

    public List<WebElement> cartList() {
       return driver.findElements(cartItemsList);
    }

    public boolean isCartSignDisplayed() {
        WebElement cartSignElement = driver.findElement(cartSign);
        return cartSignElement.isDisplayed();
    }

    public String getCartSignNumber() {
        return driver.findElement(cartSign).getText();
    }

}




