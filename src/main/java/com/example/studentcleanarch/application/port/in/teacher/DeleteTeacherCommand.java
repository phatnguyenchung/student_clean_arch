package com.example.studentcleanarch.application.port.in.teacher;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteTeacherCommand {
    private Long id;
}
