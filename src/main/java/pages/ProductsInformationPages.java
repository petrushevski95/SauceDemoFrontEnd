package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsInformationPages {

    private final WebDriver driver;

    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By sauceLabsBackpackPicture = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img");
    private final By sauceLabsBackpackTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By sauceLabsBackpackDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By sauceLabsBackPackPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private final By backToProducts = By.id("back-to-products");
    private final By sauceLabsFleeceJacket = By.id("item_5_title_link");
    private final By sauceLabsFleeceJacketPicture = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img");
    private final By sauceLabsFleeceJacketTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By sauceLabsFleeceJacketDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By sauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");

   public ProductsInformationPages(WebDriver driver){
        this.driver = driver;
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

   public void clickSauceLabsBackpack(){
        driver.findElement(sauceLabsBackpack).click();
   }

   public void clickSauceLabsFleeceJacket(){
        driver.findElement(sauceLabsFleeceJacket).click();
   }

   public void clickBackToProducts(){
        driver.findElement(backToProducts).click();
   }

   public boolean isBackToProductsPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
   }

   public boolean isSauceLabsFleeceJacketPictureDisplayed(){
        return driver.findElement(sauceLabsFleeceJacketPicture).isDisplayed();
   }

   public boolean isSauceLabsFleeceJacketTitleDisplayed(){
        return driver.findElement(sauceLabsFleeceJacketTitle).isDisplayed();
   }

   public boolean isSauceLabsFleeceJacketDescriptionDisplayed(){
        return driver.findElement(sauceLabsFleeceJacketDescription).isDisplayed();
   }

   public boolean isSauceLabsFleeceJacketPriceDisplayed(){
        return driver.findElement(sauceLabsFleeceJacketPrice).isDisplayed();
   }

   public String getSauceLabsFleeceJacketTitleText(){
        return driver.findElement(sauceLabsFleeceJacketTitle).getText();
   }

   public String getSauceLabsFleeceJacketDescription(){
        return driver.findElement(sauceLabsFleeceJacketDescription).getText();
   }

   public String getSauceLabsFleeceJacketPrice(){
        return driver.findElement(sauceLabsFleeceJacketPrice).getText();
   }

}








