package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before

    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    // Verifying that user should be able to log in with valid credentials

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // This is from requirement
        String expectedMessage = "Accounts Overview";

        WebElement userName = driver.findElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"));
        userName.sendKeys("Kmp1234");

        WebElement passWord= driver.findElement(By.xpath("//input[@name = 'password']/self::input"));
        passWord.sendKeys("Password123");

        WebElement loginButton = driver. findElement(By.xpath("//div[3][@class = 'login']/child::input"));
        loginButton.click();

        WebElement actualTextElement = driver.findElement(By.linkText("Accounts Overview"));
        String actualMessage = actualTextElement.getText();
        // Verifying the expectedtext and actualtext using assert
        Assert.assertEquals("Accounts Overview not displayed",expectedMessage,actualMessage);
    }

    @Test
    // Verifying that user can not log in with invalid credentials

    public void verifyTheErrorMessage() {
        // This is from requirement
        String expectedMessage = "The username and password could not be verified.";

        WebElement userName = driver.findElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"));
        userName.sendKeys("Abc100");

        WebElement passWord = driver.findElement(By.xpath("//input[@name = 'password']/self::input"));
        passWord.sendKeys("Abc100");

        WebElement loginButton = driver.findElement(By.xpath("//div[3][@class = 'login']/child::input"));
        loginButton.click();

        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@id = 'rightPanel']/child::p"));
        String actualMessage = errorMessageElement.getText();
        // Verifying the expectedtext and actualtext using assert
        Assert.assertEquals("", expectedMessage, actualMessage);
    }
    @Test
    // Verify that user should be able to log out successfully

    public void userShouldLogOutSuccessfully(){
        // This is from requirement
        String expectedText = "Customer Login";

        WebElement userName = driver.findElement(By.xpath("//div/parent::div[1]/child::div[3]//child::div/child::div/child::form/child::div/child::input"));
        userName.sendKeys("TempUser4000");

        WebElement passWord= driver.findElement(By.xpath("//input[@name = 'password']/self::input"));
        passWord.sendKeys("Password100");

        WebElement loginButton = driver.findElement(By.xpath("//div[3][@class = 'login']/child::input"));
        loginButton.click();

        WebElement logOut = driver.findElement(By.linkText("Log Out"));
        logOut.click();

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id = 'bodyPanel']/descendant::h2"));
        String actualText = actualTextElement.getText();
        // Verifying the expectedtext and actualtext using assert
        Assert.assertEquals("can not see the login message",expectedText,actualText);
    }
    @After
    public void tearDown(){
        //  closeBrowser();
    }
}

