package QLHP.app.domain.mapper;

import QLHP.app.common.enums.RegisStatus;
import QLHP.app.domain.dto.RegisCreatedDto;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.entity.RegItem;
import QLHP.app.domain.entity.Student;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-03T19:51:44+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.18 (Ubuntu)"
)
@Component
public class RegisCreatedMapperImpl implements RegisCreatedMapper {

    @Override
    public RegItem toEntity(RegisCreatedDto dto) {
        if ( dto == null ) {
            return null;
        }

        RegItem regItem = new RegItem();

        regItem.setCode( dto.getCode() );
        if ( dto.getStatus() != null ) {
            regItem.setStatus( Enum.valueOf( RegisStatus.class, dto.getStatus() ) );
        }
        if ( dto.getCreated_at() != null ) {
            regItem.setCreated_at( LocalDateTime.parse( dto.getCreated_at() ) );
        }
        regItem.setTerm( dto.getTerm() );

        return regItem;
    }

    @Override
    public List<RegItem> toEntity(List<RegisCreatedDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RegItem> list = new ArrayList<RegItem>( dtoList.size() );
        for ( RegisCreatedDto regisCreatedDto : dtoList ) {
            list.add( toEntity( regisCreatedDto ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(RegItem entity, RegisCreatedDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( Enum.valueOf( RegisStatus.class, dto.getStatus() ) );
        }
        if ( dto.getCreated_at() != null ) {
            entity.setCreated_at( LocalDateTime.parse( dto.getCreated_at() ) );
        }
        if ( dto.getTerm() != null ) {
            entity.setTerm( dto.getTerm() );
        }
    }

    @Override
    public RegisCreatedDto toDto(RegItem entity) {
        if ( entity == null ) {
            return null;
        }

        RegisCreatedDto regisCreatedDto = new RegisCreatedDto();

        regisCreatedDto.setStudent_name( entityStudentName( entity ) );
        regisCreatedDto.setStudent_code( entityStudentCode( entity ) );
        regisCreatedDto.setCourse_name( entityCourseName( entity ) );
        regisCreatedDto.setCourse_code( entityCourseCode( entity ) );
        Integer credit = entityCourseCredit( entity );
        if ( credit != null ) {
            regisCreatedDto.setCourse_credit( String.valueOf( credit ) );
        }
        regisCreatedDto.setTerm( entity.getTerm() );
        regisCreatedDto.setCode( entity.getCode() );
        if ( entity.getCreated_at() != null ) {
            regisCreatedDto.setCreated_at( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entity.getCreated_at() ) );
        }
        if ( entity.getStatus() != null ) {
            regisCreatedDto.setStatus( entity.getStatus().name() );
        }

        return regisCreatedDto;
    }

    @Override
    public List<RegisCreatedDto> toDto(List<RegItem> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RegisCreatedDto> list = new ArrayList<RegisCreatedDto>( entities.size() );
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

    private Integer entityCourseCredit(RegItem regItem) {
        if ( regItem == null ) {
            return null;
        }
        Course course = regItem.getCourse();
        if ( course == null ) {
            return null;
        }
        Integer credit = course.getCredit();
        if ( credit == null ) {
            return null;
        }
        return credit;
    }
}
