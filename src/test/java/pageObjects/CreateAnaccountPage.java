package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.BaseClass;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[3]")
    WebElement errorMessageForFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement textLastName;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[2]")
    WebElement errorMessageForLastName;

    @FindBy(id = "email")
    WebElement emailText;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[1]")
    WebElement errorMessageForRegisteredEmailId;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[4]")
    WebElement errorMessageForInvalidEmailID;

    @FindBy(xpath = "//span[@class='form_info']")
    WebElement informationMessageForPassword;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement textPassword;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[4]")
    WebElement errorMessageInvalidPassword;

    @FindBy(xpath = "//select[@id='days']")
    WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    WebElement year;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li[9]")
    WebElement errorMessageForInvalidDate;

    @FindBy(xpath = "//ol/li")
    List<WebElement> mandatoryMessage;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderMaleButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement genderFemaleButton;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressBox;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityBox;

    @FindBy(xpath = "//select[@id='id_state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postCode;

    @FindBy(xpath = "//select[@id='id_country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobileNumber;






    public void setTextEmailCreateAnAccount(String email) {
        String name="Samkit" + UUID.randomUUID().toString().split("-")[0];
        name =name+email;

        textEmailCreateAnAccount.sendKeys(name);
    }

    public void clickCreateAnAccountButton() {
        buttonCreateAnAccount.click();
    }

    public void setFirstName(String firstName) {
        textFirstName.sendKeys(firstName);
    }

    public void clickRegisterButton() {
        buttonRegister.click();
    }

    public String getErrorMessageForFirstName() {
        return errorMessageForFirstName.getText();
    }

    public void clearFirstNameFiled() throws InterruptedException {
        Thread.sleep(3000);
        textFirstName.clear();
    }

    public void setLastName(String lastName) {
        textLastName.sendKeys(lastName);
    }

    public String getErrorMessageForLastName() {
        return errorMessageForLastName.getText();
    }

    public void clearLastName() {
        textLastName.clear();
    }

    public String emailId() throws InterruptedException {
        BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        emailText.click();
        Thread.sleep(3000);
        String value = emailText.getAttribute("value");
        return emailText.getAttribute("value");
    }

    public void clearEmailField() {
        emailText.clear();
    }

    public void setRegisterEmailId(String registerEmailId) {
        emailText.sendKeys(registerEmailId);
    }

    public String getMessageForRegisteredEmailId() {
        return errorMessageForRegisteredEmailId.getText();
    }

    public void setInvalidEmailID(String invalidEmailID) {
        emailText.sendKeys(invalidEmailID);
    }

    public String getMessageForInvalidEmailId() {
        return errorMessageForInvalidEmailID.getText();

    }

    public String getInformationMessagePassword() {
        return informationMessageForPassword.getText();
    }

    public void setInvalidPassword(String invalidPassword) {
        textPassword.sendKeys(invalidPassword);
    }

    public String getErrorMessageInvalidPassword() {
        BaseClass.driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return errorMessageInvalidPassword.getText();

    }

    public void SetDOB(String days, String month, String year) {
        Select Days = new Select(this.days);
        Select Month = new Select(this.month);
        Select Year = new Select(this.year);
        Days.selectByValue(days);
        Month.selectByValue(month);
        Year.selectByValue(year);
    }

    public String getErrorMessageInvalidDate() {
        return errorMessageForInvalidDate.getText();
    }

    public List getMandatoryMessage() {
        List<String> errorMessage = new LinkedList<String>();
        for (int i = 0; i < mandatoryMessage.size(); i++) {
            errorMessage.add(mandatoryMessage.get(i).getText());
        }
        return errorMessage;

    }

    public void setName(String name) {
        textFirstName.sendKeys(name);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            genderMaleButton.click();
        } else if (gender.equals("Female")) {
            genderFemaleButton.click();
        } else {
            genderMaleButton.click(); // Default
        }
    }
    public void setAddress(String address){
        addressBox.sendKeys(address);
    }
    public void setCity(String city){
        cityBox.sendKeys(city);
    }
    public void setState(String state){
        Select State = new Select(this.state);
        State.selectByValue(state);
    }
    public void setZipCode(String zipCode){
        postCode.sendKeys(zipCode);
    }

    public void setCountry(String country){
        Select Country=new Select(this.country);
        Country.selectByValue(country);
    }
    public void setMobileNumber(String mobileNumber){
       this.mobileNumber.sendKeys(mobileNumber);
    }
    public void setPassword(String password){
        textPassword.sendKeys(password);
    }


}






