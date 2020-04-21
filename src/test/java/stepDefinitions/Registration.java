package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.CreateAnaccountPage;

public class Registration {

    CreateAnaccountPage cp =null;
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

    @And("^User click on Register button$")
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
}
