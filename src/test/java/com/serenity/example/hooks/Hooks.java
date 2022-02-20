package com.serenity.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class Hooks {

	@Managed(uniqueSession = true, driver = "chrome")
	public WebDriver driver;

	public Hooks() {
		System.out.println("--------------------INITIALIZE HOOKS----------------------");
	}

	@Before
	public void BeforeScenario(Scenario scenario) {
		System.out.println("--------------------BEFORE SCENARIO----------------------");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("--------------------Setting timeouts to 10 sec--------------------");
	}

	@After
	public void AfterScenario(Scenario scenario) {
		System.out.println("--------------------AFTER SCENARIO----------------------");
		driver.quit();
		System.out.println("--------------------Completed execution: " + scenario.getName()+ "----------------------");
	}

}
