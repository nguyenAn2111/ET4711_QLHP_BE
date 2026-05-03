package QLHP.app.domain.payload.request;

import QLHP.app.common.enums.CourseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateCourseRequest {
    @NotNull
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private Integer credit;

    @NotNull
    private CourseType type;

    private String term;
}
