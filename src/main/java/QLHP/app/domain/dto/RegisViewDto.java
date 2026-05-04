package QLHP.app.domain.dto;

import QLHP.app.common.enums.RegisStatus;
import lombok.Data;

@Data
public class RegisViewDto {
    private Integer id;
    private String code;
//    private Integer student_id;
//    private Integer course_id;
    private String student_name;
    private String student_code;
    private String student_unit;
    private String course_name;
    private String course_code;
    private RegisStatus status;
    private String term;
}
