package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
public LoginPage lp;
    public WaitHelper waitHelper;

    public void getUrl(String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/java/Drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
this.lp=new LoginPage(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitHelper=new WaitHelper(driver);
    }

}
