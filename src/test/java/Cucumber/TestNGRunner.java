package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber->TestNG,JUNIT
@CucumberOptions(features="src/test/java/Cucumber",glue = "SupriyaReddy.StepDefinition",
monochrome = true,tags="@Regression", plugin = {"html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
