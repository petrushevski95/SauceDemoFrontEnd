package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    private final By paymentInformation = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]");
    private final By card = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]");
    private final By shippingInformation = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]");
    private final By nameDelivery = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");
    private final By priceTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private final By tax = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private final By taxPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private final By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
    private final By getSauceLabsFleeceJacketTitle = By.id("item_5_title_link");
    private final By getSauceLabsFleeceJacketDescription = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private final By getSauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By getSauceLabsFleeceJacketQuantity = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[1]");
    private final By sauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private final By sauceLabsBikeLightTitle = By.id("item_0_title_link");
    private final By sauceLabsBikeLightDescription = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private final By sauceLabsBikeLightPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private final By sauceLabsBikeLightQuantity = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[1]");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");
    private final By cartSign = By.className("shopping_cart_badge");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPaymentInformation() {
        return driver.findElement(paymentInformation).getText();
    }

    public boolean isPaymentInformationDisplayed() {
        return driver.findElement(paymentInformation).isDisplayed();
    }

    public String getPaymentCard() {
        return driver.findElement(card).getText();
    }

    public boolean isPaymentCardDisplayed() {
        return driver.findElement(card).isDisplayed();
    }

    public String getShippingInformation() {
        return driver.findElement(shippingInformation).getText();
    }

    public boolean isShippingInformationDisplayed() {
        return driver.findElement(shippingInformation).isDisplayed();
    }

    public String getNameDelivery() {
        return driver.findElement(nameDelivery).getText();
    }

    public boolean isDeliveryNameDisplayed() {
        return driver.findElement(nameDelivery).isDisplayed();
    }

    public String getPriceTotal() {
        return driver.findElement(priceTotal).getText();
    }

    public boolean isSPriceTotalDisplayed() {
        return driver.findElement(priceTotal).isDisplayed();
    }

    public String getTax() {
       return driver.findElement(tax).getText();
    }


    public boolean isTaxDisplayed() {
        return driver.findElement(tax).isDisplayed();
    }

    public double getTotal() {
        String price = driver.findElement(total).getText().substring(8);
        return Double.parseDouble(price);
    }

    public boolean isTotalDisplayed() {
        return driver.findElement(total).isDisplayed();
    }

    public boolean isDollarSignDisplayedOnTotalPrice() {
        return driver.findElement(total).getText().contains("$");
    }

    public double overallPrice() {
        String price1 = driver.findElement(taxPrice).getText().substring(6);
        String price2 = driver.findElement(sauceLabsFleeceJacketPrice).getText().substring(1);
        String price3 = driver.findElement(sauceLabsBikeLightPrice).getText().substring(1);

        return Double.parseDouble(price1) + Double.parseDouble(price2) + Double.parseDouble(price3);
    }

    public String getSauceLabsBikeLightTitle() {
        return driver.findElement(sauceLabsBikeLightTitle).getText();
    }

    public String getSauceLabsBikeLightDescription() {
        return driver.findElement(sauceLabsBikeLightDescription).getText();
    }

    public String getSauceLabsBikeLightPrice() {
        return driver.findElement(sauceLabsBikeLightPrice).getText();
    }

    public String getSauceLabsBikeLightQuantity() {
        return driver.findElement(sauceLabsBikeLightQuantity).getText();
    }

    public boolean isSauceLabsBikeLightTitleDisplayed() {
        return driver.findElement(sauceLabsBikeLightTitle).isDisplayed();
    }

    public boolean isSauceLabsBikeLightDescriptionDisplayed() {
        return driver.findElement(sauceLabsBikeLightDescription).isDisplayed();
    }

    public boolean isSauceLabsBikeLightPriceDisplayed() {
        return driver.findElement(sauceLabsBikeLightPrice).isDisplayed();
    }

    public boolean isSauceLabsBikeLightQuantityDisplayed() {
        return driver.findElement(sauceLabsBikeLightQuantity).isDisplayed();
    }

    public String getSauceLabsFleeceJacketTitle() {
        return driver.findElement(getSauceLabsFleeceJacketTitle).getText();
    }

    public String getSauceLabsFleeceJacketDescription() {
        return driver.findElement(getSauceLabsFleeceJacketDescription).getText();
    }

    public String getSauceLabsFleeceJacketPrice() {
        return driver.findElement(getSauceLabsFleeceJacketPrice).getText();
    }

    public String getSauceLabsFleeceJacketQuantity() {
        return driver.findElement(getSauceLabsFleeceJacketQuantity).getText();
    }

    public boolean isSauceLabsFleeceJacketTitleDisplayed() {
        return driver.findElement(getSauceLabsFleeceJacketTitle).isDisplayed();
    }

    public boolean isSauceLabsFleeceJacketDescriptionDisplayed() {
        return driver.findElement(getSauceLabsFleeceJacketDescription).isDisplayed();
    }

    public boolean isSauceLabsFleeceJacketPriceDisplayed() {
        return driver.findElement(getSauceLabsFleeceJacketPrice).isDisplayed();
    }

    public boolean isSauceLabsFleeceJacketQuantityDisplayed() {
        return driver.findElement(getSauceLabsFleeceJacketQuantity).isDisplayed();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public boolean isOnTheProductsPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public boolean isOnTheCheckoutCompletePage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html");
    }

    public boolean isRedCartSignDisplayed() {
        { try {return driver.findElement(cartSign).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;}
        }
    }
}
