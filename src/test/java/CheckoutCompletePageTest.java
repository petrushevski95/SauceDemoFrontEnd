import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutCompletePageTest {

    private WebDriver driver;
    private CheckoutCompletePage checkoutCompletePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }

    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void backHomeButtonTest(){
        checkoutCompletePage.clickBackHomeButton();
        assertTrue(checkoutCompletePage.isRedirectedToProductsPage());
    }

    @Test
    public void textDisplayed(){
        String orderCompleteMessage = "Your order has been dispatched, " +
                "and will arrive just as fast as the pony can get there!";

        assertTrue(checkoutCompletePage.isThankYouMessageDisplayed());
        assertEquals("Thank you for your order!",checkoutCompletePage.getThankYouMessage());
        assertTrue(checkoutCompletePage.isOrderCompleteTextDisplayed());
        assertEquals(orderCompleteMessage,checkoutCompletePage.getOrderCompleteText());
    }

    @Test
    public void backHomeButtonTextFontColorTest(){
        assertEquals("#3ddc91",checkoutCompletePage.getBackHomeButtonBackgroundColor());
        assertEquals("#132322",checkoutCompletePage.getBackHomeButtonTextColor());
        assertEquals("16px",checkoutCompletePage.getBackHomeButtonFontSize());
        assertEquals("\"DM Sans\", sans-serif",checkoutCompletePage.getBackHomeButtonFontType());
    }



}
