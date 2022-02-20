package com.serenity.example.pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class ChallengePage extends BasePage {

    static final String header = "COVID-19 THE GAME";

    @FindBy(xpath="//button[text()='Try the next battle']")
    WebElementFacade tryNext;

    @FindBy(xpath="//button[text()='Start']")
    WebElementFacade startButton;

    @FindBy(xpath="//h5[contains(text(),'You have taken the public bus')]")
    private WebElementFacade busModalHeader;

    @FindBy(xpath="//h5[contains(text(),'You are seated at a restaurant')]")
    private WebElementFacade publicPlaceModalHeader;

    @FindBy(xpath="//h5[contains(text(),'You have entered the office')]")
    private WebElementFacade officeModalHeader;

    @FindBy(id="bus_answer_1")
    private WebElementFacade correctBusAnswer;

    @FindBy(id="restaurant_answer_1")
    private WebElementFacade corrrectPublicPlaceAnswer;


    @FindBy(id="office_answer_1")
    private WebElementFacade correctOfficeAnswer;

    @FindBy(xpath="//h5[contains(text(),'That is correct!')]")
    private WebElementFacade correctAnswerChosen;

    @FindBy(xpath="//button[text()='Check your final score']")
    WebElementFacade finalScore;

    @FindBy(xpath="//div//*[contains(text(),'you have scored 100 points!')]")
    private WebElementFacade score;

    public ChallengePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageHeader() {
        Assert.assertTrue("Game Page header matches : " + getPageHeader(),
                getPageHeader().equals(header));

    }

    private String getPageHeader() {
        WebElementFacade headerElement = find(By.xpath("//div//*[text()='COVID-19 THE GAME']"));
        return headerElement.getText();
    }

    public void clickChallenge(String partialLinkText) {
        WebElementFacade challenge = find(By.partialLinkText(partialLinkText));
        challenge.click();
    }

    public void busChallengeSelected() {
        busModalHeader.isDisplayed();
    }


    public void officeChallengeSelected() {
        officeModalHeader.isDisplayed();
    }

    public void startChallenge(){
        startButton.click();
    }

    public void chooseCorrectBusAnswer(){
        correctBusAnswer.click();
    }

    public void chooseCorrectPublicPlaceAnswer(){
        corrrectPublicPlaceAnswer.click();
    }

    public void verifyCorrectAnswerChosen() {
        correctAnswerChosen.isDisplayed();
        score.isDisplayed();
    }

    public void publicPlaceChallengeSelected() {
        publicPlaceModalHeader.isDisplayed();
    }

    public void chooseCorrectOfficeAnswer() {
        correctOfficeAnswer.click();
    }

    public void tryNextChallenge() {
        tryNext.click();
    }

    public void clickFinalScore() {
        finalScore.click();
    }

    public String getScore(String userName) {
        WebElementFacade record = find(By.xpath("//table/tbody/tr/td[text()='"+userName+"']" +
                "/following-sibling::td"));
        record.isDisplayed();
        return record.getText();
    }
}