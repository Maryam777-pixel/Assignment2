package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TimeSheets extends LoginClass {

    public static WebDriver driver;

    public TimeSheets() {
        driver = getDriver();
    }

    public void MyTimeSheets() {
        driver.findElement(By.linkText("Time")).click();
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//a[@id='menu_time_Timesheets' and contains(text(),'Timesheets')]"));
        actions.moveToElement(menuOption).perform();
        driver.findElement(By.xpath("//a[@id='menu_time_viewMyTimesheet' and contains(text(),'My Timesheets')]")).click();
    }

    public void AddTimeSheet() {
        driver.findElement(By.xpath("//a[@id='btnAddTimesheet' and contains(text(),'Add Timesheet')]")).click();

    }

    public void FutureDateTimesheet(String date) {
        driver.findElement(By.xpath("//input[@id='time_date']")).clear();
        driver.findElement(By.xpath("//input[@id='time_date']")).sendKeys(date, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='addTimesheetBtn']")).click();
        String error = driver.findElement(By.xpath("//div[@id='msgDiv' and contains(text(),'Failed to Create:')]")).getText();
        if (error.equalsIgnoreCase("Failed to Create: Future Timesheets Not Allowed")) {
            System.out.println("Future timesheets not allowed");
        } else {
            System.out.println("Enter past timesheets");
        }
    }

    public void InvalidDate(String date) {
        driver.findElement(By.xpath("//a[@id='btnAddTimesheet' and contains(text(),'Add Timesheet')]")).click();
        driver.findElement(By.xpath("//input[@id='time_date']")).clear();
        driver.findElement(By.xpath("//input[@id='time_date']")).sendKeys(date, Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='addTimesheetBtn']")).click();
        String error = driver.findElement(By.xpath("//div[@id='msgDiv' and contains(text(),'valid date')]")).getText();
        if (error.equalsIgnoreCase("Should be a valid date in yyyy-mm-dd format")) {
            System.out.println("Invalid date format");
        } else {
            System.out.println("Enter valid date");
        }

    }

    //
    public void ClickTimesheetEdit() {
        driver.findElement(By.xpath("//input[@id='btnEdit']")).click();
    }

    public void BlankProjectName() {
        driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']")).clear();
        driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']")).sendKeys("");
        driver.findElement(By.id("submitSave")).click();
        String error = driver.findElement(By.xpath("//div[@id='msgDiv' and contains(text(),'Select a')]")).getText();
        if (error.equalsIgnoreCase("Select a Project and an Activity")) {
            System.out.println("Project Name is empty");
        } else {
            System.out.println("Enter project");
        }

    }

    public void EnterProject(String project) {
        driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']")).clear();
        driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']")).sendKeys(project);
        driver.findElement(By.xpath("//input[@id='initialRows_0_projectName']")).sendKeys(Keys.ENTER);
    }
//        Select values = new Select(driver.findElement(By.id("initialRows_0_projectActivityName")));
//        values.selectByVisibleText("QA Testing");

    public void BlankActivity() {
        driver.findElement(By.id("submitSave")).click();

        String error = driver.findElement(By.xpath("//div[@id='msgDiv' and contains(text(),'Select a')]")).getText();
        if (error.equalsIgnoreCase("Select a Project and an Activity")) {
            System.out.println("Activity Name is empty");
        } else {
            System.out.println("Enter activity");
        }
    }

    public void EnterActivity() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='initialRows_0_projectActivityName']//option[contains(text(),'QA')]"))).click();
        driver.findElement(By.id("submitSave")).click();
        System.out.println("Successfully Saved");
    }

    public void EmployeeTimesheet() {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//a[@id='menu_time_Timesheets' and contains(text(),'Timesheets')]"));
        actions.moveToElement(menuOption).perform();
        driver.findElement(By.xpath("//a[@id='menu_time_viewEmployeeTimesheet' and contains(text(),'Employee Timesheets')]")).click();
    }

    public void BlankEmployeeName() {
        driver.findElement(By.id("employee")).clear();
        driver.findElement(By.id("btnView")).click();
        String error = driver.findElement(By.xpath("//span[@class='validation-error' and contains(text(),'Required')]")).getText();
        if (error.equalsIgnoreCase("Required")) {
            System.out.println("Employee name is required to view timesheet");
        } else {
            System.out.println("Enter employee name");
        }
    }

    public void InvalidEmployeeTimesheet(String empTimesheet) {
        driver.findElement(By.id("employee")).clear();
        driver.findElement(By.id("employee")).sendKeys(empTimesheet);
        driver.findElement(By.id("btnView")).click();
        String error = driver.findElement(By.xpath("//span[@class='validation-error' and contains(text(),'Invalid')]")).getText();
        if (error.equalsIgnoreCase("Invalid")) {
            System.out.println("Valid Employee name is required to view timesheet");
        } else {
            System.out.println("Enter valid employee name");
        }
    }

    public void ValidEmployeeTimesheet(String empTimesheet) {
        driver.findElement(By.id("employee")).clear();
        driver.findElement(By.id("employee")).sendKeys(empTimesheet);
        driver.findElement(By.id("employee")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnView")).click();

    }
}





