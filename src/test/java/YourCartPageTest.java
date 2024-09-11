import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.YourCartPage;

import static org.junit.Assert.*;

public class YourCartPageTest {

    private WebDriver driver;
    private YourCartPage yourCartPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        yourCartPage = new YourCartPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void itemDisplayCartListTest(){
        String sauceLabsBackPackDescription = "carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        yourCartPage.addToCartSauceLabsBackpack();
        yourCartPage.clickCartIcon();

        assertTrue(yourCartPage.isCartSignDisplayed());
        assertEquals("1",yourCartPage.getCartSignCounter());
        assertTrue(yourCartPage.isCartListDisplayed());
        assertEquals("Sauce Labs Backpack",yourCartPage.getSauceLabsBackpackTitle());
        assertEquals(sauceLabsBackPackDescription,yourCartPage.getSauceLabsBackpackDescription());
        assertEquals("1",yourCartPage.getSauceLabsBackpackQuantity());
        assertEquals("$29.99",yourCartPage.getSauceLabsBackpackPrice());
    }

    @Test
    public void removeButtonTest(){
        yourCartPage.addToCartSauceLabsBackpack();
        yourCartPage.clickCartIcon();
        yourCartPage.removeSauceLabsBackpack();

        assertFalse(yourCartPage.isSauceLabsBackpackDisplayed());
        assertFalse(yourCartPage.isCartSignDisplayed());
    }

    @Test
    public void continueShoppingButtonTest(){
        yourCartPage.clickCartIcon();
        yourCartPage.clickContinueShopping();

        assertTrue(yourCartPage.isRedirectedToTheProductsPage());
    }

    @Test
    public void checkoutButtonTest(){
        yourCartPage.clickCartIcon();
        yourCartPage.clickCheckoutButton();

        assertTrue(yourCartPage.isRedirectedToTheCheckoutPage());
    }
}
