package QLHP.app.domain.mapper;

import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-04T14:19:38+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.10 (Ubuntu)"
)
@Component
public class CourseVIewMapperImpl implements CourseVIewMapper {

    @Override
    public CourseViewDto toDto(Course course, Map<Integer, Long> regisCountMap) {
        if ( course == null ) {
            return null;
        }

        CourseViewDto courseViewDto = new CourseViewDto();

        courseViewDto.setId( course.getId() );
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
        courseViewDto.setTerm( course.getTerm() );

        setRegisNum( course, courseViewDto, regisCountMap );

        return courseViewDto;
    }

    @Override
    public List<CourseViewDto> toDto(List<Course> courses, Map<Integer, Long> regisCountMap) {
        if ( courses == null ) {
            return null;
        }

        List<CourseViewDto> list = new ArrayList<CourseViewDto>( courses.size() );
        for ( Course course : courses ) {
            list.add( toDto( course, regisCountMap ) );
        }

        return list;
    }
}
