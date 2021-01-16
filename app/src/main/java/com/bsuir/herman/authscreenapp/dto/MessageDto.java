package com.bsuir.herman.authscreenapp.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageDto {
    @SerializedName("message")
    @Expose
    private String message;

    public MessageDto(String message) {
        this.message = message;
    }

}
