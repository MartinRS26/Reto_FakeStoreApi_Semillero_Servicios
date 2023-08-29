package com.fakestore.api.stepDefinitions;

import com.fakestore.api.questions.user.DeleteResponse;
import com.fakestore.api.tasks.DeleteUserTask;
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

public class DeleteUserStepDefinition {
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

    @When("I consume the endpoint and I send the parameter id for deleting a exists user")
    public void iConsumeTheEndpointAndISendTheParameterIdForDeletingAExistsUser() {
        user.attemptsTo(
                DeleteUserTask.on()
        );
    }
    @Then("I can validate the phone")
    public void iCanValidateThePhone() {
        user.should(
                seeThat("The phone in the response was:",
                        res-> DeleteResponse.was().answeredBy(user).getPhone(),
                        equalTo(data.get("Phone"))

                )
        );
    }
}
