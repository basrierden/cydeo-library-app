package com.cydeo.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"
        },

        features="src/test/resources/features",
        glue="com/cydeo/library/step_definitions",
        dryRun =false,
        tags = "@wip",
        publish = false

)

public class CukesRunner {
}