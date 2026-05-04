package QLHP.app.domain.payload.request;

import QLHP.app.common.enums.RegisStatus;
import lombok.Data;

@Data
public class RegisFilterRequest {
    private String keyword;
    private RegisStatus status;
    private String term;
    private String unit;
}
