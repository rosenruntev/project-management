package uni.fmi.projectmanagement;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", plugin = { "pretty", "html:target/cucmberRaport" }, monochrome = true)
public class CucumberStarter {
}
