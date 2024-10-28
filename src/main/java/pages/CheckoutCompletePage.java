package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By thankYouMessage = By.className("complete-header");
    private final By orderCompleteText = By.className("complete-text");
    private final By backHomeButton = By.id("back-to-products");
    private final By signPicture = By.className("pony_express");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getThankYouMessage() {
        return getText(thankYouMessage);
    }

    public boolean isThankYouMessageDisplayed() {
        return isDisplayed(thankYouMessage);
    }

    public String getOrderCompleteText() {
        return getText(orderCompleteText);
    }

    public boolean isOrderCompleteTextDisplayed() {
        return isDisplayed(orderCompleteText);
    }

    public String getBackHomeButtonBackgroundColor() {
        return getColor(backHomeButton, "background-color");
    }

    public String getBackHomeButtonTextColor() {
        return getColor(backHomeButton, "color");
    }

    public String getBackHomeButtonFontSize() {
        return getCssValue(backHomeButton, "font-size");
    }

    public String getBackHomeButtonFontType() {
        return getCssValue(backHomeButton, "font-family");
    }

    public void clickBackHomeButton() {
        clickOnElement(backHomeButton);
    }

    public boolean isRedirectedToProductsPage() {
        return isOnThePage("https://www.saucedemo.com/inventory.html");
    }

    public boolean isSignPictureDisplayed() {
        return isDisplayed(signPicture);
    }

}
