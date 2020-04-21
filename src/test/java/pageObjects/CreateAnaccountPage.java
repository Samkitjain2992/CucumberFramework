package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.BaseClass;

public class CreateAnaccountPage {

    public CreateAnaccountPage() {

        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement textEmailCreateAnAccount;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement buttonCreateAnAccount;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement textFirstName;

    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement buttonRegister;

    @FindBy(xpath = "//li[text()=' is invalid.']")
    WebElement errorMessageForFirstName;


    public void setTextEmailCreateAnAccount(String email) {
        textEmailCreateAnAccount.sendKeys(email);
    }

    public void clickCreateAnAccountButton() {
        buttonCreateAnAccount.click();
    }
    public void setFirstName(String firstName){
        textFirstName.sendKeys(firstName);
    }
    public void clickRegisterButton(){
        buttonRegister.click();
    }
    public String getErrorMessageForFirstName(){
        return errorMessageForFirstName.getText();
    }
    public void clearFirstNameFiled() throws InterruptedException {
        Thread.sleep(3000);
        textFirstName.clear();
    }


}
