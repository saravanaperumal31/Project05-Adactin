package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utility.HelperClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends HelperClass {
	@Before
	public void beforeScenario() {

	}

	@After
	public void afterScenario(Scenario scenario) {
		TakesScreenshot s = (TakesScreenshot) driver;
		byte[] b = s.getScreenshotAs(OutputType.BYTES);
		scenario.embed(b, "Pass Image");
		quitwindow();
	}
}
