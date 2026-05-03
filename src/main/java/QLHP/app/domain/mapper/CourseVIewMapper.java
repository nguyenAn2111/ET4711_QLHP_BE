package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.fw.mapper.EntityMapper;
import org.hibernate.jpamodelgen.xml.jaxb.Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseVIewMapper extends EntityMapper<CourseViewDto, Course> {
    CourseViewDto toDto(Course course);
}
