package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public WebDriver mydriver;

    public WaitHelper(WebDriver mydriver) {
        this.mydriver = mydriver;
    }

    public void WaitForElement(WebElement element, Long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(mydriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
