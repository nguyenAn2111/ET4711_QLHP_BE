package QLHP.app.domain.mapper;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.CourseType;
import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-01T23:45:12+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.18 (Ubuntu)"
)
@Component
public class CourseVIewMapperImpl implements CourseVIewMapper {

    @Override
    public Course toEntity(CourseViewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( dto.getName() );
        course.setCode( dto.getCode() );
        course.setCredit( dto.getCredit() );
        course.setStart_at( dto.getStart_at() );
        course.setEnd_at( dto.getEnd_at() );
        if ( dto.getType() != null ) {
            course.setType( Enum.valueOf( CourseType.class, dto.getType() ) );
        }
        if ( dto.getStatus() != null ) {
            course.setStatus( Enum.valueOf( CourseStatus.class, dto.getStatus() ) );
        }
        course.setRegis_num( dto.getRegis_num() );
        course.setTerm( dto.getTerm() );

        return course;
    }

    @Override
    public List<Course> toEntity(List<CourseViewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( dtoList.size() );
        for ( CourseViewDto courseViewDto : dtoList ) {
            list.add( toEntity( courseViewDto ) );
        }

        return list;
    }

    @Override
    public List<CourseViewDto> toDto(List<Course> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CourseViewDto> list = new ArrayList<CourseViewDto>( entityList.size() );
        for ( Course course : entityList ) {
            list.add( toDto( course ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Course entity, CourseViewDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getCode() != null ) {
            entity.setCode( dto.getCode() );
        }
        if ( dto.getCredit() != null ) {
            entity.setCredit( dto.getCredit() );
        }
        if ( dto.getStart_at() != null ) {
            entity.setStart_at( dto.getStart_at() );
        }
        if ( dto.getEnd_at() != null ) {
            entity.setEnd_at( dto.getEnd_at() );
        }
        if ( dto.getType() != null ) {
            entity.setType( Enum.valueOf( CourseType.class, dto.getType() ) );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( Enum.valueOf( CourseStatus.class, dto.getStatus() ) );
        }
        if ( dto.getRegis_num() != null ) {
            entity.setRegis_num( dto.getRegis_num() );
        }
        if ( dto.getTerm() != null ) {
            entity.setTerm( dto.getTerm() );
        }
    }

    @Override
    public CourseViewDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseViewDto courseViewDto = new CourseViewDto();

        courseViewDto.setName( course.getName() );
        courseViewDto.setCode( course.getCode() );
        courseViewDto.setCredit( course.getCredit() );
        courseViewDto.setStart_at( course.getStart_at() );
        courseViewDto.setEnd_at( course.getEnd_at() );
        if ( course.getType() != null ) {
            courseViewDto.setType( course.getType().name() );
        }
        if ( course.getStatus() != null ) {
            courseViewDto.setStatus( course.getStatus().name() );
        }
        courseViewDto.setRegis_num( course.getRegis_num() );
        courseViewDto.setTerm( course.getTerm() );

        return courseViewDto;
    }
}
