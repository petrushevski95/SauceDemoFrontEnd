import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.*;

public class CheckoutOverviewPageTest {

    private WebDriver driver;
    private pages.CheckoutOverviewPage checkoutOverviewPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        YourCartPage yourCartPage = new YourCartPage(driver);
        CheckoutYourInformationPage checkoutInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new pages.CheckoutOverviewPage(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        productsPage.clickAddToCartSauceLabsFleeceJacket();
        productsPage.clickAddToCartSauceLabsBikeLight();
        productsPage.clickCartButton();
        yourCartPage.clickCheckoutButton();
        checkoutInformationPage.enterFirstName("Gorjan");
        checkoutInformationPage.enterLastName("Petrushevski");
        checkoutInformationPage.enterZipPostalCode("999");
        checkoutInformationPage.clickContinueButton();
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void cancelButtonTest() {
        checkoutOverviewPage.clickCancelButton();
        assertTrue(checkoutOverviewPage.isOnTheProductsPage());
    }

    @Test
    public void finishButtonTest() {
        checkoutOverviewPage.clickFinishButton();
        assertFalse(checkoutOverviewPage.isRedCartSignDisplayed());
        assertTrue(checkoutOverviewPage.isOnTheCheckoutCompletePage());
    }

    @Test
    public void paymentInformationValidationTest() {
        assertTrue(checkoutOverviewPage.isPaymentInformationDisplayed());
        assertEquals("Payment Information:",checkoutOverviewPage.getPaymentInformation());
        assertTrue(checkoutOverviewPage.isPaymentCardDisplayed());
        assertEquals("SauceCard #31337",checkoutOverviewPage.getPaymentCard());
        assertTrue(checkoutOverviewPage.isShippingInformationDisplayed());
        assertEquals("Shipping Information:",checkoutOverviewPage.getShippingInformation());
        assertTrue(checkoutOverviewPage.isDeliveryNameDisplayed());
        assertEquals("Free Pony Express Delivery!",checkoutOverviewPage.getNameDelivery());
        assertTrue(checkoutOverviewPage.isSPriceTotalDisplayed());
        assertEquals("Price Total",checkoutOverviewPage.getPriceTotal());
        assertTrue(checkoutOverviewPage.isTaxDisplayed());
        assertEquals("Tax: $4.80",checkoutOverviewPage.getTax());
        assertTrue(checkoutOverviewPage.isTotalDisplayed());

        assertEquals(checkoutOverviewPage.getTotal(),checkoutOverviewPage.overallPrice(),0.0);
        assertTrue(checkoutOverviewPage.isDollarSignDisplayedOnTotalPrice());
    }

    @Test
    public void productInformationValidationTest() {
        String sauceLabsBikeLightDescription = "A red light isn't the desired state " +
                "in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";

        String sauceLabsFleeceJacketDescription = "It's not every day that you come across a " +
                "midweight quarter-zip fleece jacket capable of handling everything from a relaxing day " +
                "outdoors to a busy day at the office.";

        assertTrue(checkoutOverviewPage.isSauceLabsFleeceJacketTitleDisplayed());
        assertEquals("Sauce Labs Fleece Jacket",checkoutOverviewPage.getSauceLabsFleeceJacketTitle());
        assertTrue(checkoutOverviewPage.isSauceLabsFleeceJacketDescriptionDisplayed());
        assertEquals(sauceLabsFleeceJacketDescription,checkoutOverviewPage.getSauceLabsFleeceJacketDescription());
        assertTrue(checkoutOverviewPage.isSauceLabsFleeceJacketPriceDisplayed());
        assertEquals("$49.99",checkoutOverviewPage.getSauceLabsFleeceJacketPrice());
        assertTrue(checkoutOverviewPage.isSauceLabsFleeceJacketQuantityDisplayed());
        assertEquals("1",checkoutOverviewPage.getSauceLabsFleeceJacketQuantity());

        assertTrue(checkoutOverviewPage.isSauceLabsBikeLightTitleDisplayed());
        assertEquals("Sauce Labs Bike Light",checkoutOverviewPage.getSauceLabsBikeLightTitle());
        assertTrue(checkoutOverviewPage.isSauceLabsBikeLightDescriptionDisplayed());
        assertEquals(sauceLabsBikeLightDescription,checkoutOverviewPage.getSauceLabsBikeLightDescription());
        assertTrue(checkoutOverviewPage.isSauceLabsBikeLightPriceDisplayed());
        assertEquals("$9.99",checkoutOverviewPage.getSauceLabsBikeLightPrice());
        assertTrue(checkoutOverviewPage.isSauceLabsBikeLightQuantityDisplayed());
        assertEquals("1",checkoutOverviewPage.getSauceLabsBikeLightQuantity());
    }

}
