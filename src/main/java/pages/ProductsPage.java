package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {

    private final WebDriver driver;

    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By backToProducts = By.id("back-to-products");
    private final By addToCartSauceLabsBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addToCartSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By removeButtonText = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By cartSign = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By removeSauceBackPack = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By tShirtRed = By.id("item_3_title_link");
    private final By sauceLabsOnesiePrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private final By sauceLabsFleeceJacket = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private final By selectedDropdownText = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span");
    private final By cartButton = By.id("shopping_cart_container");
    private final By addToCartSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeButton = By.id("remove");
    private final By addToCartButtonText = By.id("add-to-cart");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSauceLabsBackpackText(){
        driver.findElement(sauceLabsBackpack).click();
    }

    public void clickBackToProducts(){
        driver.findElement(backToProducts).click();
    }

    public void clickAddToCartSauceLabsBoltTshirt(){
        driver.findElement(addToCartSauceLabsBoltTshirt).click();
    }

    public void clickAddToCartSauceLabsBikeLight(){
        driver.findElement(addToCartSauceLabsBikeLight).click();
    }

    public void clickAddToCartSauceLabsFleeceJacket(){
        driver.findElement(addToCartSauceLabsFleeceJacket).click();
    }

    public String getRemoveButtonText(){
        return driver.findElement(removeButtonText).getText();
    }

    public String getAddToCartSauceLabsBoltTshirtButtonText(){
        return driver.findElement(addToCartSauceLabsBoltTshirt).getText();
    }

    public String getAddToCartSauceLabsBoltTshirtButtonTextColor(){
        WebElement removeButton = driver.findElement(addToCartSauceLabsBoltTshirt);
        return  removeButton.getCssValue("background-color");

    }

    public String getRemoveButtonColor(){
        WebElement removeButton = driver.findElement(removeButtonText);
        return removeButton.getCssValue("background-color");
    }


    public String getAddToCartButtonColor(){
        WebElement removeButton = driver.findElement(sauceLabsBackpack);
        return removeButton.getCssValue("background-color");
    }

    public boolean cartSignDisplayed(){
       return driver.findElement(cartSign).isDisplayed();
    }

    public void removeSauceBackPackTshirt(){
        driver.findElement(removeSauceBackPack).click();
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isCartBadgePresent() {
        return !driver.findElements(cartBadge).isEmpty();
    }


//    public String dropdownOptionText(int option){
//        WebElement dropdown = driver.findElement(dropdownField);
//        List<WebElement> options = dropdown.findElements(dropdownOptions);
//        return options.get(option).getText(); ova e moj kod
//    }

    public List<WebElement> dropdownOptions(){ // ova e od klas
        Select select =
                new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return select.getOptions();
    }

    public String SauceBackPackTshirtText(){
        return driver.findElement(sauceLabsBackpack).getText();
    }

    public void selectDropdownOption(int option){
        Select select = new Select(driver.findElement
                (By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        select.selectByIndex(option);
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

    public boolean dollarSignPresent(String text){ //moj kod a trebalo so contains
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '$') {
                return true;
                }
            }
            return false;
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }

    public void addToCartSauceLabsBackpack(){
        driver.findElement(addToCartSauceLabsBackpack).click();
    }

    public void goToSauceLabsBackPackInventory(){
        driver.get("https://www.saucedemo.com/inventory-item.html?id=4");
    }

    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }

    public String getAddToCartButtonTextInformationPage(){
        return driver.findElement(addToCartButtonText).getText();
    }

    public String getAddToCartButtonColorInformationPage(){
        WebElement removeButton = driver.findElement(addToCartButtonText);
        return removeButton.getCssValue("background-color");
    }

}
