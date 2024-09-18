import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SliderMenuPage;

import static org.junit.Assert.*;

public class SliderMenuPageTest {

    private WebDriver driver;
    private SliderMenuPage sliderMenuPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        sliderMenuPage = new SliderMenuPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void allItemsButtonTest() {
        sliderMenuPage.clickSauceLabsBackpack();
        assertTrue(sliderMenuPage.isOnTheSauceLabsBackpackPage());
        sliderMenuPage.clickMenuButton();
        assertTrue(sliderMenuPage.isMenuDisplayed());
        sliderMenuPage.clickAllItems();
        assertTrue(sliderMenuPage.isOnTheProductsPage());
    }

    @Test
    public void aboutButtonTest() {
        sliderMenuPage.clickMenuButton();
        assertTrue(sliderMenuPage.isMenuDisplayed());
        sliderMenuPage.clickAbout();
        assertTrue(sliderMenuPage.isOnAboutPage());
    }

    @Test
    public void logOutButtonTest() {
        sliderMenuPage.clickMenuButton();
        assertTrue(sliderMenuPage.isMenuDisplayed());
        sliderMenuPage.clickLogout();
        assertTrue(sliderMenuPage.isOnLoginPage());
    }

    @Test
    public void resetAppStateButtonTest() { //bug found: remove buttons do not reset!
        sliderMenuPage.addToCartSauceLabsBikeLight();
        assertEquals("Remove",sliderMenuPage.getRemoveSauceLabsBikeLightText());
        assertEquals("1",sliderMenuPage.getCartItemCounter());
        assertTrue(sliderMenuPage.isCartItemCounterDisplayed());
        sliderMenuPage.addToCartSauceLabsBackpack();
        assertEquals("Remove",sliderMenuPage.getRemoveSauceLabsBackpackText());
        assertEquals("2",sliderMenuPage.getCartItemCounter());
        sliderMenuPage.addToCartSauceLabsFleeceJacket();
        assertEquals("Remove",sliderMenuPage.getRemoveSauceLabsFleeceJacketText());
        assertEquals("3",sliderMenuPage.getCartItemCounter());
        sliderMenuPage.addToCartSauceLabsOnesie();
        assertEquals("Remove",sliderMenuPage.getRemoveSauceLabsOnesieText());
        assertEquals("4",sliderMenuPage.getCartItemCounter());
        sliderMenuPage.clickMenuButton();
        assertTrue(sliderMenuPage.isMenuDisplayed());
        sliderMenuPage.clickResetAppState();
        assertFalse(sliderMenuPage.isCartItemCounterDisplayed());

        // BUG FOUND Reset api state button does not clear the cart inventory
//        assertEquals("Add to cart",sliderMenuPage.getAddToCartSauceLabsBackpackText());
//        assertEquals("Add to cart",sliderMenuPage.getAddToCartSauceLabsBikeLightText());
//        assertEquals("Add to cart",sliderMenuPage.getAddToCartSauceLabsFleeceJacketText());
//        assertEquals("Add to cart",sliderMenuPage.getAddToCartSauceLabsOnesie());
    }

}
