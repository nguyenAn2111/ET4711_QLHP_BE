package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.RegisViewDto;
import QLHP.app.domain.entity.RegItem;
import QLHP.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegisViewMapper extends EntityMapper<RegisViewDto, RegItem> {
//    RegisViewDto toDto(RegItem registration);
//    @Mapping(target = "student_id", source = "studentId")
//    @Mapping(target = "course_id", source = "courseId")
    @Mapping(target = "student_name", source = "student.name")
    @Mapping(target = "student_code", source = "student.code")
    @Mapping(target = "course_name", source = "course.name")
    @Mapping(target = "course_code", source = "course.code")
    @Mapping(target = "student_unit", source = "student.unit")
    RegisViewDto toDto(RegItem entity);

    List<RegisViewDto> toDto(List<RegItem> entities);

}
