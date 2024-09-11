package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {

    private final WebDriver driver;

    private final By cartButton = By.id("shopping_cart_container");
    private final By cartSign = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By cartList = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]");
    private final By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By sauceLabsBackpackTitle = By.id("item_4_title_link");
    private final By sauceLabsBackpackQuantity = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");
    private final By sauceLabsBackpackDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private final By sauceLabsBikeLightInTheCartTitle = By.id("item_0_title_link");
    private final By sauceLabsBikeLightInTheCartDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private final By sauceLabsBikeLightInTheCartPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By sauceLabsBackpackPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");
    private final By checkoutButton = By.id("checkout");
    private final By continueShopping = By.id("continue-shopping");

    public YourCartPage (WebDriver driver){
       this.driver = driver;
    }

    public void addToCartSauceLabsBackpack(){
        driver.findElement(sauceLabsBackpack).click();
    }

    public void clickCartIcon(){
        driver.findElement(cartButton).click();
    }

    public boolean isCartSignDisplayed() {
        { try {return driver.findElement(cartSign).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
            }
        }
    }

    public String getCartSignCounter(){
        return driver.findElement(cartSign).getText();
    }

    public boolean isCartListDisplayed(){
        return driver.findElement(cartList).isDisplayed();
    }

    public String getSauceLabsBikeLightTitle() {
        return driver.findElement(sauceLabsBikeLightInTheCartTitle).getText();
    }

    public String getSauceLabsBikeLightDescription() {
        return driver.findElement(sauceLabsBikeLightInTheCartDescription).getText();
    }

    public String getSauceLabsBikeLightPrice() {
        return driver.findElement(sauceLabsBikeLightInTheCartPrice).getText();
    }

    public String getSauceLabsBackpackTitle(){
        return driver.findElement(sauceLabsBackpackTitle).getText();
    }

    public String getSauceLabsBackpackQuantity(){
        return driver.findElement(sauceLabsBackpackQuantity).getText();
    }

    public String getSauceLabsBackpackDescription(){
        return driver.findElement(sauceLabsBackpackDescription).getText();
    }

    public String getSauceLabsBackpackPrice(){
        return driver.findElement(sauceLabsBackpackPrice).getText();
    }

    public void removeSauceLabsBackpack(){
        driver.findElement(removeSauceLabsBackpackButton).click();
    }

    public boolean isSauceLabsBackpackDisplayed() {
        { try {return driver.findElement(sauceLabsBackpackTitle).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
            }
        }
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isRedirectedToTheCheckoutPage(){
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html")){
        return true;
        } else {
            return false;
        }
    }

    public void clickContinueShopping(){
        driver.findElement(continueShopping).click();
    }

    public boolean isRedirectedToTheProductsPage(){
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")){
            return true;
        } else {
            return false;}
        }

    public boolean isRedirectedToTheCartPage(){
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html")){
            return true;
        } else {
            return false;
        }
    }

    }




