package com.idodevjobs.example.test;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;

public class AngularTest {

    private ChromeDriver driver;
    private ByAngular ng;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("localhost:8080/spring-data-rest-angularjs-example");
        ng = new ByAngular(driver);
        waitForAngularRequestsToFinish(driver);
    }

    @AfterTest
    public void tear_down() {
        driver.quit();
    }

    @Test
    public void pageTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNewTaskBtn")));
        element.click();
    }




}