package runner;

import javax.swing.text.html.HTML;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src//test//resources//Login//Login.feature"},
glue = {"StepDefinition"},dryRun = false, plugin = {"html:output//kavi.html", "json:output//kavi.xml"})
public class TestRunner {

}
