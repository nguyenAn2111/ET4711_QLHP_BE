package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.fw.mapper.EntityMapper;
import org.hibernate.jpamodelgen.xml.jaxb.Entity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface CourseVIewMapper {
//    CourseViewDto toDto(Course course);
    CourseViewDto toDto(Course course, @Context Map<Integer, Long> regisCountMap);

    List<CourseViewDto> toDto(List<Course> courses, @Context Map<Integer, Long> regisCountMap);

    @AfterMapping
    default void setRegisNum(Course course,
                             @MappingTarget CourseViewDto dto,
                             @Context Map<Integer, Long> regisCountMap) {

        Long count = regisCountMap.get(course.getId());
        dto.setRegis_num(count == null ? 0 : count.intValue());
    }
}
