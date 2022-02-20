package com.serenity.example.pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//span[text()='Toggle search']//parent::button")
    WebElementFacade search;

    @FindBy(xpath = "//h2[contains(text(),'Tell me your warrior name')]")
    WebElementFacade userLabel;

    @FindBy(id="worrior_username")
    WebElementFacade txtUser;

    public void openHeroKuApp() {
        try {
            getDriver().navigate().to(testProperties.getProperty("heroURL"));
            getTitle().contains("COVID-19 THE GAME");
        } catch (Exception e) {
            Assert.fail("Unable to load the home page : " + e.getMessage());
        }
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userName){
        userLabel.isDisplayed();
        txtUser.isDisplayed();
        txtUser.sendKeys(userName);
    }

    public void tapUserButtonFor(String linkText) {
        WebElementFacade btnCreateUser;
        btnCreateUser = $(new By.ByLinkText(linkText));
        btnCreateUser.isDisplayed();
        btnCreateUser.click();
    }
}
