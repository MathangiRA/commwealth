package com.serenity.example.serenity;

import com.serenity.example.pageObjects.HomePage;
import net.thucydides.core.annotations.Step;

public class HeroSteps {

	HomePage homePage;
	String userName = "";

	@Step
	public void openHomePage(){
		homePage.openHeroKuApp();
			}

	@Step
	public void createNewWarrior(String userName) {
		homePage.enterUserName(userName);
		this.userName = userName;
	}

	@Step
	public void tapCreateNewWarrior(){
		homePage.tapUserButtonFor("Create warrior");
	}

	@Step
	public void continueUserJourney() {
		homePage.tapUserButtonFor("Start your journey " + this.userName);
	}
}
