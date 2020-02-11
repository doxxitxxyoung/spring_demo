package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private final UUID id;
    @NotBlank   //  tells that name is not blank
    private final String name;

    //  We need to get json property into java class : @JsonProperty
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
