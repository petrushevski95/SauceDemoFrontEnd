package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {

    private final WebDriver driver;

    private final By addToCartSauceLabsBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCartSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By removeButtonText = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By cartSign = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By tShirtRed = By.id("item_3_title_link");
    private final By sauceLabsOnesiePrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private final By sauceLabsFleeceJacket = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private final By selectedDropdownText = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span");
    private final By cartButton = By.id("shopping_cart_container");
    private final By addToCartSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeSauceLabsBoltTshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By cartSignNumber = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartSauceLabsBoltTshirt() {
        driver.findElement(addToCartSauceLabsBoltTshirt).click();
    }

    public void clickRemoveSauceLabsBoltTshirt() {
        driver.findElement(removeSauceLabsBoltTshirt).click();
    }

    public void clickAddToCartSauceLabsBikeLight() {
        driver.findElement(addToCartSauceLabsBikeLight).click();
    }

    public void clickAddToCartSauceLabsFleeceJacket() {
        driver.findElement(addToCartSauceLabsFleeceJacket).click();
    }

    public String getRemoveButtonText() {
        return driver.findElement(removeButtonText).getText();
    }

    public void clickSauceLabsBackPackText() {
        driver.findElement(sauceLabsBackpack).click();
    }

    public String getAddToCartSauceLabsBoltTshirtButtonText() {
        return driver.findElement(addToCartSauceLabsBoltTshirt).getText();
    }

    public String getAddToCartSauceLabsBoltTshirtButtonBorderColor() {
        Color borderColor = Color.fromString(driver.findElement(addToCartSauceLabsBoltTshirt).getCssValue("color"));
            return borderColor.asHex();
    }

    public String getRemoveButtonBorderColor() {
       Color borderColor = Color.fromString(driver.findElement(removeSauceLabsBoltTshirt).getCssValue("color"));
            return borderColor.asHex();
    }

    public String getRemoveButtonTextColor() {
        Color textColor = Color.fromString(driver.findElement(removeSauceLabsBoltTshirt).getCssValue("color"));
        return textColor.asHex();
    }

    public boolean cartSignDisplayed() {
       return driver.findElement(cartSign).isDisplayed();
    }

    public boolean isOnTheCartPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(cartBadge).isEmpty();
    }

//    public String dropdownOptionText(int option) {
//        WebElement dropdown = driver.findElement(dropdownField);
//        List<WebElement> options = dropdown.findElements(dropdownOptions);
//        return options.get(option).getText();
//    }

    public List<WebElement> dropdownOptions(){
        Select select =
                new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return select.getOptions();
    }

    public void selectDropdownOption(int option){
        Select select = new Select(driver.findElement
                (By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        select.selectByIndex(option);
    }

    public String getCartSignCounterNumber() {
       return driver.findElement(cartSignNumber).getText();
    }

    public String getTShirtRedText(){
        return driver.findElement(tShirtRed).getText();
    }

    public String getSauceLabsOnesiePrice(){
        return driver.findElement(sauceLabsOnesiePrice).getText();
    }

    public String getSauceLabsFleeceJacketPrice(){
        return driver.findElement(sauceLabsFleeceJacket).getText();
    }

    public String getSelectedDropdownText(){
        return driver.findElement(selectedDropdownText).getText();
    }

//    public boolean dollarSignPresent(String text) { //Exercise
//            for (int i = 0; i < text.length(); i++) {
//                if (text.charAt(i) == '$') {
//                return true;
//                }
//            }
//            return false;
//    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }

    public void clickAddToCartSauceLabsBackpack(){
        driver.findElement(addToCartSauceLabsBackpack).click();
    }

    public void goToSauceLabsBackPackInventory(){
        driver.get("https://www.saucedemo.com/inventory-item.html?id=4");
    }


}
