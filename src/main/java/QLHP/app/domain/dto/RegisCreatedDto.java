package QLHP.app.domain.dto;

import lombok.Data;

@Data
public class RegisCreatedDto {
    private String student_name;
    private String student_code;
    private String term;
    private String code;
    private String course_code;
    private String course_name;
    private String course_credit;
    private String created_at;
    private String status;
}
