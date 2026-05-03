package QLHP.app.service.PDT;

import QLHP.app.domain.dto.RegisCreatedDto;
import QLHP.app.domain.dto.RegisViewDto;
import QLHP.app.domain.payload.request.CreateRegisRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {

    List<RegisViewDto> getAllRegis();

    RegisCreatedDto createRegis(CreateRegisRequest regisRequest);

    List<Integer> approveAllRegis();

    Integer approveRegis(Integer regisId);

    List<Integer> rejectAllRegis();

    Integer rejectRegisId(Integer id);

    boolean deleteRegis(Integer id);
}
