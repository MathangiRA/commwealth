package com.serenity.example.serenity;

import com.serenity.example.pageObjects.ChallengePage;
import com.serenity.example.pageObjects.HomePage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ChallengeSteps {

	ChallengePage challengePage;
	String userName = "";

	@Step
	public void tapBusButton() {
		challengePage.verifyPageHeader();
		challengePage.clickChallenge("bus");
	}

	@Step
	public void verifyBusModal(){
		challengePage.busChallengeSelected();
		challengePage.startChallenge();
	}

	@Step
	public void selectBusCorrectAnswer() {
		challengePage.chooseCorrectBusAnswer();
		challengePage.verifyCorrectAnswerChosen();
	}

	@Step
	public void selectPublicPlaceCorrectAnswer() {
		challengePage.chooseCorrectPublicPlaceAnswer();
		challengePage.verifyCorrectAnswerChosen();
	}

	@Step
	public void tapPublicPlaceButton() {
		challengePage.clickChallenge("public place");
	}

	@Step
	public void verifyPublicPlaceModal(){
		challengePage.publicPlaceChallengeSelected();
		challengePage.startChallenge();
	}

	public void tapWFHButton() {
		challengePage.clickChallenge("office");
	}

	public void verifyWFHModal() {
		challengePage.officeChallengeSelected();
		challengePage.startChallenge();
	}

	public void selectWFHCorrectAnswer() {
		challengePage.chooseCorrectOfficeAnswer();
		challengePage.verifyCorrectAnswerChosen();
	}

	public void goToNextChallenge() {
		challengePage.tryNextChallenge();
	}

	public void tapfinalScore() {
		challengePage.clickFinalScore();
	}

	public void verifyScore(String userName, String score) {
		String expscore = challengePage.getScore(userName);
		Assert.assertTrue("Score is set to "+ score, score.equals(expscore));
	}
}
