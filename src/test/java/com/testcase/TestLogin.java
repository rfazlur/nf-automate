package com.testcase;

import com.utils.TestResult;
import com.utils.TestStatus;
import gurock.testrail.APIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLogin {
    WebDriver driver;

    @Parameters({"projectId", "runId", "statusPass", "statusFail"})
    @Test(description = "Login. TC_ID = T3")
    public void Login(String projectId, String runId, String statusPass, String statusFail) throws IOException, APIException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/nodeflux/IdeaProjects/automate/src/sources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://10.7.2.46:4004/login");
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name='0']"));
        txtEmail.sendKeys("fazlur@nodeflux.io");
        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='1']"));
        txtPassword.sendKeys("tester123");
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='submit']"));
        btnLogin.click();
        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals("http://10.7.2.46:4004/")){
            Assert.assertTrue(actualURL.equals("http://10.7.2.46:4004/"));
            TestResult.addResultForTestCase("2", TestStatus.TEST_CASE_PASS_STATUS, "", projectId, runId);
        } else {
            TestResult.addResultForTestCase("2", TestStatus.TEST_CASE_FAIL_STATUS, "", projectId, runId);
        }
        driver.quit();
    }
}
