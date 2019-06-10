package com.ynet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    //calling the driver
    private WebDriver driver;

    //setting up the url
    private static String PageUrl = "https://www.ynetshops.co.il/login/";

    //setting locators ,elements - factory object style
    @FindBy(id = "register-email")
    private WebElement emailField;

    @FindBy(id = "register-password")
    private WebElement passwordField;

    @FindBy(id = "register-password-confirm")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-first-name")
    private WebElement firstNameField;

    @FindBy(id = "register-last-name")
    private WebElement lastNameField;

    @FindBy(id = "register-cell-phone")
    private WebElement phoneField;

    @FindBy(css = "#customer-register-form > div > div.bottom-form > input.btn.btn-default.pull-right")
    private WebElement registerBTN;

    @FindBy(css = "div > p > a")
    private WebElement nextPageValidation;

    //setting up constructor
    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get(PageUrl);
        //init elements
        PageFactory.initElements(driver,this);

    }

    //setting methods
    public void setEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
        System.out.println("Entered email: " + email);
    }

    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password");

    }

    public void setConfPassword(String confPassword){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confPassword);
        System.out.println("Entered password again");

    }

    public void setFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        System.out.println("Entered first name: " + firstName);

    }

    public void setLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        System.out.println("Entered last name: " + lastName);

    }

    public void setPhone(String phone){
        phoneField.clear();
        phoneField.sendKeys(phone);
        System.out.println("Entered phone number: " +phone);

    }

    public void pressSubmit(){
        registerBTN.click();
        System.out.println("Pressed the submit button");
    }

    public boolean isSignupPassed(){
        //System.out.println("User is signed up");
        return nextPageValidation.getText().contains("לחץ כאן להתנתקות והתחברות עם משתמש אחר");

    }
}
