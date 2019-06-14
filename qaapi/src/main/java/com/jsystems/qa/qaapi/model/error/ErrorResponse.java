package com.jsystems.qa.qaapi.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("Error")
    public ErrorBody error;

    public static class ErrorBody {
        @JsonProperty("error.code")
        public int errorCode;

        @JsonProperty("validation_erro")
        public String validationError;

        public String message;
    }

}
