package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage{

    private final By cancelButton = By.id("cancel");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipPostalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        clickOnElement(cancelButton);
    }

    public boolean isRedirectedToTheCheckoutOverviewPage() {
        return isOnThePage("https://www.saucedemo.com/checkout-step-two.html");
    }

    public void enterFirstName(String value) {
        sendKeysToElement(firstName, value);
    }

    public void enterLastName(String value) {
        sendKeysToElement(lastName, value);
    }

    public void enterZipPostalCode(String value) {
        sendKeysToElement(zipPostalCode, value);
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
