package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;


//@RunWith(Cucumber.class)

@CucumberOptions(features = {"src\\test\\java\\Features\\Login.feature"},
       // tags={"@Regression"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        monochrome = true,
        glue = "Steps")

@Test
public class TestRunner_England extends AbstractTestNGCucumberTests{

}
