package QLHP.app.controller.PDT;

import QLHP.app.domain.payload.request.CreateCourseRequest;
import QLHP.app.domain.payload.request.UpdateCourseRequest;
import QLHP.app.service.PDT.CourseService;
import QLHP.fw.web.rest.vm.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/pdt/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/list-all")
    public BaseResponse<?> ListCourses () {
        log.info("Request GET /list-all");
        var response = this.courseService.getAllCourses();
        log.info("Response from list-all is {}", response);
        return BaseResponse.ok(response);
    }

    @PostMapping("")
    public BaseResponse<?> createCourse(@Valid @RequestBody CreateCourseRequest request){
        log.info("Request POST /course: {}", request);
        var response = this.courseService.createCourse(request);
        log.info("Response from POST /course: {}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/detail/{id}")
    public BaseResponse<?> getCourseById(@PathVariable Integer id){
        log.info("Request GET /course/{}", id);
        var response = this.courseService.getCourseById(id);
        log.info("Response from GET /course/{}", response);
        return BaseResponse.ok(response);
    }

    @PutMapping("/detail/{id}")
    public BaseResponse<?> updateCourse(@Valid @RequestBody UpdateCourseRequest request, @PathVariable Integer id) {
        log.info("Request PUT /course/{}: {}",id, request);
        var response = this.courseService.updateCourse(id, request);
        log.info("Response from PUT /course/{}", response);
        return BaseResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<?> deleteCourse(@PathVariable Integer id){
        log.info("Request DELETE /course/{}", id);
        var response = this.courseService.deleteCourse(id);
        log.info("Response from DELETE /course/{}", response);
        return BaseResponse.ok(response);
    }

}
