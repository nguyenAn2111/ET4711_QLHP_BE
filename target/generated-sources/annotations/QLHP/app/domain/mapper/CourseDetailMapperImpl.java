package QLHP.app.domain.mapper;

import QLHP.app.common.enums.CourseType;
import QLHP.app.domain.dto.CourseDetailDto;
import QLHP.app.domain.entity.Course;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-03T19:51:45+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.18 (Ubuntu)"
)
@Component
public class CourseDetailMapperImpl implements CourseDetailMapper {

    @Override
    public Course toEntity(CourseDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( dto.getName() );
        course.setCode( dto.getCode() );
        course.setCredit( dto.getCredit() );
        if ( dto.getType() != null ) {
            course.setType( Enum.valueOf( CourseType.class, dto.getType() ) );
        }
        course.setTerm( dto.getTerm() );

        return course;
    }

    @Override
    public List<Course> toEntity(List<CourseDetailDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( dtoList.size() );
        for ( CourseDetailDto courseDetailDto : dtoList ) {
            list.add( toEntity( courseDetailDto ) );
        }

        return list;
    }

    @Override
    public List<CourseDetailDto> toDto(List<Course> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CourseDetailDto> list = new ArrayList<CourseDetailDto>( entityList.size() );
        for ( Course course : entityList ) {
            list.add( toDto( course ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Course entity, CourseDetailDto dto) {
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
        if ( dto.getType() != null ) {
            entity.setType( Enum.valueOf( CourseType.class, dto.getType() ) );
        }
        if ( dto.getTerm() != null ) {
            entity.setTerm( dto.getTerm() );
        }
    }

    @Override
    public CourseDetailDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDetailDto courseDetailDto = new CourseDetailDto();

        courseDetailDto.setName( course.getName() );
        courseDetailDto.setCode( course.getCode() );
        courseDetailDto.setCredit( course.getCredit() );
        if ( course.getType() != null ) {
            courseDetailDto.setType( course.getType().name() );
        }
        courseDetailDto.setTerm( course.getTerm() );

        return courseDetailDto;
    }
}
