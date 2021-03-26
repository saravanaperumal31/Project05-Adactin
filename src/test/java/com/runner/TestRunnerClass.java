package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", monochrome = true, glue = { "com.stepdefinition" }, plugin = {
		"json:src\\test\\resources\\Reports\\Adaction.json" })
public class TestRunnerClass {
	@AfterClass
	public static void afterclass() {
		JVMReport.reportGeneration(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\Adaction.json");
	}
}
