package test_runner;
 
//import org.junit.runner.RunWith;

 
//import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"FeatureFile"},
//		tags="@Smoke",
//		tags="@Regression",
//		tags="@Regression and not @Smoke",
		glue="Steps",
		plugin= {"pretty","html:target/cucumber_report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		publish=true,
		dryRun=false,
		monochrome=true
		)
 
public class test_runner extends AbstractTestNGCucumberTests {
 
}
