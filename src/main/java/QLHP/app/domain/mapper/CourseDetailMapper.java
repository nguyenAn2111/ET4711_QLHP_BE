package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.CourseDetailDto;
import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDetailMapper extends EntityMapper<CourseDetailDto, Course> {
    CourseDetailDto toDto(Course course);
}
