package com.makersacademy.acebook.feature;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignUpTest {

    WebDriver driver;
    Faker faker;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        faker = new Faker();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void userCanSignUp() {
        String email = faker.name().username() + "@email.com";
        String givenName = faker.name().firstName();
        String familyName = faker.name().lastName();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Login / Sign Up")).click();
        driver.findElement(By.xpath("(//a[text()='Sign Up'])[1]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("given_name")).sendKeys(givenName);
        driver.findElement(By.name("family_name")).sendKeys(familyName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("1-password"))
        );
        passwordField.sendKeys("Password123");
        driver.findElement(By.className("auth0-label-submit")).click();
        driver.findElement(By.name("action")).click();
        String actualTitle = driver.getTitle();
        assertThat(actualTitle, containsString("Acebook"));

    }
}
