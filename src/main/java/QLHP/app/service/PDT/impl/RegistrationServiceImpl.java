package QLHP.app.service.PDT.impl;

import QLHP.app.common.enums.RegisStatus;
import QLHP.app.common.enums.SysError;
import QLHP.app.domain.dto.RegisCreatedDto;
import QLHP.app.domain.dto.RegisViewDto;
import QLHP.app.domain.entity.Course;
import QLHP.app.domain.entity.RegItem;
import QLHP.app.domain.entity.Student;
import QLHP.app.domain.mapper.RegisCreatedMapper;
import QLHP.app.domain.mapper.RegisViewMapper;
import QLHP.app.domain.payload.request.PdtCreateRegisRequest;
import QLHP.app.domain.payload.request.RegisFilterRequest;
import QLHP.app.domain.payload.request.SvCreateRegisRequest;
import QLHP.app.repository.PDT.CourseRepository;
import QLHP.app.repository.PDT.RegistrationRepository;
import QLHP.app.repository.PDT.specification.RegisSpecification;
import QLHP.app.repository.SV.StudentRepository;
import QLHP.app.service.PDT.RegistrationService;
import QLHP.fw.web.rest.errors.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final RegisViewMapper regisViewMapper;
    private final RegisCreatedMapper regisCreatedMapper;
    private final RegistrationRepository regisRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    @Override
    @Transactional
    public List<RegisViewDto> getAllRegis() {
        List<RegItem> regis = this.regisRepository.findAll(Sort.by(Sort.Direction.ASC, "code"));
        return this.regisViewMapper.toDto(regis);
    }

    @Override
    @Transactional
    public RegisCreatedDto SVcreateRegis(SvCreateRegisRequest regisRequest) {

        Student student = studentRepository.findById(regisRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(regisRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        RegItem regis = new RegItem();

//        regis.setStudentId(regisRequest.getStudentId());
//        regis.setCourseId(regisRequest.getCourseId());

        regis.setStudent(student);
        regis.setCourse(course);

        String code = student.getCode()+ course.getCode();
        regis.setCode(code);
        regis.setTerm(regisRequest.getTerm());
        regis.setStatus(RegisStatus.WAITING);
        regis.setCreated_at(LocalDateTime.now());

        regis = this.regisRepository.save(regis);

        return this.regisCreatedMapper.toDto(regis);
    }

    @Override
    @Transactional
    public RegisCreatedDto PDTcreateRegis(PdtCreateRegisRequest regisRequest) {

        Student student = studentRepository.findByCode(regisRequest.getStudent_code())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findByCode(regisRequest.getCourse_code())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        RegItem regis = new RegItem();

        regis.setStudent(student);
        regis.setCourse(course);

        String code = student.getCode()+ course.getCode();
        regis.setCode(code);

        regis.setStatus(RegisStatus.WAITING);
        regis.setCreated_at(LocalDateTime.now());
        regis.setTerm("2025.2");

        regis = this.regisRepository.save(regis);

        return this.regisCreatedMapper.toDto(regis);
    }

    @Override
    @Transactional
    public List<Integer> approveAllRegis() {
        List<RegItem> regisList = this.regisRepository.findAll();

        if (regisList.isEmpty()) {
            throw new RuntimeException("No Regis found");
        }

        regisList.forEach(regis -> regis.setStatus(RegisStatus.APPROVED));
        regisRepository.saveAll(regisList);

        return regisList.stream()
                .map(RegItem::getId)
                .toList();
    }

    @Override
    @Transactional
    public Integer approveRegis(Integer id) {
        RegItem regis = regisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Regis not found"));

        regis.setStatus(RegisStatus.APPROVED);

        regisRepository.save(regis);

        return regis.getId();
    }


    @Override
    @Transactional
    public Integer rejectRegisId(Integer id) {
        RegItem regis = regisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Regis not found"));

        regis.setStatus(RegisStatus.DECLINED);

        regisRepository.save(regis);

        return regis.getId();
    }

    @Override
    @Transactional
    public List<Integer> rejectAllRegis() {
        List<RegItem> regisList = this.regisRepository.findAll();

        if (regisList.isEmpty()) {
            throw new RuntimeException("No Regis found");
        }

        regisList.forEach(regis -> regis.setStatus(RegisStatus.DECLINED));
        regisRepository.saveAll(regisList);

        return regisList.stream()
                .map(RegItem::getId)
                .toList();
    }

    @Override
    public List<RegisViewDto> filterRegis(RegisFilterRequest req) {

        Specification<RegItem> spec = RegisSpecification.filter(req);

        List<RegItem> regis = regisRepository.findAll(
                spec,
                Sort.by(Sort.Direction.ASC, "id")
        );

        return regisViewMapper.toDto(regis);
    }

    @Override
    public boolean deleteRegis (Integer id){

        RegItem existingRegis = this.regisRepository.findById(id).orElseThrow(()
                -> new BadRequestException(SysError.REGISTRATION_NOT_FOUND.name()));

        this.regisRepository.delete(existingRegis);
        return true;
    }

}
