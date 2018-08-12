package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\eclipse2\\eclipse1\\gmailcucumber\\src\\test\\resources\\gmailresources\\feature1.feature"},
                             plugin= {"pretty","html:target" },
                              monochrome=true)
public class Runner 
{
	
}
