import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertTrue(loginPage.isToProductsPage());
    }

    @Test
    public void errorMessageInvalidPasswordTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauc");
        loginPage.clickLogin();

        String errorMessage = "Epic sadface: Username and password do not match any user in this service";

        assertEquals(errorMessage,loginPage.getErrorMessage());
    }

    @Test
    public void errorMessageInvalidUsernameTestTest() {
        loginPage.enterUsername("standard_user1");
        loginPage.clickLogin();

        assertEquals("Epic sadface: Password is required",loginPage.getErrorMessage());
    }

    @Test
    public void errorMessageEmptyPasswordFieldTest() {
        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();

        String errorMessage = "Epic sadface: Password is required";
        assertEquals(errorMessage,loginPage.getErrorMessage());
    }


    @Test
    public void errorMessageEmptyFieldsTest() {
        loginPage.clickLogin();

        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }

    @Test
    public void colorAssertsTest() {
        loginPage.clickLogin();

        assertEquals("#e2231a",loginPage.getUsernameFieldBottomBorderColor());
        assertEquals("#e2231a",loginPage.getPasswordFieldBottomBorderColor());
        assertEquals("#e2231a",loginPage.getErrorMessageBackgroundColor());
        assertEquals("#3ddc91",loginPage.getLoginButtonBackgroundColor());
    }

}
