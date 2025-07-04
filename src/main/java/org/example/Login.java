package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Login {


    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String Name = "Test";
    protected static String Email = "Test@test.com";
    protected static String Phone = "01178958034";
    protected static String Password = "123456";


    public static void Login() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(200));
    }

    public static void clickOnForgetPassword(){
        driver.findElement(By.partialLinkText("Forgot")).click();
    }

    public static void fillForgetPassForm(String Name , String Email , String Phone){
        driver.findElement(By.xpath("(//form/input)[1]")).sendKeys(Name);
        driver.findElement(By.xpath("(//form/input)[2]")).sendKeys(Email);
        driver.findElement(By.xpath("(//form/input)[3]")).sendKeys(Phone);
    }

    public static void backToLogin(){
      WebElement goToLogin = driver.findElement(By.className("go-to-login-btn"));
      wait.until(ExpectedConditions.elementToBeClickable(goToLogin));
      goToLogin.click();
    }

    public static void loginWithInvalidData(String UserName , String Password) throws InterruptedException {driver.findElement(By.xpath("//*[@id='inputUsername']")).sendKeys(UserName);

        driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(Password);
        WebElement signInBtn=  driver.findElement(By.xpath("//button[text()='Sign In']"));
        System.out.println(signInBtn.isDisplayed());
        Thread.sleep(100);
        signInBtn.click();
        Thread.sleep(1000);
        WebElement ErrorMsg = driver.findElement(By.xpath("//p[text()='* Incorrect username or password']"));
        System.out.println(ErrorMsg.getText());

    }

    public static void main(String[] args) throws Exception{
        Login();
        clickOnForgetPassword();
        fillForgetPassForm(Name,Email,Phone);
        backToLogin();
        loginWithInvalidData(Name,Password);
        //
    }
















}