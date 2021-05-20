package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.util.DataProviders;

public class LoginPageTests extends TestBase{
    String password = "Qwe123123";

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingCSVFile")
    public void registerNeg(String email) throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
        WebElement regButton = driver.findElement(By.cssSelector("button[value=\"Register\"]"));
        regButton.click();
        Assert.assertTrue(driver.findElement(By.className("error-block")).isDisplayed());

    }
}
