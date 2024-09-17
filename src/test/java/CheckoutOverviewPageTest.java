import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutOverviewPageTest {

    private WebDriver driver;
    private YourCartPage yourCartPage;
    private ProductsPage productsPage;
    private CheckoutYourInformationPage checkoutInformationPage;
    private pages.CheckoutOverviewPage checkoutOverviewPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new pages.CheckoutOverviewPage(driver);

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
    public void paymentInformationValidation() {
        productsPage.clickAddToCartSauceLabsFleeceJacket();
        productsPage.clickAddToCartSauceLabsBikeLight();
        productsPage.clickCartButton();
        yourCartPage.clickCheckoutButton();
        checkoutInformationPage.enterFirstName("123");
        checkoutInformationPage.enterLastName("123");
        checkoutInformationPage.enterZipPostalCode("999");
        checkoutInformationPage.clickContinueButton();

        assertTrue(checkoutOverviewPage.isPaymentInformationDisplayed());
        assertEquals("Payment Information:",checkoutOverviewPage.getPaymentInformationText());
        assertTrue(checkoutOverviewPage.isPaymentCardDisplayed());
        assertEquals("SauceCard #31337",checkoutOverviewPage.getPaymentCardText());
        assertTrue(checkoutOverviewPage.isShippingInformationDisplayed());
        assertEquals("Shipping Information:",checkoutOverviewPage.getShippingInformationText());
        assertTrue(checkoutOverviewPage.isDeliveryNameDisplayed());
        assertEquals("Free Pony Express Delivery!",checkoutOverviewPage.getNameDeliveryText());
        assertTrue(checkoutOverviewPage.isSPriceTotalDisplayed());
        assertEquals("Price Total",checkoutOverviewPage.getPriceTotalText());
        assertTrue(checkoutOverviewPage.isTaxDisplayed());
        assertEquals("Tax: $4.80",checkoutOverviewPage.getTaxText());
        assertTrue(checkoutOverviewPage.isTotalDisplayed());

        assertEquals(checkoutOverviewPage.getTotal(),checkoutOverviewPage.overallPrice(),0.0);
    }

}
