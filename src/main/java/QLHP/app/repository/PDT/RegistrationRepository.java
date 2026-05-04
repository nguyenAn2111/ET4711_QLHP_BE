package QLHP.app.repository.PDT;

import QLHP.app.domain.dto.CourseRegisCountDto;
import QLHP.app.domain.entity.RegItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegistrationRepository extends JpaRepository<RegItem, Integer>, JpaSpecificationExecutor<RegItem> {
//    @EntityGraph(value = "RegItem.student", type = EntityGraph.EntityGraphType.FETCH)

    @EntityGraph(attributePaths = {"student", "course"})
    List<RegItem> findAll(Sort sort);

    @Query("SELECT r.course.id, COUNT(r) FROM RegItem r GROUP BY r.course.id")
//    List<CourseRegisCountDto> countRegisByCourse();
    List<Object[]> countRegisByCourse();
}
