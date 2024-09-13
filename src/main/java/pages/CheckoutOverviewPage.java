package pages;

import org.openqa.selenium.By;
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
    private final By sauceLabsBikeLightPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By sauceLabsFleeceJacketPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPaymentInformationText(){
        return driver.findElement(paymentInformation).getText();
    }

    public boolean isPaymentInformationDisplayed(){
        return driver.findElement(paymentInformation).isDisplayed();
    }

    public String getPaymentCardText(){
        return driver.findElement(card).getText();
    }

    public boolean isPaymentCardDisplayed(){
        return driver.findElement(card).isDisplayed();
    }

    public String getShippingInformationText(){
        return driver.findElement(shippingInformation).getText();
    }

    public boolean isShippingInformationDisplayed(){
        return driver.findElement(shippingInformation).isDisplayed();
    }

    public String getNameDeliveryText(){
        return driver.findElement(nameDelivery).getText();
    }

    public boolean isDeliveryNameDisplayed(){
        return driver.findElement(nameDelivery).isDisplayed();
    }

    public String getPriceTotalText(){
        return driver.findElement(priceTotal).getText();
    }

    public boolean isSPriceTotalDisplayed(){
        return driver.findElement(priceTotal).isDisplayed();
    }

    public String getTaxText(){
       return driver.findElement(tax).getText();
    }


    public boolean isTaxDisplayed(){
        return driver.findElement(tax).isDisplayed();
    }

    public double getTotal(){
        String price = driver.findElement(total).getText().substring(8);
        return Double.parseDouble(price);
    }

    public boolean isTotalDisplayed(){
        return driver.findElement(total).isDisplayed();
    }

    public double overallPrice(){
        String price1 = driver.findElement(taxPrice).getText().substring(6);
        String price2 = driver.findElement(sauceLabsFleeceJacketPrice).getText().substring(1);
        String price3 = driver.findElement(sauceLabsBikeLightPrice).getText().substring(1);

        return Double.parseDouble(price1) + Double.parseDouble(price2) + Double.parseDouble(price3);
    }
}
