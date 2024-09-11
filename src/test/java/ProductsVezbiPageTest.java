import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsVezbiPage;
import pages.YourCartPage;

import static org.junit.Assert.*;

public class ProductsVezbiPageTest {

    private WebDriver driver;
    private ProductsVezbiPage productsVezbiPage;
    private YourCartPage yourCartPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        yourCartPage = new YourCartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        productsVezbiPage = new ProductsVezbiPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void sauceLabsBikeLightAssertionsTest(){
        String description = "A red light isn't the desired state in testing " +
                "but it sure helps when riding your bike at night. Water-resistant " +
                "with 3 lighting modes, 1 AAA battery included.";

        assertEquals("Sauce Labs Bike Light",productsVezbiPage.getSauceLabsBikeLightTitle());
        assertEquals(description,productsVezbiPage.getSauceLabsBikeLightDescription());
        assertEquals("$9.99",productsVezbiPage.getSauceLabsBikeLightPrice());
    }

    @Test
    public void sauceLabsBikeLightInTheCartTest(){
        productsVezbiPage.addToCartSauceLabsBikeLight();
        productsVezbiPage.clickCartIcon();

        String description = "A red light isn't the desired state in testing " +
                "but it sure helps when riding your bike at night. Water-resistant " +
                "with 3 lighting modes, 1 AAA battery included.";

        assertEquals("Sauce Labs Bike Light",productsVezbiPage.getSauceLabsBikeLightCartTitle());
        assertEquals(description,productsVezbiPage.getSauceLabsBikeLightTheCartDescription());
        assertEquals("$9.99",productsVezbiPage.getSauceLabsBikeLightTheCartPrice());
    }

    @Test
    public void sauceLabsBikeLightCartVsProductPage(){
        String sauceLabsBikeLightProductsPageTitle = productsVezbiPage.getSauceLabsBikeLightTitle();
        String sauceLabsBikeLightProductsPageDescription = productsVezbiPage.getSauceLabsBikeLightDescription();
        String sauceLabsBikeLightProductsPageDescriptionPrice = productsVezbiPage.getSauceLabsBikeLightPrice();

        productsVezbiPage.addToCartSauceLabsBikeLight();
        productsVezbiPage.clickCartIcon();

        assertEquals(sauceLabsBikeLightProductsPageTitle,yourCartPage.getSauceLabsBikeLightTitle());
        assertEquals(sauceLabsBikeLightProductsPageDescription,yourCartPage.getSauceLabsBikeLightDescription());
        assertEquals(sauceLabsBikeLightProductsPageDescriptionPrice,yourCartPage.getSauceLabsBikeLightPrice());

        assertEquals("1",productsVezbiPage.getCartSignNumber());

    }

    @Test
    public void continueShoppingButtonTest(){
        productsVezbiPage.clickCartIcon();
        productsVezbiPage.clickContinueShopping();

        assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    }

    @Test
    public void checkoutButtonTest(){
        productsVezbiPage.clickCartIcon();
        productsVezbiPage.clickCheckoutButton();

        assertEquals("https://www.saucedemo.com/checkout-step-one.html",driver.getCurrentUrl());
    }

    @Test
    public void removeButtonCartPage() {
        productsVezbiPage.addToCartSauceLabsBikeLight();
        productsVezbiPage.clickCartIcon();
        productsVezbiPage.removeSauceLabsBikeLight();

        assertTrue(productsVezbiPage.cartList().isEmpty());
    }

    @Test
    public void cartCounter(){
        productsVezbiPage.addToCartSauceLabsBackpack();
        productsVezbiPage.addToCartSauceLabsTshirt();
        productsVezbiPage.addToCartSauceLabsBikeLight();

        assertTrue(productsVezbiPage.isCartSignDisplayed());
        assertEquals("3",productsVezbiPage.getCartSignNumber());

    }
}
