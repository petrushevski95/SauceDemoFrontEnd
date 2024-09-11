import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutYourInformationPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private YourCartPage yourCartPage;
    private ProductsPage productsPage;
    private CheckoutYourInformationPage checkoutInformationPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutInformationPage = new CheckoutYourInformationPage(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage.clickCartButton();
        yourCartPage.clickCheckoutButton();
    }

    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void cancelButtonTest(){
        productsPage.clickCartButton();
        yourCartPage.clickCheckoutButton();
        checkoutInformationPage.clickCancelButton();

        assertTrue(yourCartPage.isRedirectedToTheCartPage());
    }

    @Test
    public void successfulCheckoutTest(){
        checkoutInformationPage.enterFirstName("Gorjan");
        checkoutInformationPage.enterLastName("Petrushevski");
        checkoutInformationPage.enterZipPostalCode("280801995");
        checkoutInformationPage.clickContinueButton();

        assertTrue(checkoutInformationPage.isRedirectedToTheCheckoutOverviewPage());

    }

    @Test
    public void errorMessageFirstNameIsRequiredTest(){
        checkoutInformationPage.clickContinueButton();

        assertEquals("Error: First Name is required",checkoutInformationPage.getErrorMessage());
    }

    @Test
    public void errorMessageLastNameIsRequiredTest(){
        checkoutInformationPage.enterFirstName("Gorjan");
        checkoutInformationPage.clickContinueButton();

        assertEquals("Error: Last Name is required",checkoutInformationPage.getErrorMessage());
    }

    @Test
    public void errorMessagePostalCodeIsRequiredTest(){
        checkoutInformationPage.enterFirstName("Gorjan");
        checkoutInformationPage.enterLastName("Petrushevski");
        checkoutInformationPage.clickContinueButton();

        assertEquals("Error: Postal Code is required",checkoutInformationPage.getErrorMessage());
    }

}
