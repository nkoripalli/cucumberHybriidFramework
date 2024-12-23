package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepdefinitions", "hooks"},
		//tags="@smoke",
		publish = true,
		plugin={"pretty","html:target/CucumberReropt.html"}
				)
public class TestRunner {
	
}