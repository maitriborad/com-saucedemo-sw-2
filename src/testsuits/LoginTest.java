package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseURL = "https://www.saucedemo.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify the text “PRODUCTS”
        String actualText=driver.findElement(By.xpath("//span[text()='Products']")).getText();
        String expectedText="Products";
        Assert.assertEquals("Products not displayed correctly",expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that six products are displayed on page
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualSize= products.size();
        int expectedSize=6;
        Assert.assertEquals("There are not 6 products",expectedSize,actualSize);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
