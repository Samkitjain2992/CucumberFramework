package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver mydriver;

    public LoginPage(WebDriver mydriver) {
        this.mydriver = mydriver;
        PageFactory.initElements(mydriver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")

    WebElement signinButton;

    @FindBy(id = "email")

    WebElement textEmail;

    @FindBy(xpath = "//input[@id='passwd']")

    WebElement textPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")

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


    public String PageTitle() {
        String pageTitle = mydriver.getTitle();
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

    public void clickSignInButton() {
        btnSignin.click();
    }

    public String pageTitle() {
        String pageTitle = mydriver.getTitle();
        return pageTitle;
    }

    public void clickSignOutButton() {
        btnSignout.click();
    }

    public String getErrorMessageForUnRegisteredUser() {
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
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clearEmailIdAddressBox.clear();

    }


}
