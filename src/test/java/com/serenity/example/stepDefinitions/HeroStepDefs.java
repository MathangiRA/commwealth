package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.ChallengeSteps;
import com.serenity.example.serenity.HeroSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HeroStepDefs {
    @Steps
    HeroSteps superHero_steps;

    @Steps
    ChallengeSteps challengeSteps;

    @Given("^user is on home page$")
    public void open_home_page() {
        superHero_steps.openHomePage();
    }

    @When("user enters his {string}")
    public void userEntersHis(String userName) {
        superHero_steps.createNewWarrior(userName);
    }

    @When("taps Create Warrior button")
    public void taps_button() {
        superHero_steps.tapCreateNewWarrior();
    }

    @Then("user is created successfully")
    public void user_is_created_successfully() {
        superHero_steps.continueUserJourney();
    }

    @And("completes challenges")
    public void completes() {
        challengeSteps.tapBusButton();
        challengeSteps.verifyBusModal();
        challengeSteps.selectBusCorrectAnswer();
        challengeSteps.goToNextChallenge();
        challengeSteps.verifyPublicPlaceModal();
        challengeSteps.selectPublicPlaceCorrectAnswer();
        challengeSteps.goToNextChallenge();
        challengeSteps.verifyWFHModal();
        challengeSteps.selectWFHCorrectAnswer();
        challengeSteps.tapfinalScore();
    }

    @And("verify score for {string} in leaderboard is {string}")
    public void verifyScoreForInLeaderboard(String userName, String score) {
        challengeSteps.verifyScore(userName, score);
    }
}
