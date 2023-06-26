package com.example.studentcleanarch.application.event;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class TimoAppEvent {
    private String refId;
}
