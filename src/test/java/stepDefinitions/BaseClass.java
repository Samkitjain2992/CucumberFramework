package stepDefinitions;



import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    @Before(order=1)
    public void before_method  (){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
