package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin extends PIM{

    public static WebDriver driver;

    public Admin() {
        driver = getDriver();
    }

    public void ClickUserManagement(){
        driver.findElement(By.linkText("Admin")).click();
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.id("menu_admin_UserManagement"));
        actions.moveToElement(menuOption).perform();
        driver.findElement(By.id("menu_admin_viewSystemUsers")).click();

    }

    public void InvalidEmployee(String invalidEmp){
        driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys(invalidEmp);
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']//following::span[contains(text(),'Employee does')]")).getText();
        if(error_message.equalsIgnoreCase("Employee does not exist")){
            System.out.println("Employee is not there");
        }
        else{
            System.out.println("enter existing employee");
        }
    }

    public void ExistingEmployeeName(String EmployeeName){
        driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).clear();
        driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys(EmployeeName, Keys.RETURN);
        String message=driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']//following::span[contains(text(),'Employee does')]")).getText();
        if(message.equalsIgnoreCase("")){
            System.out.println("Employee is there");
        }
        else{
            System.out.println("enter existing employee");
        }

    }

    public void BlankUsername(){
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_userName']//following::span[contains(text(),'Required')]")).getText();
        if(error_message.equalsIgnoreCase("Required")){
            System.out.println("Username is empty");
        }
        else{
            System.out.println("Enter username");
        }

    }

    public void UsernameCharacters(String Username){
        driver.findElement(By.id("systemUser_userName")).sendKeys(Username);
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_userName']//following::span[contains(text(),'Should have')]")).getText();
        if(error_message.equalsIgnoreCase("Should have at least 5 characters")){
            System.out.println("Username should be atleast 5 characters long");
        }
        else{
            System.out.println("Entered username has less than 5 characters");
        }

    }

    public void ValidUsername(String Username){
        driver.findElement(By.id("systemUser_userName")).clear();
        driver.findElement(By.id("systemUser_userName")).sendKeys(Username);
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_userName']//following::span[contains(text(),'Should have')]")).getText();
        if(error_message.equalsIgnoreCase("")){
            System.out.println("Valid Username");
        }
        else{
            System.out.println("Entered username has less than 5 characters");
        }

    }

    public void BlankPassword(){
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_password']//following::span[contains(text(),'Required')]")).getText();
        if(error_message.equalsIgnoreCase("Required")){
            System.out.println("Password is empty");
        }
        else{
            System.out.println("Enter password");
        }

    }

    public void InvalidPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        String error_message=driver.findElement(By.xpath("//input[@id='systemUser_password']//following::span[contains(text(),'Should have')]")).getText();
        if(error_message.equalsIgnoreCase("")){
            System.out.println("Password should be atleast 8 characters long");
        }
        else{
            System.out.println("Entered password has less than 8 characters");
        }

    }

    public void VeryWeakPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Very Weak')]")));
        String error_message=driver.findElement(By.xpath("//span[contains(text(),'Very Weak')]")).getText();
        if(error_message.equalsIgnoreCase("Very Weak")){
            System.out.println("Your Password is very weak");
        }
        else{
            System.out.println("Enter another password");
        }

    }

    public void BetterPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Better')]")));
        String error_message=driver.findElement(By.xpath("//span[contains(text(),'Better')]")).getText();
        if(error_message.equalsIgnoreCase("Better")){
            System.out.println("Your Password is better");
        }
        else{
            System.out.println("Enter another password!!!!");
        }

    }

    public void MediumPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Medium')]")));
        String error_message=driver.findElement(By.xpath("//span[contains(text(),'Medium')]")).getText();
        if(error_message.equalsIgnoreCase("Medium")){
            System.out.println("Your Password is medium");
        }
        else{
            System.out.println("Enter another password");
        }

    }

    public void StrongPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Strong')]")));
        String error_message=driver.findElement(By.xpath("//span[contains(text(),'Strong')]")).getText();
        if(error_message.equalsIgnoreCase("Strong")){
            System.out.println("Your Password is strong");
        }
        else{
            System.out.println("Enter another password");
        }

    }
    public void StrongestPassword(String password){
        driver.findElement(By.id("systemUser_password")).clear();
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Strongest')]")));
        String error_message=driver.findElement(By.xpath("//span[contains(text(),'Strongest')]")).getText();
        if(error_message.equalsIgnoreCase("Strongest")){
            System.out.println("Your Password is strongest");
        }
        else{
            System.out.println("Enter another password");
        }

    }

    public void ConfirmPasswordUnMatch(String confirmPassword){
        driver.findElement(By.id("systemUser_confirmPassword")).clear();
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='systemUser_confirmPassword']//following::span[contains(text(),'Passwords')]")));
        String error_message=driver.findElement(By.xpath("//*[@id='systemUser_confirmPassword']//following::span[contains(text(),'Passwords')]")).getText();
        if(error_message.equalsIgnoreCase("Passwords do not match")){
            System.out.println("Your Passwords do not match");
        }
        else{
            System.out.println("Enter matched Password");
        }

    }


    public void ConfirmPasswordLength(String confirmPassword){
        driver.findElement(By.id("systemUser_confirmPassword")).clear();
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='systemUser_confirmPassword']//following::span[contains(text(),'Please enter')]")));
        String error_message=driver.findElement(By.xpath("//*[@id='systemUser_confirmPassword']//following::span[contains(text(),'Please enter')]")).getText();
        if(error_message.equalsIgnoreCase("Please enter at least 8 characters.")){
            System.out.println("Enter at least 8 characters");
        }
        else{
            System.out.println("Enter another Password");
        }

    }

    public void ConfirmPasswordMatch(String confirmPassword){
        driver.findElement(By.id("systemUser_confirmPassword")).clear();
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(confirmPassword);

        System.out.println("Passwords match");
    }

    public void SuccessfullySaved() {
        driver.findElement(By.id("btnSave")).click();
    }


}
