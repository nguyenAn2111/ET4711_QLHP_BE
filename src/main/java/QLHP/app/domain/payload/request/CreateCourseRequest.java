package QLHP.app.domain.payload.request;

import QLHP.app.common.enums.CourseType;
import com.rabbitmq.client.AMQP;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CreateCourseRequest {
    @NotNull
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private Integer credit;

    private Date startDate;

    private Date endDate;

    @NotNull
    private CourseType type;

//    @NotNull
//    private String status;

    private String term;
}
