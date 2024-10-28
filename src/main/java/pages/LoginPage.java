package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private final By errorMessageBackgroundColor = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private final By bottomBorderColorUsernameField = By.id("user-name");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername (String value) {
        sendKeysToElement(usernameField,value);
    }

    public void enterPassword (String value) {
        sendKeysToElement(passwordField, value);
    }

    public void clickLogin() {
        clickOnElement(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isToProductsPage() {
        return isOnThePage("https://www.saucedemo.com/inventory.html");
    }

    public String getUsernameFieldBottomBorderColor() {
       return getColor(bottomBorderColorUsernameField,"border-bottom-color");
    }

    public String getPasswordFieldBottomBorderColor() {
        return getColor(passwordField, "border-bottom-color");
    }


    public String getErrorMessageBackgroundColor() {
        return getColor(errorMessageBackgroundColor,"background-color");
    }

    public String getLoginButtonBackgroundColor() {
       return  getColor(loginButton,"background-color");
    }

}
