package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.UserRegistrationSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;

public class UserRegistrationAndLoginStepDefs {
    @Steps
    UserRegistrationSteps userRegistrationSteps;

    @Given("setup {string} {string} with register API")
    public void setup_with_register_api(String userName, String password) {
        userName = userName + RandomStringUtils.randomNumeric(7);
        userRegistrationSteps.registerNewUser(userName, password);
    }

    @When("user is registered successfully")
    public void is_registered_successfully() {
        userRegistrationSteps.registrationSuccessful();
    }

    @When("new user can login via login API successfully")
    public void login_with_via_login_api() {
        userRegistrationSteps.userlogin();
    }

    @Given("setup {string} {string} with register API with invalid token")
    @Given("use an existing  {string} {string}")
    public void useAnExisting(String username, String password) {
        userRegistrationSteps.newUser.setUsername(username);
        userRegistrationSteps.newUser.setPassword(password);
    }

    @When("register the user")
    public void registerTheUser() {
        userRegistrationSteps.registerNewUser();
    }

    @Then("throws {int}")
    public void throwsStatuscode(int statusCode) {
        userRegistrationSteps.registrationFailed(statusCode);
    }

    @When("register the user with {string}")
    public void registerTheUserWithInvalidToken(String invalid_token) {
        userRegistrationSteps.registerNewUser(invalid_token);
    }
}
