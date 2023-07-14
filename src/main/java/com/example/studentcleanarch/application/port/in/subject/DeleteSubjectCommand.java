package com.example.studentcleanarch.application.port.in.subject;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteSubjectCommand {
    private Long id;
}
