package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSD  {

	LoginPage lp=null;
	 @Before(order=2)
	    public void before_method  (){
	     lp=new LoginPage();
	 }

    @Given("^Open Application as \"([^\"]*)\"$")
    public void home_page(String Url) {
    	 BaseClass. driver.get(Url);
    }

    @Given("^User verify page title\"([^\"]*)\"$")
    public void user_verify_page_title(String title) {
        Assert.assertEquals(title, lp.PageTitle());
    }

    @Given("^User click sign in button$")
    public void user_click_sign_in_button() {
        lp.clickSignin();
    }

    @When("^User enters Email as \"([^\"]*)\"$")
    public void userEntersEmailAs(String email) throws InterruptedException {
        Thread.sleep(3000);
        lp.setEmailAddress(email);
    }

    @And("^Password as \"([^\"]*)\"$")
    public void passwordAs(String password) {
        lp.setEmailPassword(password);
    }


    @When("^Click on login button$")
    public void click_on_login_button() {
        lp.clickSignInButton();

    }

    @When("^Page Title should be \"([^\"]*)\"$")
    public void page_Title_should_be(String title) {
        if (BaseClass.driver.getPageSource().contains("Login was unsuccessful")) {
        	BaseClass. driver.close();
            Assert.fail();
        } else {
            Assert.assertEquals(title,BaseClass. driver.getTitle());
        }

    }

    @When("^User click log out link$")
    public void user_click_log_out_link() {

        lp.clickSignOutButton();

    }

    @When("^close browser$")
    public void close_browser() {
       BaseClass.driver.quit();

    }
    @And("^Error message for unregistered credential is \"([^\"]*)\"$")
    public void errorMessageForUnregisteredCredentialIs(String message) {
        //Assert.assertEquals(message, lp.getErrorMessageForUnRegisteredUser());
         Assert.assertTrue(lp.getErrorMessageForUnRegisteredUser().contains(message));
	 }

    @And("^Error message for invalid email id is \"([^\"]*)\"$")
    public void errorMessageForInvalidEmailIdIs(String message) {
        Assert.assertTrue(lp.getErrorMessageForInvalidEmailId().contains(message));
        //Assert.assertEquals(message, lp.getErrorMessageForInvalidEmailId());
        BaseClass. driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }

    @And("^Clear email field$")
    public void clearEmailField() {
    	BaseClass.  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.clearEmailField();
    }

    @And("^Error message for wrong password is \"([^\"]*)\"$")
    public void errorMessageForWrongPasswordIs(String wrongPasswordMessage) {
        Assert.assertTrue(lp.getErrorMessageForWrongPassword().contains(wrongPasswordMessage));
       // Assert.assertEquals(wrongPasswordMessage, lp.getErrorMessageForWrongPassword(),"error");
	 }

    @And("^User click forgot password button$")
    public void userClickForgotPasswordButton() {
     lp.clickForgetPassword();
	 }


    @And("^User enter invalid email as \"([^\"]*)\"$")
    public void userEnterInvalidEmailAs(String email)  {
	     lp.setTextEmailBox(email);

    }

    @And("^Click retrieve password$")
    public void clickRetrievePassword() {
	     lp.clickRetrievePasswordButton();
	 }

    @And("^User enter Valid email as \"([^\"]*)\"$")
    public void userEnterValidEmailAs(String email)  {
	     lp.setTextEmailBox(email);

    }

    @And("^Confirmation message for forgot password as\"([^\"]*)\"$")
    public void confirmationMessageForForgotPasswordAs(String message)  {
        Assert.assertTrue(lp.confirmationMessage().contains(message));
	 }

    @And("^Click back to login button$")
    public void clickBackToLoginButton() {
	     lp.clickBackToLoginButton();

    }


}
