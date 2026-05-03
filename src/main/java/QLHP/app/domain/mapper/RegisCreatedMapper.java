package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.RegisCreatedDto;
import QLHP.app.domain.dto.RegisViewDto;
import QLHP.app.domain.entity.RegItem;
import QLHP.fw.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegisCreatedMapper extends EntityMapper<RegisCreatedDto, RegItem> {
//    RegisViewDto toDto(RegItem registration);
//    @Mapping(target = "student_id", source = "studentId")
//    @Mapping(target = "course_id", source = "courseId")
    @Mapping(target = "student_name", source = "student.name")
    @Mapping(target = "student_code", source = "student.code")
    @Mapping(target = "course_name", source = "course.name")
    @Mapping(target = "course_code", source = "course.code")
    @Mapping(target = "course_credit", source = "course.credit")
    RegisCreatedDto toDto(RegItem entity);

    List<RegisCreatedDto> toDto(List<RegItem> entities);

}
