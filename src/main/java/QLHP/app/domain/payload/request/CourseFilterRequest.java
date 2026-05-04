package QLHP.app.domain.payload.request;

import QLHP.app.common.enums.CourseStatus;
import QLHP.app.common.enums.CourseType;
import lombok.Data;

@Data
public class CourseFilterRequest {
    private String keyword;
    private CourseType type;
    private CourseStatus status;
    private String term;
}
