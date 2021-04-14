import org.openqa.selenium.WebDriver;
import pom.Admin;
import pom.PIM;
import pom.TimeSheets;
import pom.LoginClass;

import java.io.IOException;
import java.util.Properties;

public class MainTestClass extends PropertyFileReader {

    private static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties prop;
        prop = fileReader("\\src\\main\\resources\\testData.properties");

//        LoginClass ls = new LoginClass();
//
//        ls.openHomePage();
//        ls.validCredentials(prop.getProperty("username"), prop.getProperty("password"));

       // TimeSheets time=new TimeSheets();
      //  PIM pim=new PIM();
        Admin trigger =new Admin();
        driver= trigger.getDriver();

        trigger.openHomePage();
        trigger.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
        trigger.MyTimeSheets();
        trigger.AddTimeSheet();
        trigger.FutureDateTimesheet(prop.getProperty("futureDate"));
        trigger.InvalidDate(prop.getProperty("invalidDate"));
        trigger.InvalidDate(prop.getProperty("invalidDate1"));
        trigger.ClickTimesheetEdit();
        trigger.BlankProjectName();
        trigger.EnterProject(prop.getProperty("projectName"));
        trigger.BlankActivity();
        trigger.EnterActivity();
        trigger.EmployeeTimesheet();
        trigger.BlankEmployeeName();
        trigger.InvalidEmployeeTimesheet(prop.getProperty("invalidEmpTimesheet"));
        trigger.ValidEmployeeTimesheet(prop.getProperty("validEmpTimesheet"));

        trigger.ClickPIMLink();
        trigger.ClickAddEmployee();
        trigger.BlankFirstName();
        trigger.BlankLastName();
        trigger.EmpFullName(prop.getProperty("empFirstName"), prop.getProperty("empLastName"));
        trigger.VerifyEmployeeName();
        trigger.ClickEdit();
        trigger.UploadProfilePic(System.getProperty("user.dir") + "\\picture\\profile.png");
        trigger.DeleteProfilePic();
        trigger.ClickReportsLink();
        trigger.SearchReport(prop.getProperty("reportName"));
        trigger.RunReport();

        trigger.ClickUserManagement();
        trigger.InvalidEmployee(prop.getProperty("invalidEmployee"));
        trigger.ExistingEmployeeName(prop.getProperty("validEmployee"));
        trigger.BlankUsername();
        trigger.UsernameCharacters(prop.getProperty("invalidUsername"));
        trigger.ValidUsername(prop.getProperty("validUsername"));
        trigger.BlankPassword();
        trigger.InvalidPassword(prop.getProperty("invalidPassword"));
        trigger.VeryWeakPassword(prop.getProperty("veryWeakPassword"));
        trigger.BetterPassword(prop.getProperty("betterPassword"));
        trigger.MediumPassword(prop.getProperty("mediumPassword"));
        trigger.StrongPassword(prop.getProperty("strongPassword"));
        trigger.StrongestPassword(prop.getProperty("strongestPassword"));
        trigger.ConfirmPasswordUnMatch(prop.getProperty("unmatchedPassword"));
        trigger.ConfirmPasswordLength(prop.getProperty("invalidLengthPassword"));
        trigger.ConfirmPasswordMatch(prop.getProperty("matchedPassword"));
        trigger.SuccessfullySaved();






    }

}
