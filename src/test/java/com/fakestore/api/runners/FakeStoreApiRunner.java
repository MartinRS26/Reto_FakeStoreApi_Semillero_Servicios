package com.fakestore.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(   features = "src/test/resources/features/",
                    glue = "com.fakestore.api.stepDefinitions",
                    tags = "@PutUser",
                    snippets = CucumberOptions.SnippetType.CAMELCASE)
public class FakeStoreApiRunner {
}
