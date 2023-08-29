package com.fakestore.api.stepDefinitions;

import com.fakestore.api.tasks.PostUserTask;
import com.fakestore.api.questions.user.ServerResponse;
import com.fakestore.api.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDefinition {
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    Map<String, String> data = Data.extractTo().get(0);

    Actor user = Actor.named("user");
    @Before
    public void setUpBaseUrl(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint and I send the user information email, username, password, firstname, lastname")
    public void iConsumeTheEndpointAndISendTheUserInformationEmailUsernamePasswordFirstnameNameLastnameName() {
        user.attemptsTo(
                PostUserTask.on()
        );

    }
    @Then("I can validate the response service")
    public void iCanValidateTheResponseService() {
        user.should(
                seeThat("the response code was:",
                        ServerResponse.was(),
                        equalTo(Integer.parseInt(data.get("Code")))

                )
        );
    }
}
