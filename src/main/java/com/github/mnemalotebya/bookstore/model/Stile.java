package com.github.mnemalotebya.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Stile {

    @JsonProperty(value = "prose")
    Prose,

    @JsonProperty(value = "journalist")
    Journalist,

    @JsonProperty(value = "poet")
    Poet,

    @JsonProperty(value = "scientific")
    Scientific
}
