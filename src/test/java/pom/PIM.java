package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class PIM  extends TimeSheets {

    public static WebDriver driver;

    public PIM() {
        driver = getDriver();
    }

    public void ClickPIMLink() {
        driver.findElement(By.linkText("PIM")).click();
    }

    public void ClickAddEmployee(){
        driver.findElement(By.linkText("Add Employee")).click();
    }

    public void BlankFirstName(){
        driver.findElement(By.id("btnSave")).click();
        String error=driver.findElement(By.xpath("//input[@id='firstName']//following::span[@class='validation-error' and contains(text(),'Required')]")).getText();
        if(error.equalsIgnoreCase("Required")){
            System.out.println("First Name is Required");
        }
        else{
            System.out.println("Enter First Name");
        }

    }

    public void BlankLastName(){
        driver.findElement(By.id("btnSave")).click();
        String error=driver.findElement(By.xpath("//input[@id='lastName']//following::span[@class='validation-error' and contains(text(),'Required')]")).getText();
        if(error.equalsIgnoreCase("Required")){
            System.out.println("Last Name is Required");
        }
        else{
            System.out.println("Enter Last Name");
        }

    }



    public void EmpFullName(String firstName,String lastName){
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("btnSave")).click();
    }

    public void ClickEdit(){

//        WebElement button = driver.findElement(By.id("btnSave"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click();", button);
        driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
    }

    public void VerifyEmployeeName(){
        String empName=driver.findElement(By.xpath("//div[@id='profile-pic']//h1[text()='William Shakespeare']")).getText();
        if(empName.equalsIgnoreCase("William Shakespeare")){
            System.out.println("Employee Name: " + empName);
        }
    }

    public void UploadProfilePic(String path){
        driver.findElement(By.xpath("//img[@id='empPic']")).click();
        driver.findElement(By.xpath("//input[@id='photofile']")).sendKeys(path);
        driver.findElement(By.id("btnSave")).click();

    }

    public void DeleteProfilePic(){
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("btnYes")).click();
    }

    public void ClickReportsLink(){
        driver.findElement(By.linkText("Reports")).click();
    }

    public void SearchReport(String reportName){
        driver.findElement(By.id("search_search")).clear();
        driver.findElement(By.id("search_search")).sendKeys(reportName);
        driver.findElement(By.id("search_search")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();


    }

    public void RunReport(){
        driver.findElement(By.xpath("//a[contains(text(),'Run')]")).click();
    }





}

