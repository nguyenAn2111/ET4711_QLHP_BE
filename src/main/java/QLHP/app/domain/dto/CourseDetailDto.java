package QLHP.app.domain.dto;

import QLHP.app.domain.entity.Course;
import lombok.Data;

import java.util.Date;

@Data
public class CourseDetailDto {
    private String name;
    private String code;
    private Integer credit;
    private String type;
    private String term;
}
