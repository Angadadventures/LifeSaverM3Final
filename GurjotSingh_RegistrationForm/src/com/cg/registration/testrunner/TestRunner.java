package com.cg.registration.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = "com.cg.registration.stepdefinition")
public class TestRunner {

}
