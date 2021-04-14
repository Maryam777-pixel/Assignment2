package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

    private static WebDriver driver;
    public static String browserName;

    public BaseClass(){
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\selenium\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\selenium\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\selenium\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\selenium\\msedgedriver.exe");
            driver = new EdgeDriver();

        }

    }



    public WebDriver getDriver(){
        return driver;
    }
    public void openHomePage(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }


}
