package QLHP.app.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseViewDto {
    private String name;
    private String code;
    private Integer credit;
    private Date start_at;
    private Date end_at;
    private String type;
    private String status;
    private Integer regis_num;
    private String term;

}
