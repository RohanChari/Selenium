package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features="Feature",glue= {"StepDefination"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"})    //target/HtmlReports"
	
public class TestRun{
	
}