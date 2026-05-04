package QLHP.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseRegisCountDto {
    private Integer courseId;
    private Long total;
}