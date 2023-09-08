package com.example.studentcleanarch.application.port.in.student;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteStudentCommand {
    private Long id;
}
