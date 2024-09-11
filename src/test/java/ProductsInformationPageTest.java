import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsInformationPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsInformationPageTest {

    private WebDriver driver;
    private ProductsInformationPages productsInformationPages;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        productsInformationPages = new ProductsInformationPages(driver);
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
    public void sauceLabsBackPackInformationPageDisplayed(){
        String sauceLabsBackPackDescription = "carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        productsInformationPages.clickSauceLabsBackpack();

        assertTrue(productsInformationPages.isSauceLabsBackpackPictureDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackTitleDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackDescriptionDisplayed());
        assertTrue(productsInformationPages.isSauceLabsBackpackPriceDisplayed());
        assertEquals("Sauce Labs Backpack",productsInformationPages.getSauceLabsBackpackTitleText());
        assertEquals(sauceLabsBackPackDescription,productsInformationPages.getSauceLabsBackpackDescription());
        assertEquals("$29.99",productsInformationPages.getSauceLabsBackPackPrice());
    }

    @Test
    public void backToProductsButtonTest(){
        productsInformationPages.clickSauceLabsBackpack();
        productsInformationPages.clickBackToProducts();

        assertTrue(productsInformationPages.isBackToProductsPage());
    }

    @Test
    public void sauceSauceLabsFleeceJacketInformationPageDisplayed(){
        String SauceLabsFleeceJacketDescription = "It's not every day that you come across a midweight " +
                "quarter-zip fleece jacket capable of handling everything " +
                "from a relaxing day outdoors to a busy day at the office.";

        productsInformationPages.clickSauceLabsFleeceJacket();

        assertTrue(productsInformationPages.isSauceLabsFleeceJacketPictureDisplayed());
        assertTrue(productsInformationPages.isSauceLabsFleeceJacketTitleDisplayed());
        assertTrue(productsInformationPages.isSauceLabsFleeceJacketDescriptionDisplayed());
        assertTrue(productsInformationPages.isSauceLabsFleeceJacketPriceDisplayed());
        assertEquals("Sauce Labs Fleece Jacket",productsInformationPages.getSauceLabsFleeceJacketTitleText());
        assertEquals(SauceLabsFleeceJacketDescription,productsInformationPages.getSauceLabsFleeceJacketDescription());
        assertEquals("$49.99",productsInformationPages.getSauceLabsFleeceJacketPrice());
    }
}
