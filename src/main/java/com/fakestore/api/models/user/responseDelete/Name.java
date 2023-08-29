package com.fakestore.api.models.user.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {
    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;
}
