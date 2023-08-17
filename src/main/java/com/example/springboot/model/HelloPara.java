package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class HelloPara implements Serializable {

    @JsonCreator
    public HelloPara(
            @NotNull
            @JsonProperty("lastName") final String lastName) {
        this.lastName = lastName;
    }

    @Pattern(regexp = "(^$)|(^[A-Za-z0-9 .,'-]{2,50}$)", message = "must be a valid surname")
    @NotEmpty(message = "not empty")

    private String lastName;
}
