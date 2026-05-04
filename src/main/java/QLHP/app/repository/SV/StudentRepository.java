package QLHP.app.repository.SV;

import QLHP.app.domain.entity.Student;
import QLHP.app.domain.mapper.RegisCreatedMapper;
import QLHP.app.repository.PDT.RegistrationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    boolean existsByCodeAndIdNot(String code, Integer id);

    Optional<Student> findByCode(String code);}
