package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.LeaderboardSteps;
import com.serenity.example.serenity.UserRegistrationSteps;
import com.serenity.example.services.UserList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;

public class LeaderboardStepDefs {
    @Steps
    LeaderboardSteps leaderboardSteps;

    @Given("add {string} {int} with leaderboard API")
    public void add_with_leaderboard_api(String userName, int score) {
        leaderboardSteps.addUser(userName, score);
    }

    @When("retrieve all users")
    public void retrieve_all_users() {
        leaderboardSteps.getUserList();
    }

    @Then("verify user is added successfully")
    @Then("verify user is updated successfully")
    public void verifyScoreAreCreatedSuccessfully() {
        leaderboardSteps.verifyUserAdded();
    }

    @When("delete the user")
    public void delete() {
        leaderboardSteps.delete();
    }

    @Then("verify user is deleted successfully")
    public void verifyUserIsDeletedSuccessfully() {
        leaderboardSteps.getUserList();
        leaderboardSteps.verifyUserDeleted();
    }

    @When("update {int} for the user")
    public void updateForTheUser(int score) {
        leaderboardSteps.updateUser(score);
        leaderboardSteps.getUserList();
    }

}
