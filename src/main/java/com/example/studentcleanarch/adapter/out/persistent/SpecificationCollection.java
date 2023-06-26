package com.example.studentcleanarch.adapter.out.persistent;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;
import com.example.studentcleanarch.common.utils.DateTimeUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SpecificationCollection {
    public static Specification<StudentJpaEntity> getValidConfig(String studentId) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("studentId"), studentId));
            predicates.add(criteriaBuilder.equal(root.get("enable"), true));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), DateTimeUtils.current()));
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), DateTimeUtils.current()));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
