import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class ProductsPageTest {

    private WebDriver driver;
    private ProductsPage productsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void clickOnProductTextTest() {
        productsPage.clickSauceLabsBackpackText();

        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4",productsPage.currentUrl());
    }

    @Test
    public void clickOnBackToProductButtonTest() {
        productsPage.clickSauceLabsBackpackText();
        productsPage.clickBackToProducts();

        assertEquals("https://www.saucedemo.com/inventory.html",productsPage.currentUrl());
    }

    @Test
    public void addToCartButtonTest() {
        productsPage.clickAddToCartSauceLabsBoltTshirt();

        assertEquals("Remove",productsPage.getRemoveButtonText());
        assertEquals("#e2231a",productsPage.getRemoveButtonBorderColor());
        assertEquals("#e2231a",productsPage.getRemoveButtonTextColor());
        assertTrue(productsPage.cartSignDisplayed());
    }

    @Test
    public void removeCartButtonTest() throws InterruptedException {
        productsPage.clickAddToCartSauceLabsBoltTshirt();
        productsPage.removeSauceBackPackTshirt();

        assertEquals("Add to cart",productsPage.getAddToCartSauceLabsBoltTshirtButtonText());
        assertEquals("rgba(255, 255, 255, 1)",productsPage.getAddToCartSauceLabsBoltTshirtButtonTextColor());
        assertFalse(productsPage.isCartBadgePresent());
    }

    @Test
    public void dropDownTextTest(){
        assertEquals("Name (A to Z)",productsPage.dropdownOptions().get(0).getText());
        assertEquals("Name (Z to A)",productsPage.dropdownOptions().get(1).getText());
        assertEquals("Price (low to high)",productsPage.dropdownOptions().get(2).getText());
        assertEquals("Price (high to low)",productsPage.dropdownOptions().get(3).getText());
    }

    @Test
    public void firstProductNameTest(){
        assertEquals("Name (A to Z)",productsPage.getSelectedDropdownText());
        assertEquals("Sauce Labs Backpack",productsPage.SauceBackPackTshirtText());
    }


    @Test
    public void firstProductNameSortedZtoATest(){
        productsPage.selectDropdownOption(1);

        assertEquals("Name (Z to A)",productsPage.getSelectedDropdownText());
        assertEquals("Test.allTheThings() T-Shirt (Red)",productsPage.getTShirtRedText());
    }

    @Test
    public void priceValidateFirstProductLowToHighTest(){
        productsPage.selectDropdownOption(2);

        assertEquals("Price (low to high)",productsPage.getSelectedDropdownText());
        assertEquals("$7.99",productsPage.getSauceLabsOnesiePrice());
    }

    @Test
    public void priceValidateFirstProductHighToLowTest(){
        productsPage.selectDropdownOption(3);

        assertEquals("Price (high to low)",productsPage.getSelectedDropdownText());
        assertEquals("$49.99",productsPage.getSauceLabsFleeceJacketPrice());
    }

    @Test
    public void validateTheDollarSignTest(){
        assertTrue(productsPage.getSauceLabsOnesiePrice().contains("$"));
    }

    @Test
    public void cartButtonTest(){
        productsPage.clickCartButton();

        assertEquals("https://www.saucedemo.com/cart.html",productsPage.currentUrl());
    }

    @Test
    public void removeButtonItemInformationTest() throws InterruptedException {
        productsPage.addToCartSauceLabsBackpack();
        productsPage.goToSauceLabsBackPackInventory();
        productsPage.clickRemoveButton();

        assertEquals("Add to cart",productsPage.getAddToCartButtonTextInformationPage());
        assertEquals("rgba(255, 255, 255, 1)",productsPage.getAddToCartButtonColorInformationPage());
        assertFalse(productsPage.isCartBadgePresent());
    }
}

