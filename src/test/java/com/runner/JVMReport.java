package com.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	public static void reportGeneration(String jsonFile) {
		Configuration c = new Configuration(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports"), "Adactin test");
		c.addClassifications("Browser", "Chrome");
		c.addClassifications("Browser Version", "Chrome");
		c.addClassifications("Sprint", "18");
		c.addClassifications("Os", "Windows");

		List<String> l = new ArrayList<String>();
		l.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(l, c);
		builder.generateReports();

	}

}
