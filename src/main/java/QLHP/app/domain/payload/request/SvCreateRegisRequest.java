package QLHP.app.domain.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SvCreateRegisRequest {
    @NotNull
    private Integer studentId;
    @NotNull
    private Integer courseId;
//    private String status;
    private String term;
//    private String code;
}
