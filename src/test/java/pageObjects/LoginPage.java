package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.BaseClass;
import utilities.ScreenShotHandle;
import utilities.WaitHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    ScreenShotHandle screenShotHandle = new ScreenShotHandle();


    public LoginPage() {

        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signinButton;

    @FindBy(id = "email")
    WebElement textEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement textPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSignin;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement btnSignout;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol")
    WebElement errorMessageForUnRegisteredUser;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    WebElement errorMessageForInvalidEmailId;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    WebElement errorMessageForWrongPassword;

    @FindBy(id = "email")
    WebElement clearEmailIdAddressBox;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    WebElement forgetPasswordButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//span[text()='Retrieve Password']")
    WebElement retrievePasswordButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement confirmationMessage;

    @FindBy(xpath = "//i[@class='icon-chevron-left']")
    WebElement backtoLoginButton;


    public String PageTitle() {
        String pageTitle = BaseClass.driver.getTitle();
        return pageTitle;
    }

    public void clickSignin() {
        signinButton.click();
    }

    public void setEmailAddress(String emailAddress) throws InterruptedException {
        Thread.sleep(3000);
        textEmail.click();
        textEmail.sendKeys(emailAddress);
    }

    public void setEmailPassword(String password) {
        textPassword.clear();
        textPassword.sendKeys(password);
    }

    public void clickSignInButton() throws IOException, InterruptedException {
        WaitHelper.WaitForElement(BaseClass.driver,btnSignin,10);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
        js.executeScript("arguments[0].click()", btnSignin);
        // btnSignin.click();
        screenShotHandle.tackScreenShot(BaseClass.driver, "TestCaseFail");
    }

    public String pageTitle() {
        String pageTitle = BaseClass.driver.getTitle();
        return pageTitle;
    }

    public void clickSignOutButton() {
        btnSignout.click();
    }

    public String getErrorMessageForUnRegisteredUser() throws IOException {
        WaitHelper.WaitForElement(BaseClass.driver, errorMessageForUnRegisteredUser, 10);
        screenShotHandle.tackScreenShot(BaseClass.driver, "TestCaseFail");
        return errorMessageForUnRegisteredUser.getText();

    }

    public String getErrorMessageForInvalidEmailId() {
        return errorMessageForInvalidEmailId.getText();
    }


    public String getErrorMessageForWrongPassword() {
        return errorMessageForWrongPassword.getText();
    }

    public void clearEmailField() {
        clearEmailIdAddressBox.click();
        BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clearEmailIdAddressBox.clear();
    }

    public void clickForgetPassword() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
        js.executeScript("arguments[0].click()", forgetPasswordButton);
//        forgetPasswordButton.click();
    }

    public void setTextEmailBox(String email) {
        emailTextBox.sendKeys(email);
    }

    public void clickRetrievePasswordButton() {
        retrievePasswordButton.click();
    }

    public String confirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickBackToLoginButton() {
        backtoLoginButton.click();
    }


}
