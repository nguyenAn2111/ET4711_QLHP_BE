package QLHP.app.repository.PDT.specification;

import QLHP.app.domain.entity.RegItem;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.entity.Student;
import QLHP.app.domain.payload.request.RegisFilterRequest;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class RegisSpecification {

    public static Specification<RegItem> filter(RegisFilterRequest req) {

        return (root, query, cb) -> {

            var predicates = cb.conjunction();

            // JOIN
            Join<Object, Object> course = root.join("course", JoinType.LEFT);
            Join<Object, Object> student = root.join("student", JoinType.LEFT);

            // 🔍 keyword
            if (req.getKeyword() != null && !req.getKeyword().isEmpty()) {

                String like = "%" + req.getKeyword().toLowerCase() + "%";

                predicates = cb.and(predicates,
                        cb.or(
                                cb.like(cb.lower(course.get("name")), like),
                                cb.like(cb.lower(course.get("code")), like),
                                cb.like(cb.lower(student.get("name")), like),
                                cb.like(cb.lower(student.get("code")), like)
                        )
                );
            }

            // 🎯 status
            if (req.getStatus() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("status"), req.getStatus()));
            }

            // 🎯 term
            if (req.getTerm() != null && !req.getTerm().isEmpty()) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("term"), req.getTerm()));
            }

            // 🎯 unit (student.unit)
            if (req.getUnit() != null && !req.getUnit().isEmpty()) {
                predicates = cb.and(predicates,
                        cb.equal(student.get("unit"), req.getUnit()));
            }

            return predicates;
        };
    }
}