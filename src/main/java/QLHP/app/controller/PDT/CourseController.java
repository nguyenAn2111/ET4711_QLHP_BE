package QLHP.app.controller.PDT;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.CourseType;
import QLHP.app.domain.dto.CourseViewDto;
import QLHP.app.domain.payload.request.CourseFilterRequest;
import QLHP.app.domain.payload.request.CreateCourseRequest;
import QLHP.app.domain.payload.request.UpdateCourseRequest;
import QLHP.app.service.PDT.CourseService;
import QLHP.fw.web.rest.vm.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
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

    @PutMapping("/openAll")
    public BaseResponse<?> openAllCourse(){
        log.info("Request PUT /course/openAll");
        var response = this.courseService.openAllCourse();
        log.info("Response from PUT /course/openAll: {}", response);
        return BaseResponse.ok(response);
    }

    @PutMapping("/closeAll")
    public BaseResponse<?> closeAllCourse(){
        log.info("Request PUT /course/closeAll");
        var response = this.courseService.closeAllCourse();
        log.info("Response from PUT /course/closeAll: {}", response);
        return BaseResponse.ok(response);
    }

    @PutMapping("/open")
    public BaseResponse<?> openCourse(@RequestParam Integer id){
        log.info("Request PUT /course/close/{}", id);
        var response = this.courseService.openCourse(id);
        log.info("Response from PUT /course/close/{}", response);
        return BaseResponse.ok(response);
    }


    @PutMapping("/close")
    public BaseResponse<?> clodeCourse(@RequestParam Integer id){
        log.info("Request PUT /course/close/{}", id);
        var response = this.courseService.closeCourse(id);
        log.info("Response from PUT /course/close/{}", response);
        return BaseResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<?> deleteCourse(@PathVariable Integer id){
        log.info("Request DELETE /course/{}", id);
        var response = this.courseService.deleteCourse(id);
        log.info("Response from DELETE /course/{}", response);
        return BaseResponse.ok(response);
    }

    @GetMapping("/list")
    public BaseResponse<List<CourseViewDto>> filterCourses(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) CourseType type,
            @RequestParam(required = false) CourseStatus status,
            @RequestParam(required = false) String term
    ) {
        CourseFilterRequest req = new CourseFilterRequest();
        req.setKeyword(keyword);
        req.setType(type);
        req.setStatus(status);
        req.setTerm(term);

        List<CourseViewDto> result = courseService.filterCourses(req);

        return BaseResponse.ok(result);
    }

}
