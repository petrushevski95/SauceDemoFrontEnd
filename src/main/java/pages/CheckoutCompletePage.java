package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CheckoutCompletePage {

    private final WebDriver driver;
    private final By thankYouMessage = By.className("complete-header");
    private final By orderCompleteText = By.className("complete-text");
    private final By backHomeButton = By.id("back-to-products");
    private final By signPicture = By.className("pony_express");
    private final By checkoutCompleteLogo = By.className("app_logo");

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    public String getThankYouMessage(){
        return driver.findElement(thankYouMessage).getText();
    }

    public boolean isThankYouMessageDisplayed(){
        return driver.findElement(thankYouMessage).isDisplayed();
    }

    public String getOrderCompleteText(){
        return driver.findElement(orderCompleteText).getText();
    }

    public boolean isOrderCompleteTextDisplayed(){
        return driver.findElement(orderCompleteText).isDisplayed();
    }

    public String getBackHomeButtonBackgroundColor(){
        Color backgroundHomeButtoncolor = Color.fromString(driver.findElement(backHomeButton).getCssValue("background-color"));
        return backgroundHomeButtoncolor.asHex();
    }

    public String getBackHomeButtonTextColor(){
        Color backgroundHomeButtoncolor = Color.fromString(driver.findElement(backHomeButton).getCssValue("color"));
        return backgroundHomeButtoncolor.asHex();
    }

    public String getBackHomeButtonFontSize(){
      return driver.findElement(backHomeButton).getCssValue("font-size");
    }

    public String getBackHomeButtonFontType(){
        return driver.findElement(backHomeButton).getCssValue("font-family");
    }

    public void clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }

    public boolean isRedirectedToProductsPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public boolean isSignPictureDisplayed(){
        return driver.findElement(signPicture).isDisplayed();
    }

    public boolean isCheckoutCompletePageLogoDisplayed(){
        return driver.findElement(checkoutCompleteLogo).isDisplayed();
    }

}
