package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.CreateAnaccountPage;
import utilities.DateHelper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RegistrationSD {

    CreateAnaccountPage cp =null;
    DateHelper dh=null;
    @Before(order=3)
    public void before_method  (){
        cp=new CreateAnaccountPage();
    }
    @When("^User enters create an account EmailAddress filed as\"([^\"]*)\"$")
    public void userEntersCreateAnAccountEmailAddressFiledAs(String email) {
        cp.setTextEmailCreateAnAccount(email);

    }

    @Given("^Registration Page$")
    public void registrationPage() {
        cp.clickCreateAnAccountButton();
    }

    @And("^User enter name as \"([^\"]*)\"$")
    public void userEnterNameFiledAs(String firstName)  {
        cp.setFirstName(firstName);
    }

    @And("^Click on Register button$")
    public void userClickOnRegisterButton() {
        cp.clickRegisterButton();
    }

    @When("^Error message for invalid first name is \"([^\"]*)\"$")
    public void errorMessageForInvalidFirstNameIs(String message)  {
        Assert.assertTrue(cp.getErrorMessageForFirstName().contains(message));
    }

    @And("^Clear name filed$")
    public void clearNameFiled() throws InterruptedException {
        cp.clearFirstNameFiled();
    }

    @And("^User enter lastname as \"([^\"]*)\"$")
    public void userEnterLastnameAs(String lastName)  {
        cp.setLastName(lastName);
    }
    @Then("^Error message for invalid last name is \"([^\"]*)\"$")
    public void errorMessageForInvalidLastNameIs(String message) {
        Assert.assertTrue(cp.getErrorMessageForLastName().contains(message));
    }
    @And("^Clear last name filed$")
    public void clearLastNameFiled() {
        cp.clearLastName();
    }


    @And("^Email id should display which enter while registration as \"([^\"]*)\"$")
    public void emailIdShouldDisplayWhichEnterWhileRegistrationAs(String message) throws InterruptedException {


       Assert.assertEquals(message,cp.emailId());
    }

    @And("^Clear email field on registration page$")
    public void clearEmailFieldOnRegistrationPage() {
        cp.clearEmailField();
    }

    @When("^User enter already registered email id as \"([^\"]*)\"$")
    public void userEnterAlreadyRegisteredEmailIdAs(String registerEmailId) {
        cp.setRegisterEmailId(registerEmailId);
    }

    @Then("^validation message for already registered user is \"([^\"]*)\"$")
    public void validationMessageForAlreadyRegisteredUserIs(String message)  {
        Assert.assertTrue(cp.getMessageForRegisteredEmailId().contains(message));

    }

    @When("^User enter invalid email id as \"([^\"]*)\"$")
    public void userEnterInvalidEmailIdAs(String emailId)  {
        cp.setInvalidEmailID(emailId);
    }

    @Then("^validation message for invalid email id should be \"([^\"]*)\"$")
    public void validationMessageForInvalidEmailIdShouldBe(String message)  {
        Assert.assertTrue("MessageForInvalidEmailId",cp.getMessageForInvalidEmailId().contains(message));
    }

    @When("^Validate all mandatory message$")
    public void validateAllMandatoryMessage() {
        List<String> mandatoryMessage = new LinkedList<String>();
        mandatoryMessage.add("You must register at least one phone number.");
        mandatoryMessage.add("lastname is required.");
        mandatoryMessage.add("firstname is required.");
        mandatoryMessage.add("passwd is required.");
        mandatoryMessage.add("address1 is required.");
        mandatoryMessage.add("city is required.");
        mandatoryMessage.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
        mandatoryMessage.add("This country requires you to choose a State.");
        Assert.assertEquals(cp.getMandatoryMessage(),mandatoryMessage);
    }

    @And("^Information message for password gide line should display is \"([^\"]*)\"$")
    public void informationMessageForPasswordGideLineShouldDisplayIs(String message)  {
       Assert.assertTrue(cp.getInformationMessagePassword().contains(message));

    }

    @When("^enter invalid password as \"([^\"]*)\"$")
    public void enterInvalidPasswordAs(String invalidPassword) {
        cp.setInvalidPassword(invalidPassword);

    }

    @Then("^Error message for invalid password  should be \"([^\"]*)\"$")
    public void errorMessageForInvalidPasswordShouldBe(String message)  {
     Assert.assertTrue(cp.getErrorMessageInvalidPassword().contains(message));

    }



    @When("^User give invalid date \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userGiveInvalidDate(String days, String month, String year)  {
        cp.SetDOB(days,month,year);

    }

    @Then("^Error message for invalid date \"([^\"]*)\"$")
    public void errorMessageForInvalidDate(String message)  {
        Assert.assertTrue(cp.getErrorMessageInvalidDate().contains(message));

    }

    @When("^User give DOB as currant date$")
    public void userGiveDOBAsCurrantDate() {
        dh=new DateHelper();
        String getTodayDate= dh.getTodayDate();
        String[] date =getTodayDate.split("/");
        cp.SetDOB(date[0],date[1],date[2].trim());
    }

    @Then("^Error message for  a current date \"([^\"]*)\"$")
    public void errorMessageForACurrentDate(String arg0)  {

    }

    @When("^User enter firstName as \"([^\"]*)\"$")
    public void userEnterFirstNameAs(String firstName)  {
        cp.setName(firstName);

    }

    @And("^User select gender$")
    public void userSelectGender() {
        cp.setGender("Male");
    }

    @And("^User enter lastName as \"([^\"]*)\"$")
    public void userEnterLastNameAs(String LastName)  {
        cp.setLastName(LastName);
    }

    @When("^User verify emailId as \"([^\"]*)\"$")
    public void userVerifyEmailIdAs(String message) throws InterruptedException {
        Assert.assertEquals(message,cp.emailId());

    }
    @And("^User enter password as \"([^\"]*)\"$")
    public void userEnterPasswordAs(String password)  {
        cp.setPassword(password);

    }



    @And("^User select DOB \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userSelectDOB(String day, String month, String year) {
        cp.SetDOB(day,month,year);
    }

    @And("^User enter address as \"([^\"]*)\"$")
    public void userEnterAddressAs(String address)  {
        cp.setAddress(address);
    }

    @And("^user enter city as \"([^\"]*)\"$")
    public void userEnterCityAs(String cityName)  {
        cp.setCity(cityName);

    }

    @And("^User select state as \"([^\"]*)\"$")
    public void userSelectStateAs(String stateName)  {
      cp.setState(stateName);
    }

    @And("^User enter zip/postal code as \"([^\"]*)\"$")
    public void userEnterZipPostalCodeAs(String zipCode)  {
        cp.setZipCode(zipCode);

    }

    @And("^User enter country as \"([^\"]*)\"$")
    public void userEnterCountryAs(String country)  {
        cp.setCountry(country);

    }

    @And("^User enter mobilePhone as \"([^\"]*)\"$")
    public void userEnterMobilePhoneAs(String mobilNumber) {
        cp.setMobileNumber(mobilNumber);

    }


//    @And("^Verify user account page title as \"([^\"]*)\"$")
//    public void verifyUserAccountPageTitleAs(String title)  {
//        Assert.assertEquals(title,BaseClass.driver.getTitle());
//
//    }
}

