package com.example.crud.domain.enumerations;

public enum Affiliation {
    LEGION_OF_DOOM("Legion of Doom"),
    JUSTICE_LEAGUE("Justice League");

    Affiliation(String value) {
        this.value = value;
    }

    private String value;
}
