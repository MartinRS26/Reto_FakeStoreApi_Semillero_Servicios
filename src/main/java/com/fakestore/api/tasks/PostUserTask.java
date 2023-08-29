package com.fakestore.api.tasks;

import com.fakestore.api.models.user.UserModel;
import com.fakestore.api.questions.user.BuildDataUser;
import com.fakestore.api.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Data.extractTo().get(0);
        UserModel userInfo = actor.asksFor(BuildDataUser.was());
        actor.attemptsTo(
                Post.to(data.get("EndPoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );

    }

    public static PostUserTask on(){
        return instrumented(PostUserTask.class);
    }
}
