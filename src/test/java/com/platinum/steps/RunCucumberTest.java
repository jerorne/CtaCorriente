package com.platinum.steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.platinum.steps",
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
}