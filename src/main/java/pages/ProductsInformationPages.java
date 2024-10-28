package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsInformationPages extends BasePage {

    private final By backToProducts = By.id("back-to-products");
    private final By removeButton = By.id("remove");
    private final By addToCartButton = By.id("add-to-cart");
    private final By sauceLabsBackpackPicture = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img");
    private final By sauceLabsBackpackTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private final By sauceLabsBackpackDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private final By sauceLabsBackPackPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");

    public ProductsInformationPages(WebDriver driver) {
       super(driver);
    }

    public void clickBackToProducts() {
        clickOnElement(backToProducts);
    }

    public void clickRemoveButton() {
        clickOnElement(removeButton);
    }

    public boolean isBackToProductsPage() {
        return getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean isSauceLabsBackpackPictureDisplayed() {
        return isDisplayed(sauceLabsBackpackPicture);
    }

    public boolean isSauceLabsBackpackTitleDisplayed() {
        return isDisplayed(sauceLabsBackpackTitle);
    }

    public boolean isSauceLabsBackpackDescriptionDisplayed() {
        return isDisplayed(sauceLabsBackpackDescription);
    }

    public boolean isSauceLabsBackpackPriceDisplayed() {
        return isDisplayed(sauceLabsBackPackPrice);
    }

    public String getSauceLabsBackpackTitleText() {
        return getText(sauceLabsBackpackTitle);
    }

    public String getSauceLabsBackpackDescription() {
        return getText(sauceLabsBackpackDescription);
    }

    public String getSauceLabsBackPackPrice() {
        return getText(sauceLabsBackPackPrice);
    }

    public String getAddToCartButtonTextInformationPage() {
        return getText(addToCartButton);
    }

    public String getAddToCartBorderColor() {
       return getColor(addToCartButton,"color");
   }

}








