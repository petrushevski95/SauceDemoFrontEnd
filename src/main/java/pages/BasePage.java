package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void waitForElementToBeClickable(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(elementToBeClickable(locator));
    }

    protected void waitForElementToBeVisible(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeInvisible(By locator,int duration) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(invisibilityOfElementLocated(locator));
    }

    protected void sendKeysToElement(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected String getCssValue(By locator, String property) {
        return findElement(locator).getCssValue(property);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        { try {return driver.findElement(locator).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;}
        }
    }

    protected void clickOnElement(By locator) {
        findElement(locator).click();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected boolean isOnThePage(String url) {
        return getCurrentUrl().equals(url);
    }

    protected String getColor(By locator, String property) {
        return Color.fromString(getCssValue(locator,property)).asHex();
    }

    protected double calculatePriceFromStringToDouble(By locator, int index) {
        String price = driver.findElement(locator).getText().substring(index);
        return Double.parseDouble(price);
    }

    protected boolean isPresent(By locator,String contains) {
        return driver.findElement(locator).getText().contains(contains);
    }

    public double getNumberFromStringToDouble(By locator, int index) {
        String price = driver.findElement(locator).getText().substring(index);
        return Double.parseDouble(price);
    }

    protected List<WebElement> getDropdownOptions(By locator) {
        Select select = new Select(findElement(locator));
        return select.getOptions();
    }

    protected void selectDropdownOption(By dropdownLocator, int optionIndex) {
        Select select = new Select(findElement(dropdownLocator));
        select.selectByIndex(optionIndex);
    }
}
