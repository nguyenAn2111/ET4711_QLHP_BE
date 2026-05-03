package QLHP.app.service.PDT;

import QLHP.app.common.enums.CourseType;
import QLHP.app.domain.dto.CourseDetailDto;
import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.payload.request.CreateCourseRequest;
import QLHP.app.domain.payload.request.UpdateCourseRequest;
import QLHP.fw.web.rest.vm.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<CourseViewDto> getAllCourses();
    
    Integer createCourse(CreateCourseRequest request);

    CourseDetailDto getCourseById(Integer id);

    CourseDetailDto updateCourse(Integer id, UpdateCourseRequest request);

    boolean deleteCourse(Integer id);
}
