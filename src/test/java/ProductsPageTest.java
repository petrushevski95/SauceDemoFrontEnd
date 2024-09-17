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
    public void addToCartButtonTest() {
        productsPage.clickAddToCartSauceLabsBoltTshirt();

        assertEquals("Remove",productsPage.getRemoveButtonText());
        assertEquals("#e2231a",productsPage.getRemoveButtonBorderColor());
        assertEquals("#e2231a",productsPage.getRemoveButtonTextColor());
        assertTrue(productsPage.cartSignDisplayed());
    }

    @Test
    public void removeButtonTest() {
        productsPage.clickAddToCartSauceLabsBoltTshirt();
        productsPage.clickRemoveSauceLabsBoltTshirt();

        assertEquals("Add to cart",productsPage.getAddToCartSauceLabsBoltTshirtButtonText());
        assertEquals("#132322",productsPage.getAddToCartSauceLabsBoltTshirtButtonBorderColor());
        assertFalse(productsPage.isCartBadgeDisplayed());
    }

    @Test
    public void dropDownTextTest() {
        assertEquals("Name (A to Z)",productsPage.dropdownOptions().get(0).getText());
        assertEquals("Name (Z to A)",productsPage.dropdownOptions().get(1).getText());
        assertEquals("Price (low to high)",productsPage.dropdownOptions().get(2).getText());
        assertEquals("Price (high to low)",productsPage.dropdownOptions().get(3).getText());
    }

    @Test
    public void firstProductNameSortedZtoATest() {
        productsPage.selectDropdownOption(1);

        assertEquals("Name (Z to A)",productsPage.getSelectedDropdownText());
        assertEquals("Test.allTheThings() T-Shirt (Red)",productsPage.getTShirtRedText());
    }

    @Test
    public void priceValidateFirstProductLowToHighTest() {
        productsPage.selectDropdownOption(2);

        assertEquals("Price (low to high)",productsPage.getSelectedDropdownText());
        assertEquals("$7.99",productsPage.getSauceLabsOnesiePrice());
    }

    @Test
    public void priceValidateFirstProductHighToLowTest() {
        productsPage.selectDropdownOption(3);

        assertEquals("Price (high to low)",productsPage.getSelectedDropdownText());
        assertEquals("$49.99",productsPage.getSauceLabsFleeceJacketPrice());
    }

    @Test
    public void cartButtonTest() {
        productsPage.clickCartButton();

        assertTrue(productsPage.isOnTheCartPage());
    }

}

