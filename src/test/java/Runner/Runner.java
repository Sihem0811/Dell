package Runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

    @RunWith(Cucumber.class)
    
    @CucumberOptions(
    		
		features="src/test/resources/Features/DellAuto.feature",
				
				
					glue="StepDef",
		
				  plugin = {"pretty", "html:target/Cucumber-report.html"}
		)

public class Runner {



}
