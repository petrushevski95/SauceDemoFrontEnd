package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {

    private final WebDriver driver;

    private final By cancelButton = By.id("cancel");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipPostalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");

    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public boolean isRedirectedToTheCheckoutOverviewPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterZipPostalCode(String value) {
        driver.findElement(zipPostalCode).sendKeys(value);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage() {
       return driver.findElement(errorMessage).getText();
    }

}
