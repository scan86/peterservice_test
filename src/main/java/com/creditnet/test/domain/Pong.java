package com.creditnet.test.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Created by scan on 12.08.16.
 */
public class Pong {

    @JsonProperty
    private String message;

    @JsonProperty
    private String version;

    @JsonProperty("timestamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    public Pong(String message, LocalDateTime localDateTime, String version) {
        this.message = message;
        this.localDateTime = localDateTime;
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getVersion() {
        return version;
    }

}
