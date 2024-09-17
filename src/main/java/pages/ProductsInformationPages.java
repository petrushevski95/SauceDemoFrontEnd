package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ProductsInformationPages {

    private final WebDriver driver;


    private final By backToProducts = By.id("back-to-products");
    private final By removeButton = By.id("remove");
    private final By sauceLabsFleeceJacketPicture = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img");
    private final By sauceLabsFleeceJacketTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By sauceLabsFleeceJacketDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By sauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private final By addToCartButton = By.id("add-to-cart");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By sauceLabsBackpackPicture = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img");
    private final By sauceLabsBackpackTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By sauceLabsBackpackDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By sauceLabsBackPackPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private final By sauceLabsFleeceJacket = By.id("item_5_title_link");


   public ProductsInformationPages(WebDriver driver) {
        this.driver = driver;
   }


   public void clickBackToProducts() {
        driver.findElement(backToProducts).click();
   }

   public void clickRemoveButton() {
        driver.findElement(removeButton).click();
   }

   public boolean isBackToProductsPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
   }

    public boolean isSauceLabsBackpackPictureDisplayed(){
        return driver.findElement(sauceLabsBackpackPicture).isDisplayed();
    }

    public boolean isSauceLabsBackpackTitleDisplayed(){
        return driver.findElement(sauceLabsBackpackTitle).isDisplayed();
    }

    public boolean isSauceLabsBackpackDescriptionDisplayed(){
        return driver.findElement(sauceLabsBackpackDescription).isDisplayed();
    }

    public boolean isSauceLabsBackpackPriceDisplayed(){
        return driver.findElement(sauceLabsBackPackPrice).isDisplayed();
    }

    public String getSauceLabsBackpackTitleText(){
        return driver.findElement(sauceLabsBackpackTitle).getText();
    }

    public String getSauceLabsBackpackDescription(){
        return driver.findElement(sauceLabsBackpackDescription).getText();
    }

    public String getSauceLabsBackPackPrice(){
        return driver.findElement(sauceLabsBackPackPrice).getText();
    }

   public String getAddToCartButtonTextInformationPage() {
        return driver.findElement(addToCartButton).getText();
   }

   public String getAddToCartBorderColor() {
        Color borderColor = Color.fromString(driver.findElement(addToCartButton).getCssValue("color"));
        return borderColor.asHex();
   }

}








