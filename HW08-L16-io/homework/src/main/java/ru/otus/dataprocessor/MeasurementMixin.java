package ru.otus.dataprocessor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MeasurementMixin {
    @JsonProperty("name")
    String name;

    @JsonProperty("value")
    Double value;

    @JsonCreator
    public MeasurementMixin(@JsonProperty("name") String name, @JsonProperty("value") double value) {
        this.name = name;
        this.value = value;
    }
}
