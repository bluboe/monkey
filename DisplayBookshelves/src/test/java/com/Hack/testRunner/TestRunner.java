package com.Hack.testRunner;

//import org.junit.runner.RunWith;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"FeatureFiles"},
//		tags="@Smoke",
//		tags="@Regression",
//		tags="@Regression and not @Smoke",
		glue="com.Hack.stepDefinitions",
		plugin= {"pretty","html:target/cucumber_report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		publish=true,
		dryRun=false,
		monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}