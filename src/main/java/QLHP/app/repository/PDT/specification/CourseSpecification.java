package QLHP.app.repository.PDT.specification;


import QLHP.app.domain.entity.Course;
import QLHP.app.domain.payload.request.CourseFilterRequest;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {

    public static Specification<Course> filter(CourseFilterRequest req) {
        return (root, query, cb) -> {

            var predicates = cb.conjunction();

            if (req.getKeyword() != null && !req.getKeyword().isEmpty()) {
                String like = "%" + req.getKeyword().toLowerCase() + "%";

                predicates = cb.and(predicates,
                        cb.or(
                                cb.like(cb.lower(root.get("name")), like),
                                cb.like(cb.lower(root.get("code")), like)
                        )
                );
            }

            if (req.getType() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("type"), req.getType()));
            }

            if (req.getStatus() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("status"), req.getStatus()));
            }

            if (req.getTerm() != null && !req.getTerm().isEmpty()) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("term"), req.getTerm()));
            }

            return predicates;
        };
    }
}