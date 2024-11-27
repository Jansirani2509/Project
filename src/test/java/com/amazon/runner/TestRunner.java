package com.amazon.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.amazon.stepdefinition",features ="src\\test\\resources\\Features",dryRun=false,plugin={"json:target\\output.xml"})

public class TestRunner {
	

}
