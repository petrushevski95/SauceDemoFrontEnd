import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsInformationPages;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class ProductsInformationPageTest {

    private WebDriver driver;
    private ProductsInformationPages productsInformationPages;
    private ProductsPage productsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productsInformationPages = new ProductsInformationPages(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void sauceLabsBackPackInformationPageDisplayed(){
        String sauceLabsBackPackDescription = "carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        productsPage.clickSauceLabsBackPackText();

        assertTrue(productsInformationPages.isSauceLabsBackpackPictureDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackTitleDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackDescriptionDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackPriceDisplayed());
        assertEquals("Sauce Labs Backpack",productsInformationPages.getSauceLabsBackpackTitleText());
        assertEquals(sauceLabsBackPackDescription,productsInformationPages.getSauceLabsBackpackDescription());
        assertEquals("$29.99",productsInformationPages.getSauceLabsBackPackPrice());
    }

    @Test
    public void backToProductsButtonTest() {
        productsPage.clickSauceLabsBackPackText();
        productsInformationPages.clickBackToProducts();

        assertTrue(productsInformationPages.isBackToProductsPage());
    }

    @Test
    public void removeButtonItemInformationTest() {
        productsPage.addToCartSauceLabsBackpack();
        productsPage.goToSauceLabsBackPackInventory();
        productsInformationPages.clickRemoveButton();

        assertEquals("Add to cart",productsInformationPages.getAddToCartButtonTextInformationPage());
        assertEquals("#132322",productsInformationPages.getAddToCartBorderColor());
        assertFalse(productsPage.isCartBadgeDisplayed());
    }



}
