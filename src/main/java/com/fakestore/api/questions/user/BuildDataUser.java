package com.fakestore.api.questions.user;

import com.fakestore.api.models.user.Name;
import com.fakestore.api.models.user.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.fakestore.api.utils.Data;

import java.util.Map;

public class BuildDataUser implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {
        Map<String, String> data = Data.extractTo().get(0);
        Name name = Name.builder()
                .firstname(data.get("Firstname"))
                .lastname(data.get("Lastname"))
                .build();

        return UserModel.builder()
                .email(data.get("Email"))
                .username(data.get("Username"))
                .password(data.get("Password"))
                .name(name)
                .build();
    }

    public static BuildDataUser was(){
        return new BuildDataUser();
    }


}
