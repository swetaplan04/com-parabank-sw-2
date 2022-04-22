package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm\n";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    // verifying that signing up page is displayed
    public void verifyThatSigningUpPageDisplay(){
        // This is from requirement
        String expectedText = "Signing up is easy!";
        WebElement registerLink = driver.findElement(By.xpath("//div[@id = 'loginPanel']/child::p[2]/child::a"));
        registerLink.click();

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id = 'mainPanel']/descendant::div[9]/child::h1"));
        String actualText = actualTextElement.getText();
        // Verifying the expectedtext and actualtext using assert
        Assert.assertEquals("Signig up message not displayed",expectedText,actualText);
    }
    @Test
    // Verifying that user can register the account successfully
    public void userShouldRegisterAccountSuccessfully(){
        // This is from requirement

        String expectedText = "Your account was created successfully. You are now logged in.";

        WebElement registerLink = driver.findElement(By.xpath("//div[@id = 'leftPanel']/descendant::a[2]"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.xpath("//form[@id = 'customerForm']/child::table/child::tbody/child::tr/child::td[2]/child::input[1]"));
        firstName.sendKeys("TestUser");

        WebElement lastName = driver.findElement(By.xpath("//form[@id = 'customerForm']/descendant::td[5]/child::input"));
        lastName.sendKeys("TestPassword");

        WebElement address = driver.findElement(By.xpath("//form[@id = 'customerForm']/descendant::input[3]"));
        address.sendKeys("High Street");

        WebElement city = driver.findElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@id = 'customer.address.city']"));
        city.sendKeys("London");

        WebElement state = driver.findElement(By.xpath("//form[@id = 'customerForm']/descendant::input[@name = 'customer.address.state']"));
        state.sendKeys("London");

        WebElement zipCode = driver.findElement(By.xpath("//tr[7]//preceding-sibling::tr[1]/descendant::input"));
        zipCode.sendKeys("EC117QP");

        WebElement phoneNumber = driver.findElement(By.xpath("//tr[1]/following-sibling::tr[6]/child::td[2]/child::*"));
        phoneNumber.sendKeys("0208123456");

        WebElement ssn = driver.findElement(By.xpath("//tr[1]/following-sibling::tr[7]/child::td[2]/child::input"));
        ssn.sendKeys("123456");

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'customer.username']"));
        userName.sendKeys("Kmp1234");

        WebElement password = driver.findElement(By.xpath("//input[@name = 'customer.password']"));
        password.sendKeys("Password123");

        WebElement confirmPassword = driver.findElement(By.xpath("//tr[12]/child::td[2]/child::input[@name= 'repeatedPassword']"));
        confirmPassword.sendKeys("Password100");

        WebElement registerButton = driver.findElement(By.xpath("//tr[13]/child::td[2]/child::input"));
        registerButton.click();

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='bodyPanel']/child::div[2]/child::p"));
        String actualText = actualTextElement.getText();
        // Verifying the expectedtext and actualtext using assert
        Assert.assertEquals("Account not created successfully",expectedText,actualText);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}












