package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

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
    private final By dropDownOptions = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartSauceLabsBoltTshirt() {
        clickOnElement(addToCartSauceLabsBoltTshirt);
    }

    public void clickRemoveSauceLabsBoltTshirt() {
        clickOnElement(removeSauceLabsBoltTshirt);
    }

    public void clickAddToCartSauceLabsBikeLight() {
        clickOnElement(addToCartSauceLabsBikeLight);
    }

    public void clickAddToCartSauceLabsFleeceJacket() {
        clickOnElement(addToCartSauceLabsFleeceJacket);
    }

    public String getRemoveButtonText() {
        return getText(removeButtonText);
    }

    public void clickSauceLabsBackPackText() {
        clickOnElement(sauceLabsBackpack);
    }

    public String getAddToCartSauceLabsBoltTshirtButtonText() {
        return getText(addToCartSauceLabsBoltTshirt);
    }

    public String getAddToCartSauceLabsBoltTshirtButtonBorderColor() {
        return getColor(addToCartSauceLabsBoltTshirt,"color");
    }

    public String getRemoveButtonBorderColor() {
        return getColor(removeSauceLabsBoltTshirt,"color");
    }

    public String getRemoveButtonTextColor() {
        return getColor(removeSauceLabsBoltTshirt,"color");
    }

    public boolean cartSignDisplayed() {
        return isDisplayed(cartSign);
    }

    public boolean isOnTheCartPage(){
        return isOnThePage("https://www.saucedemo.com/cart.html");
    }

    public boolean isCartBadgeDisplayed() {
        return isDisplayed(cartBadge);
    }

    public List<WebElement> dropdownOptions() {
        return getDropdownOptions(dropDownOptions);
    }

    public void selectDropdownOption(int option){
        selectDropdownOption(dropDownOptions,option);
    }

    public String getCartSignCounterNumber() {
        return getText(cartSignNumber);
    }

    public String getTShirtRedText(){
        return getText(tShirtRed);
    }

    public String getSauceLabsOnesiePrice(){
        return getText(sauceLabsOnesiePrice);
    }

    public String getSauceLabsFleeceJacketPrice(){
        return getText(sauceLabsFleeceJacket);
    }

    public String getSelectedDropdownText(){
        return getText(selectedDropdownText);
    }

    public void clickCartButton() {
        clickOnElement(cartButton);
    }

    public void clickAddToCartSauceLabsBackpack(){
        clickOnElement(addToCartSauceLabsBackpack);
    }

    public void goToSauceLabsBackPackInventory(){
        navigateTo("https://www.saucedemo.com/inventory-item.html?id=4");
    }

}
