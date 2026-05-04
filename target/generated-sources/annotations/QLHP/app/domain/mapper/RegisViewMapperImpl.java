package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.RegisViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.entity.RegItem;
import QLHP.app.domain.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-04T20:57:16+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.18 (Ubuntu)"
)
@Component
public class RegisViewMapperImpl implements RegisViewMapper {

    @Override
    public RegItem toEntity(RegisViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        RegItem regItem = new RegItem();

        regItem.setId( dto.getId() );
        regItem.setCode( dto.getCode() );
        regItem.setStatus( dto.getStatus() );
        regItem.setTerm( dto.getTerm() );

        return regItem;
    }

    @Override
    public List<RegItem> toEntity(List<RegisViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RegItem> list = new ArrayList<RegItem>( dtoList.size() );
        for ( RegisViewDto regisViewDto : dtoList ) {
            list.add( toEntity( regisViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RegItem entity, RegisViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getTerm() != null ) {
            entity.setTerm( dto.getTerm() );
        }
    }

    @Override
    public RegisViewDto toDto(RegItem entity) {
        if ( entity == null ) {
            return null;
        }

        RegisViewDto regisViewDto = new RegisViewDto();

        regisViewDto.setStudent_name( entityStudentName( entity ) );
        regisViewDto.setStudent_code( entityStudentCode( entity ) );
        regisViewDto.setCourse_name( entityCourseName( entity ) );
        regisViewDto.setCourse_code( entityCourseCode( entity ) );
        regisViewDto.setStudent_unit( entityStudentUnit( entity ) );
        regisViewDto.setId( entity.getId() );
        regisViewDto.setCode( entity.getCode() );
        regisViewDto.setStatus( entity.getStatus() );
        regisViewDto.setTerm( entity.getTerm() );

        return regisViewDto;
    }

    @Override
    public List<RegisViewDto> toDto(List<RegItem> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RegisViewDto> list = new ArrayList<RegisViewDto>( entities.size() );
        for ( RegItem regItem : entities ) {
            list.add( toDto( regItem ) );
        }

        return list;
    }

    private String entityStudentName(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Student student = regItem.getStudent();
        if ( student == null ) {
            return null;
        }
        String name = student.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String entityStudentCode(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Student student = regItem.getStudent();
        if ( student == null ) {
            return null;
        }
        String code = student.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String entityCourseName(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Course course = regItem.getCourse();
        if ( course == null ) {
            return null;
        }
        String name = course.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String entityCourseCode(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Course course = regItem.getCourse();
        if ( course == null ) {
            return null;
        }
        String code = course.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }

    private String entityStudentUnit(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Student student = regItem.getStudent();
        if ( student == null ) {
            return null;
        }
        String unit = student.getUnit();
        if ( unit == null ) {
            return null;
        }
        return unit;
    }
}
