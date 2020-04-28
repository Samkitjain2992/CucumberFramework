package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotHandle {

    public void tackScreenShot(WebDriver driver,String filename) throws IOException {
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\Shweta Jain\\Desktop\\Project\\CucumberFramework\\src\\test\\java\\screenShot"+filename+".jpg"));
    }
}
