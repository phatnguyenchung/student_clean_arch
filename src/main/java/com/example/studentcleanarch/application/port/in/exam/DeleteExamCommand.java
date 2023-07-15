package com.example.studentcleanarch.application.port.in.exam;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteExamCommand {
    private Long id;
}
