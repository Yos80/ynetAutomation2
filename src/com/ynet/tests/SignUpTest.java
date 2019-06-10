package com.ynet.tests;

import com.ynet.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    WebDriver driver;

    @BeforeTest
    public void browser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Chrome is launched");
    }

    @Test
    public void signUp(){
        MainPage page = new MainPage(driver);

        page.setEmail("jojt@mailinator.com");
        page.setPassword("Aa123456");
        page.setConfPassword("Aa123456");
        page.setFirstName("joe");
        page.setLastName("smith");
        page.setPhone("0574937558");
        page.pressSubmit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.isSignupPassed();

        }

    @AfterTest
    public void close(){

        driver.close();
        System.out.println("Closing browser");
    }




}
