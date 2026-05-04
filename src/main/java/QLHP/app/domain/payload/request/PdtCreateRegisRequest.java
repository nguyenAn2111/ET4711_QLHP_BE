package QLHP.app.domain.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PdtCreateRegisRequest {
    @NotNull
    private String student_code;
    @NotNull
    private String course_code;
//    private String status;
//    private String term;
//    private String code;
}
