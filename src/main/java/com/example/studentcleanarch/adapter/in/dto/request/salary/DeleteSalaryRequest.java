package com.example.studentcleanarch.adapter.in.dto.request.salary;

import com.example.studentcleanarch.application.port.in.salary.DeleteSalaryCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteSalaryRequest {

    private Long id;

    public DeleteSalaryCommand toCommand() {
        return DeleteSalaryCommand.builder()
                .id(id)
                .build();
    }
}
