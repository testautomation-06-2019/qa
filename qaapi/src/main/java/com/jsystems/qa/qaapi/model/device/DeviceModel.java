package com.jsystems.qa.qaapi.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceModel {
    @JsonProperty( required = true)
    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    public int screenSize;
}
