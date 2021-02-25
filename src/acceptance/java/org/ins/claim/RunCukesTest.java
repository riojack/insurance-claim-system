package org.ins.claim;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:build/cucumber", "junit:build/cucumber.xml"},
        features = {"src/acceptance/resources/features"},
        glue = {"org.ins.claim"}
)
public class RunCukesTest {

}
