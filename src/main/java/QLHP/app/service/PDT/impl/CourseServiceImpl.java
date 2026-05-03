package QLHP.app.service.PDT.impl;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.SysError;
import QLHP.app.domain.dto.CourseDetailDto;
import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.mapper.CourseDetailMapper;
import QLHP.app.domain.mapper.CourseVIewMapper;
import QLHP.app.domain.payload.request.CreateCourseRequest;
import QLHP.app.domain.payload.request.UpdateCourseRequest;
import QLHP.app.repository.PDT.CourseRepository;
import QLHP.app.service.PDT.CourseService;
import QLHP.fw.web.rest.errors.BadRequestException;
import QLHP.fw.web.rest.vm.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseVIewMapper courseVIewMapper;
    private final CourseDetailMapper courseDetailMapper;

    @Override
    public List<CourseViewDto> getAllCourses(){
        List<Course> courses = this.courseRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return this.courseVIewMapper.toDto(courses);
    }
    
    @Override
    public Integer createCourse(CreateCourseRequest request){

        Course course = new Course();
        course.setName(request.getName());
        course.setCode(request.getCode());
        course.setCredit(request.getCredit());
        course.setTerm(request.getTerm());
        course.setType(request.getType());
        course.setStatus(CourseStatus.OPEN);
        course.setStart_at(request.getStartDate());
        course.setEnd_at(request.getEndDate());

        course = this.courseRepository.save(course);
        return course.getId();
    }

    @Override
    public CourseDetailDto getCourseById(Integer id){
        Course course = this.courseRepository.findById(id).orElse(null);
        CourseDetailDto courseDetail = this.courseDetailMapper.toDto(course);
        return courseDetail;
    }

    @Override
    public CourseDetailDto updateCourse(Integer id, UpdateCourseRequest request){

        Course existingCourse = this.courseRepository.findById(id).orElseThrow(()
                -> new BadRequestException(SysError.COURSE_NOT_FOUND.name()));

        if (this.courseRepository.existsByCodeAndIdNot(request.getCode(), id)){
            log.error(SysError.COURSE_CODE_EXISTED.name());
            throw new BadRequestException(SysError.COURSE_CODE_EXISTED.name());
        }

        existingCourse.setName(request.getName());
        existingCourse.setCode(request.getCode());
        existingCourse.setCredit(request.getCredit());
        existingCourse.setTerm(request.getTerm());
        existingCourse.setType(request.getType());
        Course savedCourse = this.courseRepository.save(existingCourse);
        CourseDetailDto detailDto = this.courseDetailMapper.toDto(savedCourse);
        return detailDto;
    }

    @Override
    public boolean deleteCourse(Integer id){
        Course existingCourse = this.courseRepository.findById(id).orElseThrow(()
                -> new BadRequestException(SysError.COURSE_NOT_FOUND.name()));

        this.courseRepository.delete(existingCourse);
        return true;
    }


    
}
