package biz.hengartner.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
// Plugin Options:
/*
Built-in formatter PLUGIN types: junit,
        html, pretty, progress, json, usage, rerun,
        testng. Built-in summary PLUGIN types:
        default_summary, null_summary. PLUGIN can
        also be a fully qualified class name, allowing
        registration of 3rd party plugins.
*/
public class RunCukesTest { // NOSONAR SonarLint does not know about @RunWith(Cucumber.class)
    // This class will be empty
}
