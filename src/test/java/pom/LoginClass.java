package pom;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass extends BaseClass {

    public static WebDriver driver;

    public LoginClass(){
        driver= getDriver();
    }


    public void validCredentials(String Username, String Pass) throws InterruptedException {
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).sendKeys(Username);
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).sendKeys(Pass);
        driver.findElement(By.name("Submit")).click();
        String result=driver.getTitle();
        if(result.equals("Dashboard"))
        {
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Unsuccessful");
        }
    }
}
