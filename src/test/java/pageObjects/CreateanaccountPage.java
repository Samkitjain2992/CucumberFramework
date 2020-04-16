package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateanaccountPage {
    WebDriver mydriver;
    public CreateanaccountPage(WebDriver mydriver){
        this.mydriver=mydriver;
        PageFactory.initElements(mydriver,this);
    }

     @FindBy(xpath = "//input[@id='email_create']")
    @CacheLookup
    WebElement textEmail;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    @CacheLookup
    WebElement btnCreatanAccount;



}
