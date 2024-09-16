package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage {

    private WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private final By errorMessageBackgroundColor = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private final By bottomBorderColorUsernameField = By.id("user-name");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername (String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getUsernameFieldBottomBorderColor() {
        Color bottomBorderColor = Color.fromString(driver.findElement(bottomBorderColorUsernameField).getCssValue("border-bottom-color"));
        return bottomBorderColor.asHex();
    }

    public String getPasswordFieldBottomBorderColor() {
        Color bottomBorderColor = Color.fromString(driver.findElement(passwordField).getCssValue("border-bottom-color"));
        return bottomBorderColor.asHex();
    }

    public String getErrorMessageBackgroundColor() {
        Color backgroundColor = Color.fromString(driver.findElement(errorMessageBackgroundColor).getCssValue("background-color"));
        return backgroundColor.asHex();
    }

    public String getLoginButtonBackgroundColor() {
        Color bottomBorderColor = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return bottomBorderColor.asHex();
    }



}
