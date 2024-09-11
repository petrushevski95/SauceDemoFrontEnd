package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername (String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

}
