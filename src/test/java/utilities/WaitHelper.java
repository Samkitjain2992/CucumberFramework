package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    

    

    public static void WaitForElement(WebDriver driver, WebElement element, int i) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
