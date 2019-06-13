package com.jsystems.qa.qaapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;
    @JsonProperty(value = "device.model", required = true)
    List<DeviceModel> deviceModel;
}
