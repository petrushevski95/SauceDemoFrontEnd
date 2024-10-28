package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

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
    private final By sauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By sauceLabsBikeLightTitle = By.id("item_0_title_link");
    private final By sauceLabsBikeLightDescription = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private final By sauceLabsBikeLightPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private final By sauceLabsBikeLightQuantity = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[1]");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");
    private final By cartSign = By.className("shopping_cart_badge");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentInformation() {
        return getText(paymentInformation);
    }

    public boolean isPaymentInformationDisplayed() {
        return isDisplayed(paymentInformation);
    }

    public String getPaymentCard() {
        return getText(card);
    }

    public boolean isPaymentCardDisplayed() {
        return isDisplayed(card);
    }

    public String getShippingInformation() {
        return getText(shippingInformation);
    }

    public boolean isShippingInformationDisplayed() {
        return isDisplayed(shippingInformation);
    }

    public String getNameDelivery() {
        return getText(nameDelivery);
    }

    public boolean isDeliveryNameDisplayed() {
        return isDisplayed(nameDelivery);
    }

    public String getPriceTotal() {
        return getText(priceTotal);
    }

    public boolean isPriceTotalDisplayed() {
        return isDisplayed(priceTotal);
    }

    public String getTax() {
       return getText(tax);
    }


    public boolean isTaxDisplayed() {
        return isDisplayed(tax);
    }

    public double getTotal() {
        return getNumberFromStringToDouble(total,8);
    }

    public boolean isTotalDisplayed() {
        return isDisplayed(total);
    }

    public boolean isDollarSignDisplayedOnTotalPrice() {
        return isPresent(total,"$");
    }

    public double overallPrice() {
        return calculatePriceFromStringToDouble(taxPrice,6) + calculatePriceFromStringToDouble(sauceLabsFleeceJacketPrice,1) +
                calculatePriceFromStringToDouble(sauceLabsBikeLightPrice,1);

    }

    public String getSauceLabsBikeLightTitle() {
        return getText(sauceLabsBikeLightTitle);
    }

    public String getSauceLabsBikeLightDescription() {
        return getText(sauceLabsBikeLightDescription);
    }

    public String getSauceLabsBikeLightPrice() {
        return getText(sauceLabsBikeLightPrice);
    }

    public String getSauceLabsBikeLightQuantity() {
        return getText(sauceLabsBikeLightQuantity);
    }

    public boolean isSauceLabsBikeLightTitleDisplayed() {
        return isDisplayed(sauceLabsBikeLightTitle);
    }

    public boolean isSauceLabsBikeLightDescriptionDisplayed() {
        return isDisplayed(sauceLabsBikeLightDescription);
    }

    public boolean isSauceLabsBikeLightPriceDisplayed() {
        return isDisplayed(sauceLabsBikeLightPrice);
    }

    public boolean isSauceLabsBikeLightQuantityDisplayed() {
        return isDisplayed(sauceLabsBikeLightQuantity);
    }

    public String getSauceLabsFleeceJacketTitle() {
        return getText(getSauceLabsFleeceJacketTitle);
    }

    public String getSauceLabsFleeceJacketDescription() {
        return getText(getSauceLabsFleeceJacketDescription);
    }

    public String getSauceLabsFleeceJacketPrice() {
        return getText(getSauceLabsFleeceJacketPrice);
    }

    public String getSauceLabsFleeceJacketQuantity() {
        return getText(getSauceLabsFleeceJacketQuantity);
    }

    public boolean isSauceLabsFleeceJacketTitleDisplayed() {
        return isDisplayed(getSauceLabsFleeceJacketTitle);
    }

    public boolean isSauceLabsFleeceJacketDescriptionDisplayed() {
        return isDisplayed(getSauceLabsFleeceJacketDescription);
    }

    public boolean isSauceLabsFleeceJacketPriceDisplayed() {
        return isDisplayed(getSauceLabsFleeceJacketPrice);
    }

    public boolean isSauceLabsFleeceJacketQuantityDisplayed() {
        return isDisplayed(getSauceLabsFleeceJacketQuantity);
    }

    public void clickCancelButton() {
        clickOnElement(cancelButton);
    }

    public boolean isOnTheProductsPage() {
        return isOnThePage("https://www.saucedemo.com/inventory.html");
    }

    public void clickFinishButton() {
       clickOnElement(finishButton);
    }

    public boolean isOnTheCheckoutCompletePage() {
        return isOnThePage("https://www.saucedemo.com/checkout-complete.html");
    }

    public boolean isRedCartSignDisplayed() {
        return isDisplayed(cartSign);
    }

}
