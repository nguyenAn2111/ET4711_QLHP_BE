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
    date = "2026-05-03T11:40:01+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.10 (Ubuntu)"
)
@Component
public class RegisViewMapperImpl implements RegisViewMapper {

    @Override
    public RegItem toEntity(RegisViewDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RegItem regItem = new RegItem();

        regItem.setId( arg0.getId() );
        regItem.setCode( arg0.getCode() );
        regItem.setStatus( arg0.getStatus() );

        return regItem;
    }

    @Override
    public List<RegItem> toEntity(List<RegisViewDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<RegItem> list = new ArrayList<RegItem>( arg0.size() );
        for ( RegisViewDto regisViewDto : arg0 ) {
            list.add( toEntity( regisViewDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RegItem arg0, RegisViewDto arg1) {
        if ( arg1 == null ) {
            return;
        }

        if ( arg1.getId() != null ) {
            arg0.setId( arg1.getId() );
        }
        if ( arg1.getCode() != null ) {
            arg0.setCode( arg1.getCode() );
        }
        if ( arg1.getStatus() != null ) {
            arg0.setStatus( arg1.getStatus() );
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
        regisViewDto.setId( entity.getId() );
        regisViewDto.setCode( entity.getCode() );
        regisViewDto.setStatus( entity.getStatus() );

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
}
