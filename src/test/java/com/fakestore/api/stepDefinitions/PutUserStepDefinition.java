package com.fakestore.api.stepDefinitions;

import com.fakestore.api.tasks.PostUserTask;
import com.fakestore.api.tasks.PutUserTask;
import com.fakestore.api.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

public class PutUserStepDefinition {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;

    Actor user = Actor.named("user");
    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint and I send the user information for updating a exists user")
    public void iConsumeTheEndpointAndISendTheUserInformationForUpdatingAExistsUser() {
        user.attemptsTo(
                PutUserTask.on()
        );
    }
}
