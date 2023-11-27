package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */
public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        // * * Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        // * * Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        // * * Verify the text “PRODUCTS”
        assertEqualsMethod("Incorrect message", "Products", By.cssSelector(".title"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        // * * Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        // * * Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        // * * Verify that six products are displayed on page
        List<WebElement> elementList = findElementsList(By.xpath("//div[@class='inventory_item']"));
        int actualNumbers = elementList.size();
        Assert.assertEquals("Incorrect number of products displayed!", 6, actualNumbers);
        System.out.println("Expected products are: 6");
        System.out.println("Actual Products are: " + actualNumbers);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
